package com.example.pauline.easyvoting.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pauline.easyvoting.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;


public class question extends Fragment implements View.OnClickListener {
    @Bind(R.id.questionTextView) TextView mQuestion;
    @Bind(R.id.buttonVote) Button mvote;

    public static final  String TAG = question.class.getSimpleName();


    public question() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//     mQuestion.setText(getArguments().getString("issue"));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_question, container, false);
        ButterKnife.bind(this,view);

        mvote.setOnClickListener(this);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("issue").child("saidVotingMatter");
        ref.toString();

        ref.addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String  queston = snapshot.getValue().toString();

                    mQuestion.setText(queston);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w( TAG ,"not accepted");
            }
        });



        return  view;

    }

    @Override
    public void onClick(View v) {

        if (v == mvote) {

            Fragment yesno = new yes_no();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.framelayout, yesno);
            transaction.commit();


        }
    }




}
