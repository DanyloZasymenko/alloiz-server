package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    Image findOneAvailable(Long id);

    List<Image> findAllAvailable();

    Image findOne(Long id);

    List<Image> findAll();

    Image save(Image image);

    Image save(MultipartFile multipartFile);

    Image save(MultipartFile multipartFile, Long portfolioId);

    Image update(Image image);

    Boolean delete(Long id);

    List<Image> findAllByPortfolioNull();

    void deleteAllByPortfolioNull();
}
