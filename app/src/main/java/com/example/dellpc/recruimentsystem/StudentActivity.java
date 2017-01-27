package com.example.dellpc.recruimentsystem;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

//        simplefragmentadapter sf = new simplefragmentadapter(getSupportFragmentManager());
//        TabLayout tl = (TabLayout) findViewById(R.id.tabs);
//        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//
//        viewPager.setAdapter(sf);
//        tl.setupWithViewPager(viewPager);

//    }
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.mFragStudent, new StudentPostFragment()).commit();
    }
}
