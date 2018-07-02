package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Portfolio;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface PortfolioService {

    Portfolio findOneAvailable(Long id);

    List<Portfolio> findAllAvailable();

    Portfolio findOne(Long id);

    List<Portfolio> findAll();

    Portfolio save(String portfolioJson, MultipartFile[] multipartFiles);

    Portfolio save(Portfolio portfolio);

    Boolean deleteById(Long id);

    Portfolio update(String portfolioJson);

    Portfolio updateImage(MultipartFile multipartFile, Long id);

}
