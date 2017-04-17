package com.example.pauline.easyvoting;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class question extends Fragment implements View.OnClickListener {
    @Bind(R.id.questionTextView)
    TextView mQuestion;
    @Bind(R.id.buttonVote)
    Button mvote;

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

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("easyvoting-5f297");
        Log.d(TAG, ref + ">>>>>>>>");

        ValueEventListener questionListener = new ValueEventListener() {
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
        };

        ref.addValueEventListener(questionListener);




        return  view;

    }

    @Override
    public void onClick(View v) {

        if (v == mvote) {
            Log.d(TAG,  ">>>>>>>>");


           // Intent intent2 = new Intent(question.this, yes_no.class);
           // startActivity(intent2);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();


        }
    }




}
