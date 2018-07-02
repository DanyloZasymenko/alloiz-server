package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.repository.ImageRepository;
import com.alloiz.alloizserver.service.ImageService;
import com.alloiz.alloizserver.service.PortfolioService;
import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.*;

@Service
public class ImageServiceImpl implements ImageService {

    public static final Logger LOGGER = Logger.getLogger(ImageServiceImpl.class);

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
    public Image save(MultipartFile multipartFile, Long portfolioId) {
        checkSave(multipartFile);
        checkId(portfolioId);
        return imageRepository.save(new Image()
                .setPath(fileBuilder.saveFile(multipartFile))
                .setAvailable(true)
                .setPortfolio(portfolioService.findOne(portfolioId))
                .setName(multipartFile.getOriginalFilename()));
    }

    @Override
    public Image update(Image image) {
        checkObjectExistsById(image.getId(), imageRepository);
        return save(findOne(image.getId())
                .setPath(image.getPath())
                .setAvailable(image.getAvailable())
                .setName(image.getName()));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            Image image = checkObjectExistsById(id, imageRepository);
            File file = new File("file:/" + System.getProperty("catalina.home") + image.getPath());
            LOGGER.info(file.delete() ? "delete file:[" + image + "]" : "error delete file");
            imageRepository.delete(image);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Image> findAllByPortfolioNull() {
        return imageRepository.findAllByPortfolioNull();
    }

    @Override
    public void deleteAllByPortfolioNull() {
        findAllByPortfolioNull().stream().forEach(image -> delete(image.getId()));
    }
}
