package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.PortfolioDescription;
import java.util.List;

public interface PortfolioDescriptionService {

  PortfolioDescription findOneAvailable(Long id);

  List<PortfolioDescription> findAllAvailable();

  PortfolioDescription findOne(Long id);

  List<PortfolioDescription> findAll();

  PortfolioDescription save(PortfolioDescription portfolioDescription);

  Boolean delete(Long id);

  PortfolioDescription update(PortfolioDescription portfolioDescription);

}
