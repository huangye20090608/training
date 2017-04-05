package com.huangye.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by huangye on 2017/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/spring-config.xml" })
public class TrainingServiceTest {

    @Test
    public void trainingServiceTest(){
        System.out.print("--------------hello word----------------------");
    }
}
