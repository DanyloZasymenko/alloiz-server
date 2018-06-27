package com.alloiz.alloizserver.service;


import com.alloiz.alloizserver.model.Callback;

import java.util.List;

public interface CallbackService {
    Callback findOneAvaliable(Long id);

    List<Callback> findAllAvaliable();

    Callback findOne(Long id);

    List<Callback> findAll();

    void save(Callback callback);

    Boolean delete(Long id);
}
