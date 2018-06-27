package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologiesRepository extends JpaRepository<Technologies,Long> {
}
