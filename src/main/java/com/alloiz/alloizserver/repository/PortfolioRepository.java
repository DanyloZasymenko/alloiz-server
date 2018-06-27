package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Portfolio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository <Portfolio,Long> {

  List<Portfolio> findAllByAvailable(Boolean available);

  Portfolio findByAvailableAndId(Boolean available, Long id);

}
