package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.PortfolioDescription;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioDescriptionRepository extends JpaRepository<PortfolioDescription, Long> {

  List<PortfolioDescription> findAllByAvailable(Boolean available);

  PortfolioDescription findByAvailableAndId(Boolean available, Long id);

}
