package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Long> {

    List<Technology> findAllByAvailable(Boolean available);

    Technology findByAvailableAndId(Boolean available, Long id);
}
