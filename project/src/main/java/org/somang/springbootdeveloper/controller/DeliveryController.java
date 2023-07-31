package org.somang.springbootdeveloper.controller;


import lombok.RequiredArgsConstructor;
import org.somang.springbootdeveloper.DTO.Delivery;
import org.somang.springbootdeveloper.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DeliveryController {

    @Autowired
    private IDeliveryService iDeliveryService;


    @GetMapping("/address/list")
    public String initialPage(@ModelAttribute Delivery delivery, Model model){
        System.out.println("initialPage in:" + delivery);
        delivery.setUserId("ajaxman");
        String combi = delivery.getCellNumPre() + "-" +delivery.getCellNumMiddle() + "-" + delivery.getCellNumEnd();
        delivery.setCellNum(combi);
        List<Delivery> aa = iDeliveryService.selectDelivery1(delivery);

        model.addAttribute("list", aa);

        System.out.println("initialPage out :" + aa);
        return "/delivery/initialPage";
    }

    @GetMapping("/address/addAddress")
    public String registerAddress(){

        return "delivery/registerAddress";
    }


    @PostMapping("/address/save")
    public String saveAddress(@ModelAttribute Delivery delivery) {

        System.out.println("saveAddress : in " + delivery);

        delivery.setUserId("ajaxman");
        String combi = delivery.getCellNumPre() + "-" +delivery.getCellNumMiddle() + "-" + delivery.getCellNumEnd();
        delivery.setCellNum(combi);

        int b = iDeliveryService.insertDelivery1(delivery);


        return "redirect:/address/list";
    }


    @ResponseBody
    @GetMapping("/address/ajaxSetting")
    public int ajaxSetting(@ModelAttribute Delivery delivery){

        System.out.println("ajaxSetting in= " + delivery);

        delivery.setUserId("ajaxman");
        String combi = delivery.getCellNumPre() + "-" +delivery.getCellNumMiddle() + "-" + delivery.getCellNumEnd();
        delivery.setCellNum(combi);
        //기존에 있는놈은 null 로 바꾸고
        int d = iDeliveryService.updateBeforeDelivery2(delivery);
        
        //신규건은 Y 로 변경하기
        int e = iDeliveryService.updateNewDelivery1(delivery);

        return e;

    }

    @GetMapping("/address/revise")
    public String reviseAddress(@ModelAttribute Delivery delivery, Model model){

        System.out.println("reviseAddress in : " + delivery);

        delivery.setUserId("ajaxman");

//        String combi = delivery.getCellNumPre() + "-" +delivery.getCellNumMiddle() + "-" + delivery.getCellNumEnd();
//        System.out.println("combi:" +combi);
//        delivery.setCellNum(combi);
//
//        System.out.println("CHECK:" + delivery.getCellNum());

        Delivery aa = iDeliveryService.selectDelivery2(delivery);


        //010-1234-5678
        if(aa.getCellNum() !=null ) {
            String[] arr = aa.getCellNum().split("-");

            aa.setCellNumPre(arr[0]);
            aa.setCellNumMiddle(arr[1]);
            aa.setCellNumEnd(arr[2]);
        }


        System.out.println("reviseAddress out: " + aa);

        model.addAttribute("delivery", aa);

        return "delivery/reviseAddress";
    }


    @PostMapping("/address/revise/save")
    public String saveReviseAddress(@ModelAttribute Delivery delivery) {

        System.out.println("saveReviseAddress in: " + delivery);

        delivery.setUserId("ajaxman");
        delivery.setDeliverySeq(delivery.getDeliverySeq());
        String combi = delivery.getCellNumPre() + "-" +delivery.getCellNumMiddle() + "-" + delivery.getCellNumEnd();
        delivery.setCellNum(combi);

        int b = iDeliveryService.updateReviseAddress(delivery);

        System.out.println("saveReviseAddress out: " + delivery);
        return "redirect:/address/list";
    }

    @GetMapping("/address/delete")
    public String deleteAddress(@ModelAttribute Delivery delivery){

        System.out.println("deleteAddress in: " + delivery);

        delivery.setUserId("ajaxman");
        String combi = delivery.getCellNumPre() + "-" +delivery.getCellNumMiddle() + "-" + delivery.getCellNumEnd();
        delivery.setCellNum(combi);

        Delivery aa = iDeliveryService.selectDelivery2(delivery);

        System.out.println("reviseAddress out: " + aa);

        int d = iDeliveryService.deleteAddress(delivery);


        return "redirect:/address/list";
    }




}
