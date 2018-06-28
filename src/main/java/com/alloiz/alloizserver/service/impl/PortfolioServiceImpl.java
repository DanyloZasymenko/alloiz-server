package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.repository.PortfolioRepository;
import com.alloiz.alloizserver.service.ImageService;
import com.alloiz.alloizserver.service.PortfolioService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.alloiz.alloizserver.config.mapper.JsonMapper.json;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private FileBuilder fileBuilder;

    @Autowired
    private ImageService imageService;

    @Override
    public Portfolio findOneAvailable(Long id) {
        return portfolioRepository.findByAvailableAndId(true, id);
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
    public Portfolio save(String portfolioJson, MultipartFile[] multipartFiles) {
        Portfolio portfolio = json(portfolioJson, Portfolio.class);
        List<Image> images = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            images.add(imageService.save(file));
        }
        return save(portfolio.setImages(images));
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio.setAvailable(true));
    }

    @Override
    public Portfolio update(Portfolio portfolio) {
        return save(findOne(portfolio.getId())
                .setName(portfolio.getName())
                .setAvailable(portfolio.getAvailable())
                .setDescriptions(portfolio.getDescriptions())
                .setLink(portfolio.getLink())
                .setImages(portfolio.getImages()));

    }

    @Override
    public Boolean deleteById(Long id) {
        if (id != null && id >= 0) {
            Portfolio portfolio = portfolioRepository.findOne(id);
            if (portfolio != null) {
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
