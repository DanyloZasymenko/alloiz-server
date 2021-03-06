package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Worker;
import com.alloiz.alloizserver.repository.WorkerRepository;
import com.alloiz.alloizserver.service.IncumbencyService;
import com.alloiz.alloizserver.service.WorkerService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

import static com.alloiz.alloizserver.config.mapper.JsonMapper.json;
import static com.alloiz.alloizserver.service.utils.Validation.*;

@Service
public class WorkerServiceImpl implements WorkerService {

    private static final Logger LOGGER = Logger.getLogger(WorkerServiceImpl.class);

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private FileBuilder fileBuilder;

    @Autowired
    private IncumbencyService incumbencyService;

    @Override
    public Worker findOneAvailable(Long id) {
        checkId(id);
        return workerRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Worker> findAllAvailable() {
        return workerRepository.findAllByAvailable(true);
    }

    @Override
    public Worker findOne(Long id) {
        checkId(id);
        return workerRepository.findOne(id);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker save(Worker worker) {
        checkSave(worker);

        return workerRepository.save(worker.setAvailable(true));
    }

    @Override
    public Worker update(Worker worker) {
        checkObjectExistsById(worker.getId(), workerRepository);
        return workerRepository.save(findOne(worker.getId())
                .setName(worker.getName())
                .setSurname(worker.getSurname())
                .setImage(worker.getImage())
                .setAvailable(worker.getAvailable())
                .setIncumbencies(worker.getIncumbencies()));
    }

    @Override
    public Worker update(String workerJson, MultipartFile multipartFile) {
        checkJson(workerJson);
        Worker worker = json(workerJson, Worker.class);
        checkObjectExistsById(worker.getId(), workerRepository);
        if (multipartFile != null && !multipartFile.isEmpty())
            worker.setImage(fileBuilder.saveFile(multipartFile));
        return workerRepository.save(worker.setName(worker.getName())
                .setSurname(worker.getSurname())
                .setAvailable(worker.getAvailable())
                .setIncumbencies(worker.getIncumbencies()));
    }

    @Override
    public Worker update(String workerJson) {
        checkJson(workerJson);
        Worker worker = json(workerJson, Worker.class);
        checkObjectExistsById(worker.getId(), workerRepository);
        return workerRepository.save(worker.setName(worker.getName())
                .setSurname(worker.getSurname())
                .setAvailable(worker.getAvailable())
                .setIncumbencies(worker.getIncumbencies()));
    }

    @Override
    public Worker save(String workerJson, MultipartFile multipartFile) {
        checkJson(workerJson);
        Worker worker = json(workerJson, Worker.class);
        worker.getIncumbencies().stream().forEach(incumbency -> incumbencyService.save(incumbency));
        if (multipartFile != null)
            worker.setImage(fileBuilder.saveFile(multipartFile));
        return workerRepository.save(worker);
    }

    @Override
    public Worker updateImage(MultipartFile multipartFile, Long id) {
        checkId(id);
        return findOne(id)
                .setImage(fileBuilder.saveFile(multipartFile));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            Worker worker = checkObjectExistsById(id, workerRepository);
            File file = new File("file:/" + System.getProperty("catalina.home") + worker.getImage());
            LOGGER.info(file.delete() ? "delete file:[" + worker.getImage() + "]" : "error delete file");
            workerRepository.delete(worker);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
