package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Worker;

import java.util.List;

public interface WorkerService {
    Worker findOneAvaliable(Long id);

    List<Worker> findAllAvaliable();

    Worker findOne(Long id);

    List<Worker> findAll();

    void save(Worker worker);

    Boolean delete(Long id);
}
