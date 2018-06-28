package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.TechnologyDescription;

import java.util.List;

public interface TechnologyDescriptionService {

    TechnologyDescription findOneAvailable(Long id);

    List<TechnologyDescription> findAllAvailable();

    TechnologyDescription findOne(Long id);

    List<TechnologyDescription> findAll();

    TechnologyDescription save(TechnologyDescription technologyDescription);

    TechnologyDescription update(TechnologyDescription technologyDescription);

    Boolean delete(Long id);
}
