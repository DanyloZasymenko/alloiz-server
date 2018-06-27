package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Callback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallbackRepository extends JpaRepository<Callback, Long> {
}
