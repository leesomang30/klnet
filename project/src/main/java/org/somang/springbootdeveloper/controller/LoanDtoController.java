package org.somang.springbootdeveloper.controller;


import lombok.RequiredArgsConstructor;
import org.somang.springbootdeveloper.DTO.LoanDto;
import org.somang.springbootdeveloper.DTO.RedemptionScheduleDto;
import org.somang.springbootdeveloper.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LoanDtoController {

    @Autowired
    private ILoanService iLoanService;

    @GetMapping("/loan/loan1")
    public String loanForm(){

        return "loan/loanCalc";

    }

    @PostMapping("/loan/loan5")
    public String loanCalculate4(@ModelAttribute LoanDto loanDto, Model model){

        if(loanDto.getLoanAmount() == null || loanDto.getLoanPeriod() == null ||loanDto.getAnnualInterestRate() == null){

            model.addAttribute("msg","값을 입력해주세요.");

            return "error/ajaxError";
        }

        System.out.println("loanCalculate4 in :" + loanDto);

        //대출금액
        System.out.println(loanDto.getLoanAmount());

        //기간
        System.out.println(loanDto.getLoanPeriod());

        System.out.println("거치기간:"+loanDto.getUnredeemPeriod());

        if("01".equals(loanDto.getCode())) {
            List<RedemptionScheduleDto> aa = iLoanService.LoanDto(loanDto);

            model.addAttribute("list", aa);
        }

        else if("02".equals(loanDto.getCode())) {
            List<RedemptionScheduleDto> bb = iLoanService.LoanDtoEqual(loanDto);
            model.addAttribute("list", bb);
        }

        System.out.println("loanCalculate4 out :" + loanDto);

        return "loan/redempSchedule";
    }
}
