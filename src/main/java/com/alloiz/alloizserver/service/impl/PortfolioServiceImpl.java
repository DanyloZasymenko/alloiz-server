package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.repository.PortfolioRepository;
import com.alloiz.alloizserver.service.PortfolioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

  @Autowired
  private PortfolioRepository portfolioRepository;

  @Override
  public Portfolio findOneAvailable(Long id) {
    return portfolioRepository.findByAvailableAndId(true,id);
  }

  @Override
  public List<Portfolio> findAllAvailable() {
    return portfolioRepository.findAllByAvailable(true);
  }

  @Override
  public Portfolio findOne(Long id) {
    return portfolioRepository.findOne(id);
  }

  @Override
  public List<Portfolio> findAll() {
    return portfolioRepository.findAll();
  }

  @Override
  public void save(Portfolio portfolio) {
    portfolioRepository.save(portfolio);
  }

  @Override
  public Boolean deleteById(Long id) {
    if(id != null && id >=0){
      Portfolio portfolio = portfolioRepository.findOne(id);
      if(portfolio != null){
        portfolioRepository.delete(portfolio);
        return true;
      } else {
        return false;
      }
    } else {
      throw new NullPointerException("Id is null or less than zero");
    }
  }

}
