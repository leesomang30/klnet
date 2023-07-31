package org.somang.springbootdeveloper;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestSorting {


    @Test
    public void Test1(){
        String arr[] = {"바나나", "메론", "포도", "사과"};


		Arrays.sort(arr);
        System.out.println(  Arrays.toString(arr) );

	    Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //return  a.compareTo(b); //1 이면 변경이니까 오름차순
                return b.compareTo(a); //1 이면 변경이니까 내림차순
            }
        });

        System.out.println(  "================ 원본 출력");
        System.out.println(  Arrays.toString(arr) );

        System.out.println(  "================ 리버스정렬후 출력");
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(  Arrays.toString(arr) );

    }
}
