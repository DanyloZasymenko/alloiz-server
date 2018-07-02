package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.PortfolioDescription;
import com.alloiz.alloizserver.repository.PortfolioDescriptionRepository;
import com.alloiz.alloizserver.service.PortfolioDescriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.alloiz.alloizserver.service.utils.Validation.checkId;
import static com.alloiz.alloizserver.service.utils.Validation.checkSave;

@Service
public class PortfolioDescriptionServiceImpl implements PortfolioDescriptionService {

  @Autowired
  private PortfolioDescriptionRepository portfolioDescriptionRepository;

  @Override
  public PortfolioDescription findOneAvailable(Long id) {
    checkId(id);
    return portfolioDescriptionRepository.findByAvailableAndId(true, id);
  }

  @Override
  public List<PortfolioDescription> findAllAvailable() {
    return portfolioDescriptionRepository.findAllByAvailable(true);
  }

  @Override
  public PortfolioDescription findOne(Long id) {
    checkId(id);
    return portfolioDescriptionRepository.findOne(id);
  }

  @Override
  public List<PortfolioDescription> findAll() {
    return portfolioDescriptionRepository.findAll();
  }

  @Override
  public PortfolioDescription save(PortfolioDescription portfolio) {
    checkSave(portfolio);
    return portfolioDescriptionRepository.save(portfolio.setAvailable(true));
  }

  @Override
  public PortfolioDescription update(PortfolioDescription portfolioDescription) {
    checkSave(portfolioDescription);
    return save(findOne(portfolioDescription.getId())
        .setDescription(portfolioDescription.getDescription())
        .setLanguage(portfolioDescription.getLanguage())
        .setAvailable(portfolioDescription.getAvailable())
    );

  }

  @Override
  public Boolean delete(Long id) {
    if (id != null && id >= 0) {
      PortfolioDescription portfolioDescription = portfolioDescriptionRepository.findOne(id);
      if (portfolioDescription != null) {
        portfolioDescriptionRepository.delete(portfolioDescription);
        return true;
      } else {
        return false;
      }
    } else {
      throw new NullPointerException("Id is null or less than zero");
    }
  }


}
