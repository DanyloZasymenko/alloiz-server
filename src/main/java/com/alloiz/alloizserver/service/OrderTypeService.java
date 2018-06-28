package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.OrderType;
import java.util.List;

public interface OrderTypeService {

  OrderType findOneAvailable(Long id);

  List<OrderType> findAllAvailable();

  OrderType findOne(Long id);

  List<OrderType> findAll();

  OrderType save(OrderType orderType);

  Boolean delete(Long id);

  OrderType update(OrderType orderType);
}
