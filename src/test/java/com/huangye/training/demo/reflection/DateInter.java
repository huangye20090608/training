package com.huangye.training.demo.reflection;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by huangye on 2017/4/7.
 */
public class DateInter extends Pair<Date> {
    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }
    @Override
    public Date getValue() {
        return super.getValue();
    }

    public static void main(String agrs[]){
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
        //dateInter.setValue(new Object());//编译错误


        ArrayList<String> arrayList=new ArrayList<String>();

        //运行时类型查询
//        if( arrayList instanceof ArrayList<String>){
//
//        }

        if( arrayList instanceof ArrayList<?>){

        }
    }


}
