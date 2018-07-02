package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Callback;
import com.alloiz.alloizserver.repository.CallbackRepository;
import com.alloiz.alloizserver.service.CallbackService;
import com.alloiz.alloizserver.service.utils.Validation;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.checkId;
import static com.alloiz.alloizserver.service.utils.Validation.checkObjectExistsById;
import static com.alloiz.alloizserver.service.utils.Validation.checkSave;

@Service
public class CallbackServiceImpl implements CallbackService {

    @Autowired
    private CallbackRepository callbackRepository;

    @Override
    public Callback findOneAvailable(Long id) {
        checkId(id);
        return callbackRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Callback> findAllAvailable() {
        return callbackRepository.findAllByAvailable(true);
    }

    @Override
    public Callback findOne(Long id) {
        checkId(id);
        return callbackRepository.findOne(id);
    }

    @Override
    public List<Callback> findAll() {
        return callbackRepository.findAll();
    }

    @Override
    public Callback save(Callback callback) {
        checkSave(callback);
       return callbackRepository.save(callback
               .setDatetime(Timestamp.valueOf(LocalDateTime.now()))
               .setAvailable(true));
    }

    @Override
    public Callback update(Callback callback) {
        checkObjectExistsById(callback.getId(),callbackRepository);
        return save(findOne(callback.getId())
                    .setPhone(callback.getPhone())
                    .setAvailable(callback.getAvailable()));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            callbackRepository.delete(checkObjectExistsById(id, callbackRepository));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
