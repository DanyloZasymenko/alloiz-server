package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.PortfolioDescription;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioDescriptionRepository extends JpaRepository<PortfolioDescriptionRepository, Long> {

  List<PortfolioDescription> findAllByAvailable(Boolean available);

  PortfolioDescription findByAvailableAndId(Boolean available, Long id);

}
