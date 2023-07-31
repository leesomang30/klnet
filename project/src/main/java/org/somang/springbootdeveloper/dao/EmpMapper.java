package org.somang.springbootdeveloper.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.somang.springbootdeveloper.DTO.Employment;
import org.somang.springbootdeveloper.DTO.Member;
import org.somang.springbootdeveloper.DTO.Reply;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    public Employment selectEmp(String no); //1건만 받을때  

    public int selectEmpCount(); // 숫자를 반환 받을때

    public List<Employment> selectEmp2(); //여러건의 데이터를 받고 싶을때 

    public List<Employment> selectEmp3(@Param("jobId") String jobId, @Param("salary") int salary); //파라미터 2개 이상일 때

    public List<Employment> selectEmp4(Employment emp); // 파라미터를 emp 처럼 객체로 받을 때 (장점:파라미터 갯수가 많아질 때 유리함. 줄줄이 안써도 됨 )

    public List<Employment> selectEmp5(Map<String, Object> map);//파라미터를 맵으로 받을 때

    public List<Employment> selectEmp6(@Param("page") int page );

    public List<Employment> selectEmp7(Employment emp);//다이나믹쿼리사용. 동적으로 이쿼리썼다가 저쿼리썼다가

    public List<Employment> selectEmp8(@Param("emp") Employment emp, @Param("page") int page);

    public int insertEmp1(Employment emp);

    public int deleteEmp1(Employment emp);

    public int updateEmp1(@Param("emp") Employment emp);

    public List<Employment> selectEmp9();

    public int selectEmp10(String string);

    public int insertEmp2(Member member);

    public int insertReplyA(Reply reply);

    public int selectId(String string);



//    public List<Map<String, Object >> selectEmp3();


}
