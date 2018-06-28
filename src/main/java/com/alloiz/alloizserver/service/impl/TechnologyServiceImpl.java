package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.repository.TechnologyRepository;
import com.alloiz.alloizserver.service.TechnologyService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.alloiz.alloizserver.config.mapper.JsonMapper.json;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private FileBuilder fileBuilder;

    @Override
    public Technology findOneAvailable(Long id) {
        return technologyRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Technology> findAllAvailable() {
        return technologyRepository.findAllByAvailable(true);
    }

    @Override
    public Technology findOne(Long id) {
        return technologyRepository.findOne(id);
    }

    @Override
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Technology save(Technology technologies) {
        return technologyRepository.save(technologies.setAvailable(true));
    }

    @Override
    public Technology save(String technologyJson, MultipartFile multipartFile) {
        Technology technology = json(technologyJson, Technology.class);
        if(multipartFile != null)
            technology.setImage(fileBuilder.saveFile(multipartFile));
        return technology;
    }

    @Override
    public Technology update(Technology technologies) {
        return save(findOne(technologies.getId())
                    .setName(technologies.getName())
                    .setImage(technologies.getImage())
                    .setDescriptions(technologies.getDescriptions())
                    .setAvailable(technologies.getAvailable()));
    }

    @Override
    public Technology updateImage(MultipartFile multipartFile, Long id) {
        return findOne(id).setImage(fileBuilder.saveFile(multipartFile));
    }

    @Override
    public Boolean delete(Long id) {
       if(id != null && id >= 0){
           Technology technologies = technologyRepository.findOne(id);
           if(technologies != null){
               technologyRepository.delete(technologies);
                return true;
           }
           else {
               return false;
           }
       }
       else{
            throw new NullPointerException("Id is null or less than zero");
       }
    }
}
