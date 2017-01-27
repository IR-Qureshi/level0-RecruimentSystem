package com.example.dellpc.recruimentsystem;

/**
 * Created by dell pc on 25-Jan-17.
 */

public class Student {
    private String S_name;
    private String S_Qualification;
    private String S_InstLastAttend;
    private String S_age;
    private String S_Experience;

    public Student(){

    }
    public Student(String mS_name, String mS_Qualificaiton, String mS_InstLastAttend, String mS_Age, String mS_Experience){
        S_name = mS_name;
        S_Qualification = mS_Qualificaiton;
        S_InstLastAttend = mS_InstLastAttend;
        S_age = mS_Age;
        S_Experience = mS_Experience;
    }

    public String getS_age() {
        return S_age;
    }

    public String getS_Experience() {
        return S_Experience;
    }

    public String getS_InstLastAttend() {
        return S_InstLastAttend;
    }

    public String getS_name() {
        return S_name;
    }

    public String getS_Qualification() {
        return S_Qualification;
    }

    public void setS_age(String s_age) {
        S_age = s_age;
    }

    public void setS_Experience(String s_Experience) {
        S_Experience = s_Experience;
    }

    public void setS_InstLastAttend(String s_InstLastAttend) {
        S_InstLastAttend = s_InstLastAttend;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public void setS_Qualification(String s_Qualification) {
        S_Qualification = s_Qualification;
    }
}
