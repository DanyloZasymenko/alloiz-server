package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.CallbackTopic;
import java.util.List;

public interface CallbackTopicService {

  CallbackTopic findOneAvaliable(Long id);

  List<CallbackTopic> findAllAvaliable();

  CallbackTopic findOne(Long id);

  List<CallbackTopic> findAll();

  void save(CallbackTopic callbackTopic);

  Boolean deleteById(Long id);
}
