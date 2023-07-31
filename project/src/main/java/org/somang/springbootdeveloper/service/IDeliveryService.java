package org.somang.springbootdeveloper.service;

import org.somang.springbootdeveloper.DTO.Delivery;

import java.util.List;

public interface IDeliveryService {

    public int insertDelivery1(Delivery delivery);

    public List<Delivery> selectDelivery1(Delivery delivery);

    public Delivery selectDelivery2(Delivery delivery);

    public int updateNewDelivery1(Delivery delivery);

    public int updateBeforeDelivery2(Delivery delivery);

    public int updateReviseAddress(Delivery delivery);

    public int deleteAddress(Delivery delivery);
}
