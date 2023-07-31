package org.somang.springbootdeveloper.service;

import org.somang.springbootdeveloper.DTO.Cart;
import org.somang.springbootdeveloper.dao.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private CartMapper cartMapper;


    @Override
    public List<Cart> selectListCartA() {

        List<Cart> list = cartMapper.selectListCartA();
        return list;
    }

    @Override
    public Cart selectCartA(String productId) {
        Cart aa = cartMapper.selectCartA(productId);

        return aa;
    }

    @Override
    public List<Cart> selectListCartB(List<String> list) {
        List<Cart> listCart = cartMapper.selectListCartB(list);

        return listCart;
    }
}
