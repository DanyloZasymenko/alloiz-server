package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Worker;

import java.util.List;

public interface WorkerService {
    Worker findOneAvailable(Long id);

    List<Worker> findAllAvailable();

    Worker findOne(Long id);

    List<Worker> findAll();

    Worker save(Worker worker);

    Worker update(Worker worker);

    Boolean delete(Long id);
}
