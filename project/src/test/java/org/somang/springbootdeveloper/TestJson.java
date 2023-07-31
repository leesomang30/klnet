package org.somang.springbootdeveloper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.somang.springbootdeveloper.DTO.Cart;
import org.somang.springbootdeveloper.DTO.PriceDto;
import org.somang.springbootdeveloper.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestJson {

    @Autowired
    private ICartService iCartService;

    @Test
    public void Test1(){



        String abc = "[{\"productId\": \"1\" , \"nums\":1, ss  }, {\"productId\":\"2\" ,\"nums\":1}, {\"productId\":\"3\" ,\"nums\":1}]";

        //JSON 이면
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> list = new ArrayList<>();

        PriceDto[] dtos = null;
        try {
            dtos = objectMapper.readValue(abc, PriceDto[].class);

            for (PriceDto aa: dtos) {
                list.add(aa.getProductId());
            }
            System.out.println(list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //이거 왜 조회 함? => [ { 아이템명, 가격 , 개수? },,, ] 을 가져오려고
        List<Cart> listCart = iCartService.selectListCartB(list);
        System.out.println("htmlSend:" + listCart);



        for (Cart cart  : listCart) {
            for (PriceDto dtoo  : dtos) {
                if (cart.getProductId().equals(dtoo.getProductId())) {
                    cart.setNums(dtoo.getNums());
                    break;
                }
            }
        }



//        for(int i=0; i < listCart.size(); i++){
//            for(int j=0; j < dtos.length; j++) {
//                if(listCart.get(i).getProductId().equals(dtos[j].getProductId())){
//                    listCart.get(i).setNums(dtos[j].getNums());
//                    break;
//                }
//            }
//        }

        System.out.println(listCart.get(0).getNums());
        System.out.println(listCart.get(1).getNums());

        System.out.println(listCart.get(0).getProductId());


    }


}
