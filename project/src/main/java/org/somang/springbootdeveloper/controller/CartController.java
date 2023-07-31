package org.somang.springbootdeveloper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.somang.springbootdeveloper.DTO.Cart;
import org.somang.springbootdeveloper.DTO.PriceDto;
import org.somang.springbootdeveloper.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CartController {

    @Autowired
    private ICartService iCartService;


    @GetMapping("/cart/list")
    public String cartList(Model model){

        List<Cart> list = iCartService.selectListCartA();

        model.addAttribute("list", list);



        return "/cart/cartList";

    }

    @GetMapping("/cart/detail")
    public String cartDetail(@RequestParam String productId, Model model){


        Cart aa = iCartService.selectCartA(productId);

        model.addAttribute("detail", aa);


        //item 내역 보여주는 화면 ->
        return "cart/cartDetail2";
    }


    /**
     * abc 라는 하나의 변수로 값을 받을 때 스트링으로 받음
     * @param abc
     * @return
     */
    @PostMapping("/cart/detail2")
    public String cartDetail2(@RequestParam String abc, Model model){

        //abc ==> "[{번호: ,수량:3}, {번호: ,수량:1}, {번호: ,수량:1}]";

        if("".equals(abc)){

            return "/cart/cartDetailHtmlVer";
        }
        //JSON 이면

        List<String> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        PriceDto[] dtos;
        try {
                dtos = objectMapper.readValue(abc, PriceDto[].class);

            for (PriceDto aa: dtos) {
                list.add(aa.getProductId());
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //CC : List<string> cc = 10,20,30

        List<Cart> listCart = iCartService.selectListCartB(list);
//
//        System.out.println("htmlSend:" + listCart);
        for (Cart cart  : listCart) {
            for (PriceDto dtoo  : dtos) {
                if (cart.getProductId().equals(dtoo.getProductId())) {
                    cart.setNums(dtoo.getNums());
                    break;
                }
            }
        }



        model.addAttribute("list", listCart);
        System.out.println("htmlSend out:" + listCart);
//
        return "/cart/cartDetailHtmlVer";

    }





    @ResponseBody
    @PostMapping("/cart/ajaxSend")
//    public int ajaxReceive (@ModelAttribute Reply basket){
    public List<Cart> ajaxReceive (@RequestBody List<String> basket){


        System.out.println("basket 입력값 :" + basket);
//
//        List<String> list =new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        System.out.println("list 입력값 :" + list);
//
        List<Cart> listCart = iCartService.selectListCartB(basket);
//
//        System.out.println("listCart :" + listCart);
//        System.out.println(basket.size());
       // List<String> aa = new ArrayList<>();
        //aa.add(listCart.toString());

        System.out.println("listCart:" + listCart);
        return listCart;

    }


    /**
     * 리스트로 받을때
     * @param cart
     * @param model
     * @return
     */
    @PostMapping("cart/htmlSend")
    public String htmlSend(@RequestParam(required = false, value = "cart2") List<String> cart, Model model) {

        System.out.println("htmlSend in:" + cart);
        if(cart.size() == 0){
            return "/cart/cartDetailHtmlVer";
        }

        List<Cart> listCart = iCartService.selectListCartB(cart);
//
//        System.out.println("htmlSend:" + listCart);
        model.addAttribute("list", listCart);
//        System.out.println("htmlSend out:" + listCart);

        return "/cart/cartDetailHtmlVer";
    }


}
