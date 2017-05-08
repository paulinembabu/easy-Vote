package com.example.pauline.easyvoting.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pauline.easyvoting.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class admin extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.buttonSubmit)
    Button mSubmit;
    @Bind(R.id.editTextIssue)
    EditText mIssue;
    @Bind(R.id.textAdminPage)
    TextView mAdminPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);

        mSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v == mSubmit) {
            String issue = mIssue.getText().toString();



            DatabaseReference adminRef = FirebaseDatabase
                    .getInstance()
                    .getReference("issue").child("saidVotingMatter");


           adminRef.push().setValue(issue);




            Toast.makeText(admin.this, "saved", Toast.LENGTH_SHORT).show();
            mIssue.setText("");


        }
    }
}
