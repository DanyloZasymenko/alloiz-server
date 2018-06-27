package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Incumbency;
import java.util.List;

public interface IncumbencyService {

  Incumbency findOneAvailable(Long id);

  List<Incumbency> findAllAvailable();

  Incumbency findOne(Long id);

  List<Incumbency> findAll();

  void save(Incumbency incumbency);

  Boolean deleteById(Long id);
}
