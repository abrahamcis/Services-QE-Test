package com.at.controller;

import com.at.models.*;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    private static final Faker faker = new Faker();
    private static Curriculum curriculumPersonalized = new Curriculum();

    public static Curriculum getCurriculumPersonalized() {
        return curriculumPersonalized;
    }
    public static String getCurriculumPersonalizedString(){
        return curriculumPersonalized.toString();
    }


    public static Curriculum createCompleteCurriculum(){
        setSkills();
        setLanguages("english","advanced");
        setEducation("Bachelor","2022","engeenier","2018");
        setWorkExperience();
        setChallenge("2020","eat 15 tacos","Taco Challenge","www.youtube.com");
        setConfig("red","verdana","italic");
        setSocialMedia("Anything","Anything","Anything","Anything","Anything","Anything");
        setPersonalData("Antonio","Perez","Perez@gmail.com","89899099092","Mexico","Monterrey");
        System.out.println(curriculumPersonalized);
        return curriculumPersonalized;
    }
    public static Curriculum createIncompleteCurriculum(){
        List<Skills> skills = new ArrayList<>();
        Skills skills1 = new Skills();
        skills1.setName(faker.programmingLanguage().name());
        skills1.setPercentage(faker.number().digit());
        skills.add(skills1);
        List<Educational> educationals = new ArrayList<>();
        Educational educational = new Educational();
        educational.setCareer(faker.job().field());
        educational.setDegree("Bacheloer");
        educational.setName(faker.university().name());
        educational.setTo("2019");
        educational.setForever("Engenier");
        educational.setFrom("2018");
        educationals.add(educational);
        List<WorkExperience> workExperienceList= new ArrayList<>();
        WorkExperience work1 = new WorkExperience(faker.company().name(),faker.company().name(),faker.lorem().characters(),"2021",faker.job().title(),"2022");
        workExperienceList.add(work1);
        List<Challenge> challengeList = new ArrayList<>();
        Challenge challenge = new Challenge("2022","I ate 20 taacos","lunch contest","www.youtube.co");
        challengeList.add(challenge);
        Config config = new Config("red","italic","verdana");
        SocialMedia socialMedia = new SocialMedia("eduardoLopez","Eduardo","eduardo","none","none","eduardo");
        Curriculum curriculum = new Curriculum(challengeList,"Monterrey",config,"Mexico",educationals,"Eduardolopez@gmail.com","eduardo","QA","Lopez","82897890","String",skills,socialMedia,workExperienceList);
        System.out.println(curriculum.toString());
        return curriculum;
    }
    public static void createCurriculumBlank(){
        curriculumPersonalized = new Curriculum();
    }
    public static void setSkills(){
        curriculumPersonalized.setSkills(CurriculumDataSet.createSkillsList());
    }
    public static void setLanguages(String language,String level){
        curriculumPersonalized.setLanguages(CurriculumDataSet.createLanguageList(language,level));
    }
    public static void setEducation(String Bachelor,String to,String forever, String from){
        curriculumPersonalized.setEducation(CurriculumDataSet.createEducationalList(Bachelor,to,forever,from));
    }
    public static void setWorkExperience(){
        curriculumPersonalized.setWorkexperience(CurriculumDataSet.createWorkexperienceList());
    }
    public static void setChallenge(String date,String description,String name,String url){
        curriculumPersonalized.setChallenges(CurriculumDataSet.createChallengList(date,description,name,url));
    }
    public static void setConfig(String color,String fontFamily,String genericFamily){
        curriculumPersonalized.setConfig(CurriculumDataSet.createConfig(color,fontFamily,genericFamily));
    }
    public static void setSocialMedia(String facebook,String instagram,String linkedin,String pinterest,String snapchat,String twitter){
        curriculumPersonalized.setSocialMedia(CurriculumDataSet.createSocialMedia(facebook,instagram,linkedin,pinterest,snapchat,twitter));
    }
    public static void setPersonalData(String firstName,String lastName,String email,String phone,String country,String city){
        curriculumPersonalized.setFirstName(firstName);
        curriculumPersonalized.setLastName(lastName);
        curriculumPersonalized.setEmail(email);
        curriculumPersonalized.setPhoneNumber(phone);
        curriculumPersonalized.setCountry(country);
        curriculumPersonalized.setCity(city);
    }
}
