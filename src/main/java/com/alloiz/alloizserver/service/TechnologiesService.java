package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Technologies;

import java.util.List;

public interface TechnologiesService {

    Technologies findOneAvailable(Long id);

    List<Technologies> findAllAvailable();

    Technologies findOne(Long id);

    List<Technologies> findAll();

    Technologies save(Technologies technologies);

    Technologies update(Technologies technologies);

    Boolean delete(Long id);
}


