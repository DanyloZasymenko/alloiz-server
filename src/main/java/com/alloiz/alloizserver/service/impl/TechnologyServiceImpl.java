package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.repository.TechnologyRepository;
import com.alloiz.alloizserver.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

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
        return technologyRepository.save(technologies);
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
