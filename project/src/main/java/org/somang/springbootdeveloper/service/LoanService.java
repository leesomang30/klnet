package org.somang.springbootdeveloper.service;


import org.somang.springbootdeveloper.DTO.LoanDto;
import org.somang.springbootdeveloper.DTO.RedemptionScheduleDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements ILoanService {
    @Override
    public List<RedemptionScheduleDto> LoanDto(LoanDto loanDto) {




        //연이자율
        loanDto.getAnnualInterestRate();

        LocalDate loanDate = LocalDate.now();

        BigDecimal percent = new BigDecimal(0.01);

        BigDecimal loanAmount = loanDto.getLoanAmount();

        BigDecimal loanBalance = loanDto.getLoanAmount();

        int unredeemPeriod = loanDto.getUnredeemPeriod();

        BigDecimal annualInterestRate = loanDto.getAnnualInterestRate().multiply(percent).setScale(2, RoundingMode.DOWN);
        System.out.println(annualInterestRate);//0.03

        BigDecimal loanPeriod = loanDto.getLoanPeriod();
        System.out.println(loanPeriod);//36

        BigDecimal year = BigDecimal.valueOf(12);

        BigDecimal principalInterest = loanAmount.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);//상환이자

        BigDecimal principalPayment = loanAmount.divide(loanPeriod, 0, RoundingMode.DOWN); //상환원금

        BigDecimal principalAmount = principalPayment.add(principalInterest).setScale(2); //상환금액

        int loanPeriodInt = loanPeriod.intValue();

        int rdmEndCnt = loanPeriodInt + unredeemPeriod;

        BigDecimal principalPaymentPrint = BigDecimal.valueOf(0);
        BigDecimal principalAmountPrint = BigDecimal.valueOf(0);

        List<RedemptionScheduleDto> list = new ArrayList<>();

        for (int i = 1; i <= rdmEndCnt; i++) {

            if (i < rdmEndCnt) {

                //대출이자
                principalInterest = loanBalance.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);

                if (i > unredeemPeriod) {
                    //잔액
                    loanBalance = loanBalance.subtract(principalPayment);//.setScale(0, RoundingMode.HALF_UP);

                    //BigDecimal AA = principalPayment.add(principalInterest);

                    //월상환금 =  ( 대출이자 + 월납입금)
                    principalAmount = principalPayment.add(principalInterest);//.setScale(0, RoundingMode.HALF_UP);

                    //원본을 놔두고 복사본을 변경
                    principalPaymentPrint = principalPayment;
                    principalAmountPrint = principalAmount;

                } else {

                }

            } else if (i == rdmEndCnt) {
                //마지막달일 경우
                //월납입금
                principalPaymentPrint = loanBalance;

                principalInterest = loanBalance.multiply(annualInterestRate).divide(year, 0, RoundingMode.DOWN);

                principalAmount = principalPayment.add(principalInterest);
                loanBalance = BigDecimal.ZERO;
            }

            RedemptionScheduleDto redemp = new RedemptionScheduleDto();
            redemp.setNums(i);
            redemp.setRdmpDt(loanDate.plusMonths(i));
            redemp.setRdmpPrcp(principalPaymentPrint);
            redemp.setRdmpItr(principalInterest);
            redemp.setRdmpAmt(principalAmountPrint);
            redemp.setBalance(loanBalance);

            list.add(redemp);



        }
        return list;
    }
}