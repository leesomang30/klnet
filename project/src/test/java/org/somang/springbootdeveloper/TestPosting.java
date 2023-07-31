package org.somang.springbootdeveloper;


import org.junit.jupiter.api.Test;
import org.somang.springbootdeveloper.DTO.Posting;
import org.somang.springbootdeveloper.dao.PostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestPosting {

    @Autowired
    private PostingMapper postingMapper;

    @Test
    public void Test1(){
        List<Posting> aa = postingMapper.selectListPostingA();
        System.out.println(aa);

    }

    @Test
    public void Test2(){
        Posting aa = postingMapper.selectPostingA("1");
        System.out.println(aa);
    }

    @Test
    public void Test3(){
        postingMapper.increaseHits("1");

        Posting aa = postingMapper.selectPostingA("1");
        System.out.println(aa);
    }
}
