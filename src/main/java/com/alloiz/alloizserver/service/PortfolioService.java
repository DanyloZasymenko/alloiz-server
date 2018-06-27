package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Portfolio;
import java.util.List;

public interface PortfolioService {

  Portfolio findOneAvaliable(Long id);

  List<Portfolio> findAllAvaliable();

  Portfolio findOne(Long id);

  List<Portfolio> findAll();

  void save(Portfolio portfolio);

  Boolean deleteById(Long id);

}
