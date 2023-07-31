package org.somang.springbootdeveloper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.somang.springbootdeveloper.DTO.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

    List<Cart> selectListCartA();

    Cart selectCartA(String productId);


    List<Cart> selectListCartB(@Param("list") List<String> list);

}
