package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.repository.PortfolioRepository;
import com.alloiz.alloizserver.service.ImageService;
import com.alloiz.alloizserver.service.PortfolioService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.config.mapper.JsonMapper.json;
import static com.alloiz.alloizserver.service.utils.Validation.*;


@Service
public class PortfolioServiceImpl implements PortfolioService {
    private static final Logger LOGGER = Logger.getLogger(PortfolioServiceImpl.class);

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private FileBuilder fileBuilder;

    @Autowired
    private ImageService imageService;

    @Override
    public Portfolio findOneAvailable(Long id) {
        checkId(id);
        return portfolioRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Portfolio> findAllAvailable() {
        return portfolioRepository.findAllByAvailable(true);
    }

    @Override
    public Portfolio findOne(Long id) {
        checkId(id);
        return portfolioRepository.findOne(id);
    }

    @Override
    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    @Override
    public Portfolio save(String portfolioJson, MultipartFile[] multipartFiles) {
        checkJson(portfolioJson);
        Portfolio portfolio = json(portfolioJson, Portfolio.class);

        portfolio.setDescriptions(portfolio.getDescriptions().stream()
                .map(technologyDescription -> technologyDescription
                        .setPortfolio(portfolio).setAvailable(true)).collect(Collectors.toList()));

        portfolio.setDescriptions(portfolio.getDescriptions().stream()
                .map(portfolioDescription -> portfolioDescription
                        .setPortfolio(portfolio).setAvailable(true)).collect(Collectors.toList()));
        List<Image> images = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            images.add(imageService.save(file, portfolio));
        }
        return save(portfolio.setImages(images));
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio.setAvailable(true));
    }

    @Override
    public Portfolio update(Portfolio portfolio) {
        checkObjectExistsById(portfolio.getId(),portfolioRepository);
        return save(findOne(portfolio.getId())
                .setName(portfolio.getName())
                .setAvailable(portfolio.getAvailable())
                .setDescriptions(portfolio.getDescriptions())
                .setLink(portfolio.getLink())
                .setImages(portfolio.getImages()));

    }

    @Override
    public Portfolio updateImage(MultipartFile[] multipartFile, Long id) {
        checkId(id);
        Portfolio portfolio = findOne(id);
        for (MultipartFile file : multipartFile) {
            imageService.save(file, portfolio);
        }
        return portfolio;
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
