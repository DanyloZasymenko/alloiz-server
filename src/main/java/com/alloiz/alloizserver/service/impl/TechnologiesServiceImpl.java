package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Technologies;
import com.alloiz.alloizserver.repository.TechnologiesRepository;
import com.alloiz.alloizserver.service.TechnologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologiesServiceImpl implements TechnologiesService {

    @Autowired
    private TechnologiesRepository technologiesRepository;

    @Override
    public Technologies findOneAvailable(Long id) {
        return technologiesRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Technologies> findAllAvailable() {
        return technologiesRepository.findAllByAvailable(true);
    }

    @Override
    public Technologies findOne(Long id) {
        return technologiesRepository.findOne(id);
    }

    @Override
    public List<Technologies> findAll() {
        return technologiesRepository.findAll();
    }

    @Override
    public Technologies save(Technologies technologies) {
        return technologiesRepository.save(technologies);
    }

    @Override
    public Technologies update(Technologies technologies) {
        return save(findOne(technologies.getId())
                    .setName(technologies.getName())
                    .setImage(technologies.getImage())
                    .setDescription(technologies.getDescription())
                    .setAvailable(technologies.getAvailable()));
    }

    @Override
    public Boolean delete(Long id) {
       if(id != null && id >= 0){
           Technologies technologies = technologiesRepository.findOne(id);
           if(technologies != null){
               technologiesRepository.delete(technologies);
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
