package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.PortfolioDescription;
import com.alloiz.alloizserver.repository.PortfolioDescriptionRepository;
import com.alloiz.alloizserver.service.PortfolioDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.*;

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
        checkObjectExistsById(portfolioDescription.getId(), portfolioDescriptionRepository);
        return save(findOne(portfolioDescription.getId())
                .setDescription(portfolioDescription.getDescription())
                .setLanguage(portfolioDescription.getLanguage())
                .setAvailable(portfolioDescription.getAvailable())
        );

    }

    @Override
    public Boolean delete(Long id) {
        try {
            portfolioDescriptionRepository.delete(checkObjectExistsById(id, portfolioDescriptionRepository));
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
