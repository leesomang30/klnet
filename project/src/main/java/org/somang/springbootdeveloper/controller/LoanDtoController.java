package org.somang.springbootdeveloper.controller;


import lombok.RequiredArgsConstructor;
import org.somang.springbootdeveloper.DTO.LoanDto;
import org.somang.springbootdeveloper.DTO.RedemptionScheduleDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class LoanDtoController {

    @GetMapping("/loan/loan1")
    public String loanForm(){

        return "loan/loan1";

    }

    @ResponseBody
    @PostMapping("/loan/loan2")
    public List<RedemptionScheduleDto> loanCalculate(@ModelAttribute LoanDto loanDto, Model model){

        System.out.println("loanCalculate in :" + loanDto);

        //대출금액
        System.out.println(loanDto.getLoanAmount());

        //기간
        System.out.println(loanDto.getLoanPeriod());


        //연이자율
        loanDto.getAnnualInterestRate();

        LocalDate loanDate = LocalDate.now();

        BigDecimal percent = new BigDecimal(0.01);

        BigDecimal loanAmount = loanDto.getLoanAmount();

        BigDecimal loanBalance = loanDto.getLoanAmount();

        BigDecimal annualInterestRate = loanDto.getAnnualInterestRate().multiply(percent).setScale(2, RoundingMode.DOWN);
        System.out.println(annualInterestRate);//0.03

        BigDecimal loanPeriod = loanDto.getLoanPeriod();
        System.out.println(loanPeriod);//36

        BigDecimal year = BigDecimal.valueOf(12);

        BigDecimal principalInterest = loanAmount.multiply(annualInterestRate).divide(year);//상환이자

        BigDecimal principalPayment = loanAmount.divide(loanPeriod, 0, RoundingMode.DOWN); //상환원금

        BigDecimal principalAmount = principalPayment.add(principalInterest).setScale(2); //상환금액

        int loanPeriodInt = loanPeriod.intValue();

        List<RedemptionScheduleDto> list = new ArrayList<>();

        for(int i=1; i <= loanPeriodInt; i++) {

            if( i < loanPeriodInt ) {

                //대출이자
                principalInterest = loanBalance.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);

                //잔액
                loanBalance = loanBalance.subtract(principalPayment);//.setScale(0, RoundingMode.HALF_UP);

                //BigDecimal AA = principalPayment.add(principalInterest);

                //월상환금 =  ( 대출이자 + 월납입금)
                principalAmount = principalPayment.add(principalInterest);//.setScale(0, RoundingMode.HALF_UP);
            }
            else if ( i == loanPeriodInt ){
                //마지막달일 경우
                //월납입금
                principalPayment = loanBalance;

                principalInterest = loanBalance.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);

                principalAmount = principalPayment.add(principalInterest);
                loanBalance=BigDecimal.ZERO;
            }

            RedemptionScheduleDto redemp = new RedemptionScheduleDto();
            redemp.setNums(i);
            redemp.setRdmpDt(loanDate.plusMonths(i));
            redemp.setRdmpPrcp(principalPayment);
            redemp.setRdmpItr(principalInterest);
            redemp.setRdmpAmt(principalAmount);
            redemp.setBalance(loanBalance);

            list.add(redemp);




//            System.out.printf(" %d %s %s %s %s %s \n",
//                    i,
//                    loanDate.plusMonths(i).toString(),
//                    principalPayment.toString() ,
//                    principalInterest.toString(),
//                    principalAmount.toString(),
//                    loanBalance.toString()
//                    //loanBalance.setScale(0, RoundingMode.HALF_UP).toString()
//            );

        }

        System.out.println("loanCalculate out:" + list);

        return list;

    }


    @PostMapping("/loan/loan3")
    public String loanCalculate2(@ModelAttribute LoanDto loanDto, Model model){

        if(loanDto.getLoanAmount() == null || loanDto.getLoanPeriod() == null ||loanDto.getAnnualInterestRate() == null){

            model.addAttribute("msg","값을 입력해주세요.");

            return "error/ajaxError";
        }

        System.out.println("loanCalculate in :" + loanDto);

        //대출금액
        System.out.println(loanDto.getLoanAmount());

        //기간
        System.out.println(loanDto.getLoanPeriod());


        //연이자율
        loanDto.getAnnualInterestRate();

        LocalDate loanDate = LocalDate.now();

        BigDecimal percent = new BigDecimal(0.01);

        BigDecimal loanAmount = loanDto.getLoanAmount();

        BigDecimal loanBalance = loanDto.getLoanAmount();

        BigDecimal annualInterestRate = loanDto.getAnnualInterestRate().multiply(percent).setScale(2, RoundingMode.DOWN);
        System.out.println(annualInterestRate);//0.03

        BigDecimal loanPeriod = loanDto.getLoanPeriod();
        System.out.println(loanPeriod);//36

        BigDecimal year = BigDecimal.valueOf(12);

        BigDecimal principalInterest = loanAmount.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);//상환이자

        BigDecimal principalPayment = loanAmount.divide(loanPeriod, 0, RoundingMode.DOWN); //상환원금

        BigDecimal principalAmount = principalPayment.add(principalInterest).setScale(2); //상환금액

        int loanPeriodInt = loanPeriod.intValue();

        List<RedemptionScheduleDto> list = new ArrayList<>();

        for(int i=1; i <= loanPeriodInt; i++) {

            if( i < loanPeriodInt ) {

                //대출이자
                principalInterest = loanBalance.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);

                //잔액
                loanBalance = loanBalance.subtract(principalPayment);//.setScale(0, RoundingMode.HALF_UP);

                //BigDecimal AA = principalPayment.add(principalInterest);

                //월상환금 =  ( 대출이자 + 월납입금)
                principalAmount = principalPayment.add(principalInterest);//.setScale(0, RoundingMode.HALF_UP);
            }
            else if ( i == loanPeriodInt ){
                //마지막달일 경우
                //월납입금
                principalPayment = loanBalance;

                principalInterest = loanBalance.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);

                principalAmount = principalPayment.add(principalInterest);
                loanBalance=BigDecimal.ZERO;
            }

            RedemptionScheduleDto redemp = new RedemptionScheduleDto();
            redemp.setNums(i);
            redemp.setRdmpDt(loanDate.plusMonths(i));
            redemp.setRdmpPrcp(principalPayment);
            redemp.setRdmpItr(principalInterest);
            redemp.setRdmpAmt(principalAmount);
            redemp.setBalance(loanBalance);

            list.add(redemp);




//            System.out.printf(" %d %s %s %s %s %s \n",
//                    i,
//                    loanDate.plusMonths(i).toString(),
//                    principalPayment.toString() ,
//                    principalInterest.toString(),
//                    principalAmount.toString(),
//                    loanBalance.toString()
//                    //loanBalance.setScale(0, RoundingMode.HALF_UP).toString()
//            );

        }

        model.addAttribute("list", list);
        System.out.println("loanCalculate out:" + list);

        return "loan/redempSchedule";

    }

}
