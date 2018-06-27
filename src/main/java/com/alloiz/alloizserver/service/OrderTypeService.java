package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.OrderType;
import java.util.List;

public interface OrderTypeService {

  OrderType findOneAvaliable(Long id);

  List<OrderType> findAllAvaliable();

  OrderType findOne(Long id);

  List<OrderType> findAll();

  void save(OrderType portfolio);

  Boolean deleteById(Long id);
}
