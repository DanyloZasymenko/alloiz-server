package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Callback;
import com.alloiz.alloizserver.repository.CallbackRepository;
import com.alloiz.alloizserver.service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallbackServiceImpl implements CallbackService {

    @Autowired
    private CallbackRepository callbackRepository;

    @Override
    public Callback findOneAvailable(Long id) {
        return callbackRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Callback> findAllAvailable() {
        return callbackRepository.findAllByAvailable(true);
    }

    @Override
    public Callback findOne(Long id) {
        return callbackRepository.findOne(id);
    }

    @Override
    public List<Callback> findAll() {
        return callbackRepository.findAll();
    }

    @Override
    public Callback save(Callback callback) {
       return callbackRepository.save(callback);
    }

    @Override
    public Boolean delete(Long id) {
        if(id != null && id >= 0){
            Callback callback = callbackRepository.findOne(id);
            if(callback != null){
                callbackRepository.delete(callback);
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
