package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.CallbackTopic;
import com.alloiz.alloizserver.repository.CallbackTopicRepository;
import com.alloiz.alloizserver.service.CallbackTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.checkId;
import static com.alloiz.alloizserver.service.utils.Validation.checkObjectExistsById;
import static com.alloiz.alloizserver.service.utils.Validation.checkSave;

@Service
public class CallbackTopicServiceImpl implements CallbackTopicService {

    @Autowired
    private CallbackTopicRepository callbackTopicRepository;

    @Override
    public CallbackTopic findOneAvailable(Long id) {
        checkId(id);
        return callbackTopicRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<CallbackTopic> findAllAvailable() {
        return callbackTopicRepository.findAllByAvailable(true);
    }

    @Override
    public CallbackTopic findOne(Long id) {
        checkId(id);
        return callbackTopicRepository.findOne(id);
    }

    @Override
    public List<CallbackTopic> findAll() {
        return callbackTopicRepository.findAll();
    }

    @Override
    public CallbackTopic save(CallbackTopic callbackTopic) {
        checkSave(callbackTopic);
        return callbackTopicRepository.save(callbackTopic.setAvailable(true));
    }

    @Override
    public CallbackTopic update(CallbackTopic callbackTopic) {
        checkObjectExistsById(callbackTopic.getId(),callbackTopicRepository);
        return save(findOne(callbackTopic.getId())
                    .setName(callbackTopic.getName())
                    .setAvailable(callbackTopic.getAvailable()));
    }

    @Override
    public Boolean delete(Long id) {
        checkId(id);
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
