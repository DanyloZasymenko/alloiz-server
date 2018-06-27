package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Worker;
import com.alloiz.alloizserver.repository.WorkerRepository;
import com.alloiz.alloizserver.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker findOneAvailable(Long id) {
        return workerRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Worker> findAllAvailable() {
        return workerRepository.findAllByAvailable(true);
    }

    @Override
    public Worker findOne(Long id) {
        return workerRepository.findOne(id);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Boolean delete(Long id) {
        if(id != null && id >= 0){
            Worker worker = workerRepository.findOne(id);
            if(worker != null){
                workerRepository.delete(worker);
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
