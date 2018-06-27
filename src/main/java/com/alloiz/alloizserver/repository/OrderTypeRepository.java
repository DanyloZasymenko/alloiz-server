package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
}
