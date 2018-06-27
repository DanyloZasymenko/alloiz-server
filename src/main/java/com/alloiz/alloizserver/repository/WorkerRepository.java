package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    List<Worker> findAllByAvailable(Boolean available);

    Worker findByAvailableAndId(Boolean available, Long id);
}
