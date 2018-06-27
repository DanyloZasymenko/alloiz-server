package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.OrderType;
import com.alloiz.alloizserver.repository.OrderTypeRepository;
import com.alloiz.alloizserver.service.OrderTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class OrderTypeServiceImpl implements OrderTypeService {

  @Autowired
  private OrderTypeRepository orderTypeRepository;

  @Override
  public OrderType findOneAvailable(Long id) {
    return orderTypeRepository.findByAvailableAndId(true,id);
  }

  @Override
  public List<OrderType> findAllAvailable() {
    return orderTypeRepository.findAllByAvailable(true);
  }

  @Override
  public OrderType findOne(Long id) {
    return orderTypeRepository.findOne(id);
  }

  @Override
  public List<OrderType> findAll() {
    return orderTypeRepository.findAll();
  }

  @Override
  public void save(OrderType orderType) {
    orderTypeRepository.save(orderType);
  }

  @Override
  public Boolean deleteById(Long id) {
    if(id != null && id >= 0){
      OrderType orderType = orderTypeRepository.findOne(id);
      if(orderType != null){
        orderTypeRepository.delete(orderType);
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
