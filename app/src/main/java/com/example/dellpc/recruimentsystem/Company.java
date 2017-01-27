package com.example.dellpc.recruimentsystem;

/**
 * Created by dell pc on 25-Jan-17.
 */

public class Company {
    private String J_title;
    private String J_detail;
    private String J_postDate;

    public Company(String mJ_title, String mJ_detail, String mJ_post){
        J_title = mJ_title;
        J_detail = mJ_detail;
        J_postDate = mJ_post;
    }

    public String getJ_detail() {
        return J_detail;
    }

    public String getJ_post() {
        return J_postDate;
    }

    public String getJ_title() {
        return J_title;
    }

    public void setJ_detail(String j_detail) {
        J_detail = j_detail;
    }

    public void setJ_post(String j_post) {
        J_postDate = j_post;
    }

    public void setJ_title(String j_title) {
        J_title = j_title;
    }
}
