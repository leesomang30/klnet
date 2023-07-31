package org.somang.springbootdeveloper.service;

import org.somang.springbootdeveloper.DTO.Member;
import org.somang.springbootdeveloper.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements  IMemberService{

    @Autowired
    private EmpMapper mapper;

    @Override
    public int registerMember2(Member member) {

        return 0;
    }
}
