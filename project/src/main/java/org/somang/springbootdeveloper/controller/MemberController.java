package org.somang.springbootdeveloper.controller;

import org.somang.springbootdeveloper.DTO.Member;
import org.somang.springbootdeveloper.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("/member/memberJoinForm")
    public String memberJoinForm(){
        // 아무기능이 없고 html 화면만 보여주면 되므로.
        // 로직은 필요 없음 왜냐면 화면만 보여주면 되므로.
        return "/member/memberJoin";
    }


    /**
     *
     * @param userId
     * @param userName
     * @param birthDate
     * @param sex
     * @param phoneNumber
     * @param email
     * @param model
     * @return
     */
    @GetMapping("/member/registerMember")
    public String registerMember(@RequestParam(required = false) String userId,
                                 @RequestParam(required = false) String userName,
                                 @RequestParam(required = false) String birthDate,
                                 @RequestParam(required = false) String sex,
                                 @RequestParam(required = false) String phoneNumber,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) List<String> interest,
                                 Model model){

        System.out.println("registerMember()  Started");
        System.out.println( "Id : " + userId  );
        System.out.println( "name : " + userName  );
        System.out.println( "birth : " + birthDate  );


        return "/member/success";
    }


    @Autowired
    private EmpMapper empMapper;

    @PostMapping("/member/registerMember")
    public String registerMember2(@ModelAttribute Member member, Model model){

        System.out.println("registerMember2()  Started");
        System.out.println( "Id : " + member.getUserId());
        System.out.println( "name : " + member.getUserName());
        System.out.println( "birth : " + member.getBirthDate());
        System.out.println( "sex : " + member.getSex());
        System.out.println( "phoneNumber : " + member.getPhoneNumber());
        System.out.println( "email : " + member.getEmail());
        System.out.println( "interest :" + member.getInterest());

        System.out.println( "zipcode :" + member.getZipcode());
        System.out.println( "addressMain :" + member.getAddressMain());
        System.out.println( "addressDetail :" + member.getAddressDetail());
        System.out.println( "addressRef :" + member.getAddressRef());



        List<String> list = member.getInterest();

        String aa = "";
        member.setInterests("");

        if(list!=null) {
            for (String interest : list) {
                aa = aa + interest + ", ";

            }
            member.setInterests(aa); //축구,tv보기,놀기,
        }





        //회원 id 가 중복이 되는지 먼저 확인하고 없으면 등록. 있으면 에러 페이지로 전송.
        int cnt = empMapper.selectEmp10(member.getUserId());

        if(cnt == 0){
            int bb = empMapper.insertEmp2(member);
        }else {
            model.addAttribute("errorMsg", "중복된 아이디입니다.");
            return "/error/error1";
        }

        model.addAttribute("result", member);


        return "/member/success";

    }
    @ResponseBody
    @GetMapping("/memberjoin/idCheck")
    public Map<String, Integer> idCheck(@RequestParam(required = false)String userId){
        Map<String, Integer> chk = new HashMap<>();
        int aa = empMapper.selectId(userId);
        chk.put("cnt", aa);

        return chk;


    }

}
