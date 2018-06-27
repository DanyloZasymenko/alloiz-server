package com.alloiz.alloizserver.repository;

import com.alloiz.alloizserver.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository <Portfolio,Long> {

}
