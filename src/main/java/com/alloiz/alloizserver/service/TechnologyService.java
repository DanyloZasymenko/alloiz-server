package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Technology;

import java.util.List;

public interface TechnologyService {

    Technology findOneAvailable(Long id);

    List<Technology> findAllAvailable();

    Technology findOne(Long id);

    List<Technology> findAll();

    Technology save(Technology technologies);

    Technology update(Technology technologies);

    Boolean delete(Long id);
}


