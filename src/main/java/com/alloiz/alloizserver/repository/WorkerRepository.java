package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
}