package com.at.stepdefinitions;

import cucumber.api.java.Before;
import com.at.utils.BasicSecurityUtil;



public class Hooks {
    private static BasicSecurityUtil base;

    @Before
    public void setUp(){
        base= new BasicSecurityUtil();
    }
    public static BasicSecurityUtil getBase(){
        return base;
    }
}
