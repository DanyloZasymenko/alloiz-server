package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Portfolio;
import java.util.List;


public interface PortfolioService {

  Portfolio findOneAvailable(Long id);

  List<Portfolio> findAllAvailable();

  Portfolio findOne(Long id);

  List<Portfolio> findAll();

  Portfolio save(Portfolio portfolio);

  Boolean deleteById(Long id);

  Portfolio uptade (Portfolio portfolio);

}
