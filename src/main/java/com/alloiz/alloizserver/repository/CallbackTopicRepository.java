package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.CallbackTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallbackTopicRepository extends JpaRepository<CallbackTopic,Long> {
}
