package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByAvailable(Boolean available);

    Image findByAvailableAndId(Boolean available, Long id);

    List<Image> findAllByPortfolioNull();

}
