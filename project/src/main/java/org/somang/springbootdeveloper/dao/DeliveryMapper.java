package org.somang.springbootdeveloper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.somang.springbootdeveloper.DTO.Delivery;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    public int insertDelivery1(Delivery delivery);

    public List<Delivery> selectDelivery1(Delivery delivery);

    public Delivery selectDelivery2(Delivery delivery);

    public int updateNewDelivery1(Delivery delivery);

    public int updateBeforeDelivery2(Delivery delivery);

    public int updateReviseAddress(Delivery delivery);

    public int deleteAddress(Delivery delivery);
}
