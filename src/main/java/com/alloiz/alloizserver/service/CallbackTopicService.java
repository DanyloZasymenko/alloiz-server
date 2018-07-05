package com.alloiz.alloizserver.service;

import java.util.List;

public interface CallbackTopicService {

  CallbackTopic findOneAvailable(Long id);

  List<CallbackTopic> findAllAvailable();

  CallbackTopic findOne(Long id);

  List<CallbackTopic> findAll();

  CallbackTopic save(CallbackTopic callbackTopic);

  CallbackTopic update(CallbackTopic callbackTopic);

  Boolean delete(Long id);
}
