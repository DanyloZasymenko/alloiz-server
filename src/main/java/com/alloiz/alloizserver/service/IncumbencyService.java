package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Incumbency;
import java.util.List;

public interface IncumbencyService {

  Incumbency findOneAvailable(Long id);

  List<Incumbency> findAllAvailable();

  Incumbency findOne(Long id);

  List<Incumbency> findAll();

  Incumbency save(Incumbency incumbency);

  Boolean delete(Long id);

  Incumbency update(Incumbency incumbency);
}
