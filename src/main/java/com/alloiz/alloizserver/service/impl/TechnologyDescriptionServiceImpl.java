package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.TechnologyDescription;
import com.alloiz.alloizserver.repository.TechnologyDescriptionRepository;
import com.alloiz.alloizserver.service.TechnologyDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyDescriptionServiceImpl implements TechnologyDescriptionService {

    @Autowired
    private TechnologyDescriptionRepository technologyDescriptionRepository;

    @Override
    public TechnologyDescription findOneAvailable(Long id) {
        return technologyDescriptionRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<TechnologyDescription> findAllAvailable() {
        return technologyDescriptionRepository.findAllByAvailable(true);
    }

    @Override
    public TechnologyDescription findOne(Long id) {
        return technologyDescriptionRepository.findOne(id);
    }

    @Override
    public List<TechnologyDescription> findAll() {
        return technologyDescriptionRepository.findAll();
    }

    @Override
    public TechnologyDescription save(TechnologyDescription technologyDescription) {
        return technologyDescriptionRepository.save(technologyDescription.setAvailable(true));
    }

    @Override
    public TechnologyDescription update(TechnologyDescription technologyDescription) {
        return save(findOne(technologyDescription.getId())
                    .setDescription(technologyDescription.getDescription())
                    .setTechnology(technologyDescription.getTechnology())
                    .setLanguage(technologyDescription.getLanguage())
                    .setAvailable(technologyDescription.getAvailable()));
    }

    @Override
    public Boolean delete(Long id) {
        if(id != null && id >= 0){
            TechnologyDescription technologyDescription = findOne(id);
            if(technologyDescription != null){
                technologyDescriptionRepository.delete(technologyDescription);
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
