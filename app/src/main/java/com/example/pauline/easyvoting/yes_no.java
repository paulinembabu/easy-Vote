package com.example.pauline.easyvoting;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;



public class yes_no extends Fragment implements View.OnClickListener {


 public Context context;

    public yes_no() {
        // Required empty public constructor
    }


    @Bind(R.id.AbstButton) Button mAbstButton;
    @Bind(R.id.yesButton) Button mYesButton;
    @Bind(R.id.noButton) Button mNoButton;
    @Bind(R.id.button4) Button mButton4;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_yes_no, container, false);

        ButterKnife.bind(this,view);
        mAbstButton.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mNoButton.setOnClickListener(this);
        mYesButton.setOnClickListener(this);


            return view;
        }




    public void onClick(View view) {

      if(view == mYesButton){

          AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                  context);

          // set title
          alertDialogBuilder.setTitle("Confirmation!");

          // set dialog message
          alertDialogBuilder
                  .setMessage("Are you sure you want to vote this? !")
                  .setCancelable(false)
                  .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog,int id) {
                          // if this button is clicked, close
                          // current activity
//                          yes_no.this.finish();
                      }
                  })
                  .setNegativeButton("No",new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog,int id) {
                          // if this button is clicked, just close
                          // the dialog box and do nothing
                          dialog.cancel();
                      }
                  });

          // create alert dialog
          AlertDialog alertDialog = alertDialogBuilder.create();

          // show it
          alertDialog.show();
      }

    }



}
