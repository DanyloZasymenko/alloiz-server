package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Worker;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WorkerService {
    Worker findOneAvailable(Long id);

    List<Worker> findAllAvailable();

    Worker findOne(Long id);

    List<Worker> findAll();

    Worker save(Worker worker);

    Worker save(String workerJson, MultipartFile multipartFile);

    Worker update(Worker worker);

    Worker update(String workerJson, MultipartFile multipartFile);

    Worker update(String workerJson);

    Worker updateImage(MultipartFile multipartFile, Long id);

    Boolean delete(Long id);
}
