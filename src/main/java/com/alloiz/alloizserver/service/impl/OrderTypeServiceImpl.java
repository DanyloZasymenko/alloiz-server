package com.alloiz.alloizserver.service.impl;

import com.alloiz.alloizserver.repository.OrderTypeRepository;
import com.alloiz.alloizserver.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alloiz.alloizserver.service.utils.Validation.*;

@Service
public class OrderTypeServiceImpl implements OrderTypeService {

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Override
    public OrderType findOneAvailable(Long id) {
        checkId(id);
        return orderTypeRepository.findByAvailableAndId(true, id);
    }

    @Override
    public List<OrderType> findAllAvailable() {
        return orderTypeRepository.findAllByAvailable(true);
    }

    @Override
    public OrderType findOne(Long id) {
        checkId(id);
        return orderTypeRepository.findOne(id);
    }

    @Override
    public List<OrderType> findAll() {
        return orderTypeRepository.findAll();
    }

    @Override
    public OrderType save(OrderType orderType) {
        checkSave(orderType);
        return orderTypeRepository.save(orderType.setAvailable(true));
    }

    @Override
    public Boolean delete(Long id) {
        try {
            orderTypeRepository.delete(checkObjectExistsById(id, orderTypeRepository));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OrderType update(OrderType orderType) {
        checkObjectExistsById(orderType.getId(), orderTypeRepository);
        return orderTypeRepository.save(findOne(orderType.getId())
                .setAvailable(orderType.getAvailable())
                .setName(orderType.getName())
        );
    }
}
