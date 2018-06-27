package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Incumbency;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncumbencyRepository extends JpaRepository<Incumbency,Long> {

  List<Incumbency> findAllByAvailable(Boolean available);

  Incumbency findByAvailableAndId(Boolean available, Long id);
}
