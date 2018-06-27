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
    public Technologies findOneAvaliable(Long id) {
        return null;
    }

    @Override
    public List<Technologies> findAllAvaliable() {
        return null;
    }

    @Override
    public Technologies findOne(Long id) {
        return null;
    }

    @Override
    public List<Technologies> findAll() {
        return null;
    }

    @Override
    public void save(Technologies technologies) {

    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
