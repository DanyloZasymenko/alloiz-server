package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.CallbackTopic;
import com.alloiz.alloizserver.repository.CallbackTopicRepository;
import com.alloiz.alloizserver.service.CallbackTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallbackTopicServiceImpl implements CallbackTopicService {

    @Autowired
    private CallbackTopicRepository callbackTopicRepository;

    @Override
    public CallbackTopic findOneAvailable(Long id) {
        return callbackTopicRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<CallbackTopic> findAllAvailable() {
        return callbackTopicRepository.findAllByAvailable(true);
    }

    @Override
    public CallbackTopic findOne(Long id) {
        return callbackTopicRepository.getOne(id);
    }

    @Override
    public List<CallbackTopic> findAll() {
        return callbackTopicRepository.findAll();
    }

    @Override
    public CallbackTopic save(CallbackTopic callbackTopic) {
        callbackTopicRepository.save(callbackTopic);
        return callbackTopic;
    }

    @Override
    public Boolean delete(Long id) {
        if (id != null && id >= 0) {
            CallbackTopic callbackTopic = callbackTopicRepository.findOne(id);
            if (callbackTopic != null) {
                callbackTopicRepository.delete(callbackTopic);
                return true;
            } else {
                return false;
            }
        } else {
            throw new NullPointerException("Id is null or less than zero");
        }
    }
}
