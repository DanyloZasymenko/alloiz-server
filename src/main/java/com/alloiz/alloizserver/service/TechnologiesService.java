package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Technologies;

import java.util.List;

public interface TechnologiesService {

    Technologies findOneAvaliable(Long id);

    List<Technologies> findAllAvaliable();

    Technologies findOne(Long id);

    List<Technologies> findAll();

    void save(Technologies technologies);

    Boolean delete(Long id);
}


