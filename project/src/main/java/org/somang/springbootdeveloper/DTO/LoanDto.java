package org.somang.springbootdeveloper.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDto {

    private LocalDate loanDate;

    private BigDecimal loanAmount;
    private BigDecimal loanBalance;
    private BigDecimal annualInterestRate;
    private BigDecimal loanPeriod;
    private BigDecimal year;
    private BigDecimal principalInterest;
    private BigDecimal principalPayment;
    private BigDecimal principalAmount;



    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(BigDecimal loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public BigDecimal getYear() {
        return year;
    }

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    public BigDecimal getPrincipalInterest() {
        return principalInterest;
    }

    public void setPrincipalInterest(BigDecimal principalInterest) {
        this.principalInterest = principalInterest;
    }

    public BigDecimal getPrincipalPayment() {
        return principalPayment;
    }

    public void setPrincipalPayment(BigDecimal principalPayment) {
        this.principalPayment = principalPayment;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    @Override
    public String toString() {
        return "LoanDto{" +
                "loanDate=" + loanDate +
                ", loanAmount=" + loanAmount +
                ", loanBalance=" + loanBalance +
                ", annualInterestRate=" + annualInterestRate +
                ", loanPeriod=" + loanPeriod +
                ", year=" + year +
                ", principalInterest=" + principalInterest +
                ", principalPayment=" + principalPayment +
                ", principalAmount=" + principalAmount +
                '}';
    }
}
