package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Portfolio;
import java.util.List;


public interface PortfolioService {

  Portfolio findOneAvailable(Long id);

  List<Portfolio> findAllAvailable();

  Portfolio findOne(Long id);

  List<Portfolio> findAll();

  void save(Portfolio portfolio);

  Boolean deleteById(Long id);

}
