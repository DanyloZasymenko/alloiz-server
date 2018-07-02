package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Incumbency;
import com.alloiz.alloizserver.repository.IncumbencyRepository;
import com.alloiz.alloizserver.service.IncumbencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.alloiz.alloizserver.service.utils.Validation.checkId;
import static com.alloiz.alloizserver.service.utils.Validation.checkObjectExistsById;
import static com.alloiz.alloizserver.service.utils.Validation.checkSave;
@Service
public class IncumbencyServiceImpl implements IncumbencyService {

  @Autowired
  private IncumbencyRepository incumbencyRepository;

  @Override
  public Incumbency findOneAvailable(Long id) {
    checkId(id);
    return incumbencyRepository.findByAvailableAndId(true, id);
  }

  @Override
  public List<Incumbency> findAllAvailable() {
    return incumbencyRepository.findAllByAvailable(true);
  }

  @Override
  public Incumbency findOne(Long id) {
    checkId(id);
    return incumbencyRepository.findOne(id);
  }

  @Override
  public List<Incumbency> findAll() {
    return incumbencyRepository.findAll();
  }

  @Override
  public Incumbency save(Incumbency incumbency) {
    checkSave(incumbency);
    return incumbencyRepository.save(incumbency.setAvailable(true).setOpen(false));
  }

  @Override
  public Incumbency update(Incumbency incumbency) {
    checkObjectExistsById(incumbency.getId(),incumbencyRepository);
    return save(findOne(incumbency.getId())
        .setAvailable(incumbency.getAvailable())
        .setName(incumbency.getName())
        .setOpen(incumbency.getOpen()));
  }

  @Override
  public Boolean delete(Long id) {
    try {
      incumbencyRepository.delete(checkObjectExistsById(id,incumbencyRepository));
      return true;
    } catch (Exception e){
      return false;
    }
  }
}
