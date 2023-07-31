package org.somang.springbootdeveloper.service;

import org.apache.ibatis.annotations.Param;
import org.somang.springbootdeveloper.DTO.Cart;

import java.util.List;

public interface ICartService {

    public List<Cart> selectListCartA();

    public Cart selectCartA(String productId);

    public List<Cart> selectListCartB(@Param("list") List<String> list);
}
