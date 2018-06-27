package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Incumbency;
import com.alloiz.alloizserver.repository.IncumbencyRepository;
import com.alloiz.alloizserver.service.IncumbencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncumbencyServiceImpl implements IncumbencyService {

  @Autowired
  private IncumbencyRepository incumbencyRepository;

  @Override
  public Incumbency findOneAvailable(Long id) {
    return incumbencyRepository.findByAvailableAndId(true,id);
  }

  @Override
  public List<Incumbency> findAllAvailable() {
    return incumbencyRepository.findAllByAvailable(true);
  }

  @Override
  public Incumbency findOne(Long id) {
    return incumbencyRepository.findOne(id);
  }

  @Override
  public List<Incumbency> findAll() {
    return incumbencyRepository.findAll();
  }

  @Override
  public void save(Incumbency incumbency) {
    incumbencyRepository.save(incumbency);
  }

  @Override
  public Boolean deleteById(Long id) {
    if(id != null && id >= 0){
      Incumbency incumbency = incumbencyRepository.findOne(id);
      if(incumbency != null){
        incumbencyRepository.delete(incumbency);
        return true;
      }
      else {
        return false;
      }
    }
    else{
      throw new NullPointerException("Id is null or less than zero");
    }
  }
}
