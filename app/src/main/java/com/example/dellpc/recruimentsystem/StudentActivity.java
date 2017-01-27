package com.example.dellpc.recruimentsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public static final int RC_SIGN_IN = 1;

    private String mUsername;

    private FirebaseDatabase mFirebaseDatabase;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;



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

        mFirebaseDatabase = mFirebaseDatabase.getInstance();
        mFirebaseAuth = mFirebaseAuth.getInstance();

        mFragmentTransaction.replace(R.id.mFragStudent, new StudentPostFragment()).commit();
        mAuthStateListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
//                    Toast.makeText(MainActivity.this, "Signed In", Toast.LENGTH_SHORT).show();
                    OnSignedInInitialized(user.getDisplayName());

                } else {
                    OnSignedOutCleanUp();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,
                                            AuthUI.GOOGLE_PROVIDER)
                                    .build(),
                            RC_SIGN_IN);

                }

            }
        };




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }


        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListner);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAuthStateListner != null) {
            mFirebaseAuth.addAuthStateListener(mAuthStateListner);
        }
    }


    private void OnSignedInInitialized(String displayName) {
        mUsername = displayName;
    }


    private void OnSignedOutCleanUp() {
        mUsername = "ANONYMOUS";
    }


}
