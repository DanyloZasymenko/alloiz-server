package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Callback;
import com.alloiz.alloizserver.model.enums.OrderType;
import com.alloiz.alloizserver.repository.CallbackRepository;
import com.alloiz.alloizserver.service.CallbackService;
import com.alloiz.alloizserver.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.*;

@Service
public class CallbackServiceImpl implements CallbackService {

    @Autowired
    private CallbackRepository callbackRepository;

    @Autowired
    private MailService mailService;

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
        //mailService.sendCallback(callback);
        if (callback.getOrderType() == null)
            callback.setOrderType(OrderType.NONE);
        return callbackRepository.save(callback
                .setDatetime(Timestamp.valueOf(LocalDateTime.now()))
                .setAvailable(true));
    }

    @Override
    public Callback update(Callback callback) {
        checkObjectExistsById(callback.getId(), callbackRepository);
        return callbackRepository.save(findOne(callback.getId())
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
