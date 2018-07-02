package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.TechnologyDescription;
import com.alloiz.alloizserver.repository.TechnologyDescriptionRepository;
import com.alloiz.alloizserver.service.TechnologyDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.*;

@Service
public class TechnologyDescriptionServiceImpl implements TechnologyDescriptionService {

    @Autowired
    private TechnologyDescriptionRepository technologyDescriptionRepository;

    @Override
    public TechnologyDescription findOneAvailable(Long id) {
        checkId(id);
        return technologyDescriptionRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<TechnologyDescription> findAllAvailable() {
        return technologyDescriptionRepository.findAllByAvailable(true);
    }

    @Override
    public TechnologyDescription findOne(Long id) {
        checkId(id);
        return technologyDescriptionRepository.findOne(id);
    }

    @Override
    public List<TechnologyDescription> findAll() {
        return technologyDescriptionRepository.findAll();
    }

    @Override
    public TechnologyDescription save(TechnologyDescription technologyDescription) {
        checkSave(technologyDescription);
        return technologyDescriptionRepository.save(technologyDescription.setAvailable(true));
    }

    @Override
    public TechnologyDescription update(TechnologyDescription technologyDescription) {
        checkObjectExistsById(technologyDescription.getId(), technologyDescriptionRepository);
        return save(findOne(technologyDescription.getId())
                .setDescription(technologyDescription.getDescription())
                .setTechnology(technologyDescription.getTechnology())
                .setLanguage(technologyDescription.getLanguage())
                .setAvailable(technologyDescription.getAvailable()));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            technologyDescriptionRepository.delete(checkObjectExistsById(id, technologyDescriptionRepository));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
