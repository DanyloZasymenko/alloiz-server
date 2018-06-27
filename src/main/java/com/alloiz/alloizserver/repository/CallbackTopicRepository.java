package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.CallbackTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallbackTopicRepository extends JpaRepository<CallbackTopic,Long> {
    List<CallbackTopic> findAllByAvailable(Boolean available);

    CallbackTopic findByAvailableAndId(Boolean available, Long id);
}
