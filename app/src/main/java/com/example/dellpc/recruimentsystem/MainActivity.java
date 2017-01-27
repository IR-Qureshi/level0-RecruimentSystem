package com.example.dellpc.recruimentsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button loginAdmin;
    Button loginCompany;
    Button loginStudent;
    private ListView mCompanyListView;
    private ListView mStudentListView;
    private CompanyAdapter mCompanyAdapter;
    private StudentAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginAdmin = (Button) findViewById(R.id.btn_loginAdmin);
        loginCompany = (Button) findViewById(R.id.btn_loginCompany);
        loginStudent = (Button) findViewById(R.id.btn_loginStudent);

//        mCompanyListView = (ListView) findViewById(R.id.compListView);
//        mStudentListView = (ListView) findViewById(R.id.studentListView);

//        //setting adapter for company posts.
//        List<Company> companyList = new ArrayList<>();
//        mCompanyAdapter = new CompanyAdapter(this,R.layout.comp_item,companyList);
//        mCompanyListView.setAdapter(mCompanyAdapter);
//
//        //setting adapter for student posts.
//        List<Student> studentList = new ArrayList<>();
//        mStudentAdapter = new StudentAdapter(this,R.layout.student_item,studentList);
//        mStudentListView.setAdapter(mStudentAdapter);



        //loging in as admin.
        loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //loging in as company.
        loginCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CompanyActivity.class);
                startActivity(intent);
            }
        });

        //loging in as student.
        loginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });
    }
}
