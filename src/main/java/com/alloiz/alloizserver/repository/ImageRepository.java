package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.model.Incumbency;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

  List<Image> findAllByAvailable(Boolean available);

  Image findByAvailableAndId(Boolean available, Long id);

}
