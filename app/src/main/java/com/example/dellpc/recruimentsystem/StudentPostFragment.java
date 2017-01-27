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


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentPostFragment extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseReference;
    private EditText studentName;
    private EditText studentAge;
    private EditText studentQualification;
    private EditText studentInstitute;
    private EditText studentExperience;
    private Button studentPost;
    private Student student;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    public StudentPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_post, container, false);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("student");

        studentName = (EditText)view.findViewById(R.id.StudentEditName);
        studentAge = (EditText) view.findViewById(R.id.StudentEditAge);
        studentQualification = (EditText) view.findViewById(R.id.StudentEditQualify);
        studentInstitute = (EditText) view.findViewById(R.id.StudentEditInstitution);
        studentExperience = (EditText) view.findViewById(R.id.StudentEditExperience);
        studentPost = (Button) view.findViewById(R.id.studentPost);



        //to send data.
        studentPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student = new Student(studentName.getText().toString(), studentAge.getText().toString(),studentQualification.getText().toString(),studentInstitute.getText().toString(),studentExperience.getText().toString());
                mDatabaseReference.push().setValue(student);
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.mFragStudent, new StudentFragment()).commit();

            }
        });



        return view;
    }

}
