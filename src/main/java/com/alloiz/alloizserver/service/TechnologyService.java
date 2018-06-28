package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Technology;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TechnologyService {

    Technology findOneAvailable(Long id);

    List<Technology> findAllAvailable();

    Technology findOne(Long id);

    List<Technology> findAll();

    Technology save(String technologyJson, MultipartFile multipartFile);

    Technology save(Technology technologies);

    Technology update(Technology technologies);

    Technology updateImage(MultipartFile multipartFile, Long id);

    Boolean delete(Long id);
}


