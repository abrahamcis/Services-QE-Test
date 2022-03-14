package com.at.controller;

import com.at.models.*;
import com.github.javafaker.Faker;
import gherkin.lexer.Sk;

import java.util.ArrayList;
import java.util.List;

public class CurriculumDataSet {
    private static final Faker faker = new Faker();
    public static List<Languages> createLanguageList(String name,String level){
        List<Languages> languages = new ArrayList<>();
        Languages languages1 = new Languages();
        languages1.setName(name);
        languages1.setPercentage(level);
        languages.add(languages1);
        return languages;
    }
    public static List<Skills> createSkillsList (){
        List<Skills> skillsList = new ArrayList<>();
        Skills skills1 = new Skills();
        skills1.setName(faker.programmingLanguage().name());
        skills1.setPercentage(faker.number().digit());
        skillsList.add(skills1);
        return skillsList;
    }
    public static List<Educational> createEducationalList (String bachelor,String to,String forever,String from){
        List<Educational> educationals = new ArrayList<>();
        Educational educational = new Educational();
        educational.setCareer(faker.job().field());
        educational.setDegree(bachelor);
        educational.setName(faker.university().name());
        educational.setTo(to);
        educational.setForever(forever);
        educational.setFrom(from);
        educationals.add(educational);
        return educationals;
    }
    public static List<WorkExperience> createWorkexperienceList (){
        List<WorkExperience> workExperienceList= new ArrayList<>();
        WorkExperience work1 = new WorkExperience(faker.company().name(),faker.company().name(),faker.lorem().characters(),"2021",faker.job().title(),"2022");
        workExperienceList.add(work1);
        return workExperienceList;
    }
    public static List<Challenge> createChallengList(String date,String description,String name,String url){
        List<Challenge> challengeList = new ArrayList<>();
        Challenge challenge = new Challenge(date,description,name,url);
        challengeList.add(challenge);
        return  challengeList;
    }
    public  static Config createConfig(String color,String fontFamlily,String genericFamily){
        return new Config(color,fontFamlily,genericFamily);
    }
    public  static SocialMedia createSocialMedia(String facebook,String instagram,String linkedin,String pinterest,String snapchat,String twitter){

        return new SocialMedia(facebook,instagram,linkedin,pinterest,snapchat,twitter);
    }
}
