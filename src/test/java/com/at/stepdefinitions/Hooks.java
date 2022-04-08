package com.at.stepdefinitions;

import com.at.models.Curriculum;
import cucumber.api.java.Before;
import com.at.utils.BasicSecurityUtil;



public class Hooks {
    private static BasicSecurityUtil base;
    private static Curriculum curriculumMongo;

    @Before
    public void setUp(){
        base= new BasicSecurityUtil();
        curriculumMongo=null;
    }
    public static BasicSecurityUtil getBase(){
        return base;
    }
    public static Curriculum getCurriculumMongo(){
        return curriculumMongo;
    }
    public static void setCurriculumMongo(Curriculum curriculum){curriculumMongo=curriculum;}
}
