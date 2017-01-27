package com.example.dellpc.recruimentsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyPostFragment extends Fragment {
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseReference;
    private EditText compTitle;
    private EditText compDetail;
    private EditText compDate;
    private Button compPost;
    private Company company;
    public String currentDateandTime;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    public CompanyPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_company_post, container, false);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("student");

        compTitle = (EditText)view.findViewById(R.id.CompNewPostTitle);
        compDetail = (EditText) view.findViewById(R.id.CompNewPostDetail);
        compPost = (Button) view.findViewById(R.id.BtnCompNewPost);

        //setting current time and date.
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy KK:mm");
        currentDateandTime = sdf.format(new Date());

        compPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                company = new Company(compTitle.getText().toString(),compDetail.getText().toString(),currentDateandTime);
                mDatabaseReference.push().setValue(company);
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.mFragComp, new CompanyFragment()).commit();

            }
        });

        return view;
    }

}
