package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.repository.TechnologyRepository;
import com.alloiz.alloizserver.service.TechnologyService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.config.mapper.JsonMapper.json;
import static com.alloiz.alloizserver.service.utils.Validation.*;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    private static final Logger LOGGER = Logger.getLogger(TechnologyServiceImpl.class);

    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private FileBuilder fileBuilder;
    @Autowired
    private TechnologyDescriptionServiceImpl technologyDescriptionService;

    @Override
    public Technology findOneAvailable(Long id) {
        checkId(id);
        return technologyRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Technology> findAllAvailable() {
        return technologyRepository.findAllByAvailable(true);
    }

    @Override
    public Technology findOne(Long id) {
        checkId(id);
        return technologyRepository.findOne(id);
    }

    @Override
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Technology save(Technology technologies) {
        checkSave(technologies);
        return technologyRepository.save(technologies.setAvailable(true));
    }

    @Override
    public Technology save(String technologyJson, MultipartFile multipartFile) {
        checkJson(technologyJson);
        Technology technology = json(technologyJson, Technology.class);

        technology.setDescriptions(technology.getDescriptions().stream()
                .map(technologyDescription -> technologyDescription
                        .setTechnology(technology).setAvailable(true)).collect(Collectors.toList()));

        if (multipartFile != null) {
            technology.setImage(fileBuilder.saveFile(multipartFile));
        }
        return save(technology);
    }

    @Override
    public Technology update(Technology technologies) {
        checkObjectExistsById(technologies.getId(), technologyRepository);
        return save(findOne(technologies.getId())
                .setName(technologies.getName())
                .setImage(technologies.getImage())
                .setDescriptions(technologies.getDescriptions())
                .setAvailable(technologies.getAvailable()));
    }

    @Override
    public Technology update(String technologyJson, MultipartFile multipartFile) {
        checkJson(technologyJson);
        Technology technology = json(technologyJson, Technology.class);
        checkObjectExistsById(technology.getId(), technologyRepository);
        if (multipartFile != null) {
            technology.setImage(fileBuilder.saveFile(multipartFile));
        }
        return save(technology
                .setDescriptions(technology.getDescriptions())
                .setName(technology.getName())
                .setAvailable(technology.getAvailable())
        );
    }

    @Override
    public Technology update(String technologyJson) {
        checkJson(technologyJson);
        Technology technology = json(technologyJson, Technology.class);
        checkObjectExistsById(technology.getId(), technologyRepository);
        return save(technology
                .setDescriptions(technology.getDescriptions())
                .setName(technology.getName())
                .setAvailable(technology.getAvailable())
        );
    }

    @Override
    public Technology updateImage(MultipartFile multipartFile, Long id) {
        checkId(id);
        return findOne(id).setImage(fileBuilder.saveFile(multipartFile));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            Technology technology = checkObjectExistsById(id, technologyRepository);
            File file = new File("file:/" + System.getProperty("catalina.home") + technology.getImage());
            LOGGER.info(file.delete() ? "delete file:[" + technology.getImage() + "]" : "error delete file");
            technologyRepository.delete(technology);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
