package com.example.pauline.easyvoting.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pauline.easyvoting.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pauline on 4/18/17.
 */

public class welcome extends Fragment implements View.OnClickListener {

  //  @Bind(R.id.fab) Button mFloatingButton;
    @Bind(R.id.IView) ImageView Iimage;
    @Bind(R.id.buttonStartVoting) Button mStartVotingButton;


    public static final  String TAG = question.class.getSimpleName();


    public welcome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this,view);


        mStartVotingButton.setOnClickListener(this);
        //mFloatingButton.setOnClickListener(this);


//        mFloatingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        return  view;

    }

    @Override
    public void onClick(View v) {

        if (v == mStartVotingButton) {

            Fragment question = new question();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.framelayout, question);
            transaction.commit();





        }
    }




}
