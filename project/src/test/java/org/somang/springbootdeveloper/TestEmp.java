package org.somang.springbootdeveloper;


import org.junit.jupiter.api.Test;
import org.somang.springbootdeveloper.DTO.Employment;
import org.somang.springbootdeveloper.DTO.Reply;
import org.somang.springbootdeveloper.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class TestEmp {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void Test1() {

        Employment ss = empMapper.selectEmp("100");

        System.out.println("값 출력");
        System.out.println(ss);

    }

    @Test
    public void Test2() {

        int a = empMapper.selectEmpCount();
        System.out.println("값은 :" + a);
    }

    @Test
    public void Test3() {

        List<Employment> list = empMapper.selectEmp2();

        System.out.println("값은 :" + list);
    }

    //    @Test
//    public void Test4(){
//
//        List<Map<String, Object>> list = empMapper.selectEmp3();
//
//
//
//        System.out.println("값은 :" + list);
//    }
    @Test
    public void Test4() {

        List<Employment> list = empMapper.selectEmp3("FI_ACCOUNT", 8000);

        System.out.println("값은 :" + list);
    }

    @Test
    public void Test5() {


        Employment emp = new Employment();
        emp.setJobId("FI_ACCOUNT");
        emp.setSalary(8000);

        List<Employment> list = empMapper.selectEmp4(emp);

        System.out.println(list);
    }

    @Test
    public void Test6() {
        Map<String, Object> inMap = new HashMap<>();
        inMap.put("jobId", "ST_MAN");
        inMap.put("salary", 5000);

        List<Employment> list = empMapper.selectEmp5(inMap);


        System.out.println(list);

    }

    @Test
    public void Test7() {

        List<Employment> list = empMapper.selectEmp6(10);


        System.out.println(list);
    }

    @Test
    public void Test8() {
        Employment emp = new Employment();
        emp.setJobId("IT_PROG");
        emp.setSalary(9000);
        List<Employment> list = empMapper.selectEmp7(emp);


        System.out.println(list);
    }

    @Test
    public void Test9() {
        Employment emp = new Employment();
        emp.setJobId("IT_PROG");
        emp.setSalary(3000);
        List<Employment> list = empMapper.selectEmp8(emp, 3);


        System.out.println(list);
    }

    @Test
    public void Test10() {
        Employment emp = new Employment();
        emp.setEmployeeId("207");
        emp.setFirstName("somang");
        emp.setLastName("Hunold");
        emp.setEmail("leesomang");
        emp.setPhoneNumber("01012345678");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate hireDate = LocalDate.parse("05/20/2022", formatter);

        //long xx = Math.round(333.33);
        //20220520 (스트링) 입력시   ==> 날짜(Localdate) 로 출력

        emp.setHireDate(hireDate);  //2022.05.20
        emp.setJobId("IT_PROG");
        emp.setSalary(4000);
        emp.setDepartmentId(80);
        emp.setManagerId(124);


        int a = empMapper.insertEmp1(emp);
        System.out.println(a);


    }

    @Test
    public void Test11() {
        Employment emp = new Employment();
        emp.setEmployeeId("207");

        int a = empMapper.deleteEmp1(emp);
    }

    @Test
    public void Test12() {
        Employment emp = new Employment();
        emp.setJobId("IT_PROG");

        int a = empMapper.updateEmp1(emp);
        System.out.println(a);
    }

    @Test
    public void Test13() {

        List<Employment> list = empMapper.selectEmp9();
        System.out.println(list);

        for (Employment emp : list) {

        }


    }

    @Test
    public void Test14() {

        String[] x = {"a", "b", "c", "D"};

        Reply[] replys = null;

        for (Reply reply : replys) {

        }


        for (String s : x) {
            System.out.println(s);
        }


    }
}
