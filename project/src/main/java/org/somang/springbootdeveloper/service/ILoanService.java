package org.somang.springbootdeveloper.service;

import org.somang.springbootdeveloper.DTO.LoanDto;
import org.somang.springbootdeveloper.DTO.RedemptionScheduleDto;

import java.util.List;

public interface ILoanService {

    public List<RedemptionScheduleDto> LoanDto(LoanDto loanDto);
    public List<RedemptionScheduleDto> LoanDtoEqual(LoanDto loanDto);
}
