package com.yize.offer;

import org.junit.Test;

import static com.yize.offer.Offer_52.match;

public class Offer_52Test {
    @Test
    public void test(){
        boolean result=match("aaa".toCharArray(),"a*".toCharArray());
        System.out.println(result);
    }
}
