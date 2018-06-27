package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.CallbackTopic;
import java.util.List;

public interface CallbackTopicService {

  CallbackTopic findOneAvailable(Long id);

  List<CallbackTopic> findAllAvailable();

  CallbackTopic findOne(Long id);

  List<CallbackTopic> findAll();

  void save(CallbackTopic callbackTopic);

  Boolean deleteById(Long id);
}
