package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.repository.ImageRepository;
import com.alloiz.alloizserver.service.ImageService;
import com.alloiz.alloizserver.service.PortfolioService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.checkId;
import static com.alloiz.alloizserver.service.utils.Validation.checkObjectExistsById;
import static com.alloiz.alloizserver.service.utils.Validation.checkSave;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private FileBuilder fileBuilder;

    @Autowired
    private PortfolioService portfolioService;

    @Override
    public Image findOneAvailable(Long id) {
        checkId(id);
        return imageRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<Image> findAllAvailable() {
        return imageRepository.findAllByAvailable(true);
    }

    @Override
    public Image findOne(Long id) {
        checkId(id);
        return imageRepository.findOne(id);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image save(Image image) {
        checkSave(image);
        return imageRepository.save(image.setAvailable(true));
    }

    @Override
    public Image save(MultipartFile multipartFile) {
        checkSave(multipartFile);
        return imageRepository.save(new Image()
                .setPath(fileBuilder.saveFile(multipartFile))
                .setAvailable(true)
                .setName(multipartFile.getOriginalFilename()));
    }

    @Override
    public Image save(MultipartFile multipartFile, Portfolio portfolio) {
        checkSave(multipartFile);
        checkSave(portfolio);
        return imageRepository.save(new Image()
                .setPath(fileBuilder.saveFile(multipartFile))
                .setAvailable(true)
                .setPortfolio(portfolio)
                .setName(multipartFile.getOriginalFilename()));
    }

    @Override
    public Image update(Image image) {
        checkObjectExistsById(image.getId(),imageRepository);
        return save(findOne(image.getId())
                .setPath(image.getPath())
                .setAvailable(image.getAvailable())
                .setName(image.getName()));
    }

    @Override
    public Boolean delete(Long id) {
        checkId(id);
        if (id != null && id >= 0) {
            Image image = findOne(id);
            if (image != null) {
                imageRepository.delete(image);
                return true;
            } else {
                return false;
            }
        } else {
            throw new NullPointerException("Id is null or less than zero");
        }
    }
}
