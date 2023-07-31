package org.somang.springbootdeveloper.service;

import org.somang.springbootdeveloper.DTO.Delivery;
import org.somang.springbootdeveloper.dao.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService{


    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public int insertDelivery1(Delivery delivery) {

        int a = deliveryMapper.insertDelivery1(delivery);
        return a;
    }

    @Override
    public List<Delivery> selectDelivery1(Delivery delivery) {
        List<Delivery> aa = deliveryMapper.selectDelivery1(delivery);
        return aa;
    }

    @Override
    public Delivery selectDelivery2(Delivery delivery) {
        Delivery b = deliveryMapper.selectDelivery2(delivery);
        return b;
    }

    @Override
    public int updateNewDelivery1(Delivery delivery) {
        int c = deliveryMapper.updateNewDelivery1(delivery);
        return c;
    }

    @Override
    public int updateBeforeDelivery2(Delivery delivery) {
        int d = deliveryMapper.updateBeforeDelivery2(delivery);
        return d;
    }

    @Override
    public int updateReviseAddress(Delivery delivery) {
        int e = deliveryMapper.updateReviseAddress(delivery);
        return e;
    }

    @Override
    public int deleteAddress(Delivery delivery) {
        int f = deliveryMapper.deleteAddress(delivery);
        return f;
    }
}
