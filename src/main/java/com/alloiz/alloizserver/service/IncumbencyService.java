package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Incumbency;
import java.util.List;

public interface IncumbencyService {

  Incumbency findOneAvaliable(Long id);

  List<Incumbency> findAllAvaliable();

  Incumbency findOne(Long id);

  List<Incumbency> findAll();

  void save(Incumbency portfolio);

  Boolean deleteById(Long id);
}
