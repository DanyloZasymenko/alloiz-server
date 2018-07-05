package com.alloiz.alloizserver.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {

  List<OrderType> findAllByAvailable(Boolean available);

  OrderType findByAvailableAndId(Boolean available, Long id);
}
