package com.huangye.training.demo.tree;

import java.math.BigDecimal;

/**
 * Created by huangye on 2017/8/30.
 */
public class BigDecimalDemo {

    public static void main(String args[]){
        BigDecimal bigDecimal = new BigDecimal("123.465");
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_UP));//直接进位
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_DOWN));//直接舍位
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP));//最近数字舍入(5进)。这是我们最经典的四舍五入。
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_DOWN));//最近数字舍入(5舍)。在这里5是要舍弃的。
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_EVEN));//银行家舍入法
    }
}
