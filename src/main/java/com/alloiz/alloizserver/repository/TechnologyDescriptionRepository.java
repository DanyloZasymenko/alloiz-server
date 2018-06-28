package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.TechnologyDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyDescriptionRepository extends JpaRepository<TechnologyDescription,Long> {

    List<TechnologyDescription> findAllByAvailable(Boolean available);

    TechnologyDescription findByAvailableAndId(Boolean available, Long id);
}

