package com.example.pauline.easyvoting.ui;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pauline.easyvoting.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;



public class yes_no extends Fragment implements View.OnClickListener {


    public Context context;

    public yes_no() {
        // Required empty public constructor
    }
    public  int YesCounter = 0;
    public  int NoCounter = 0;


    @Bind(R.id.textCounter)
    TextView mCounter;
    @Bind(R.id.yesButton) Button mYesButton;
    @Bind(R.id.noButton) Button mNoButton;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yes_no, container, false);

        ButterKnife.bind(this, view);


        mNoButton.setOnClickListener(this);
        mYesButton.setOnClickListener(this);




        return view;
    }




    @Override
    public void onClick(View view) {

        if (view == mYesButton) {
            FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
            String uid = users.getUid();
            DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("issue").child(uid);

            ref2.child("vote").setValue("yes");
            // ref2.push().setValue("yes");




            ref2.addValueEventListener(new ValueEventListener(){

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<String>  arr = new ArrayList<String>();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        arr.add( snapshot.getValue().toString());

                    }
                    mCounter.setText(Integer.toString(arr.size()));


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                   // Log.w( TAG ,"not accepted");
                }
            });




            mYesButton.setEnabled(false);



        }

        if (view == mNoButton) {
            FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
            String uid = users.getUid();

            DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("issue").child(uid);
            ref2.child("vote").setValue("no");
            // ref2.push().setValue("yes");



            ref2.addValueEventListener(new ValueEventListener(){

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<String>  arr = new ArrayList<String>();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        arr.add( snapshot.getValue().toString());

                    }
                    mCounter.setText(Integer.toString(arr.size()));


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Log.w( TAG ,"not accepted");
                }
            });




            mNoButton.setEnabled(false);


        }




    }

}