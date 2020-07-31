package com.cda.utils;

import com.cda.init.BddDataTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        BddDataTestBean bdd = new BddDataTestBean();
        bdd.initialisation();
    }
}
