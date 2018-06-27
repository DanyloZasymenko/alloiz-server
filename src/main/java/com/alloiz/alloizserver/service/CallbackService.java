package com.alloiz.alloizserver.service;


import com.alloiz.alloizserver.model.Callback;

import java.util.List;

public interface CallbackService {
    Callback findOneAvailable(Long id);

    List<Callback> findAllAvailable();

    Callback findOne(Long id);

    List<Callback> findAll();

    Callback save(Callback callback);

    Boolean delete(Long id);
}
