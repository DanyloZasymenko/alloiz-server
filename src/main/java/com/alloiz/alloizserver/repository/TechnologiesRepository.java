package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technologies,Long> {

    List<Technologies> findAllByAvailable(Boolean available);

    Technologies findByAvailableAndId(Boolean available, Long id);
}
