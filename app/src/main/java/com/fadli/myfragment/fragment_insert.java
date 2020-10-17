package com.fadli.myfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class fragment_insert extends Fragment implements View.OnClickListener{
    static EditText ins_user, ins_email, ins_npm;
    static Button bt_insert;
    static String user, email, npm;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    View fragment_insert_new;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment_insert_new = inflater.inflate(R.layout.fragment_insert, container, false);
        bt_insert = (Button) fragment_insert_new.findViewById(R.id.INSERT_DATA);
        bt_insert.setOnClickListener(this);
        return fragment_insert_new;
    }
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.INSERT_DATA:
                set_users();
                break;
        }
    }
    public void set_users() {
        ins_npm = (EditText) getView().findViewById(R.id.insert_npm);
        ins_user = (EditText) getView().findViewById(R.id.insert_name);
        ins_email = (EditText ) getView().findViewById(R.id.insert_email);
        user = ins_user.getText().toString();
        email = ins_email.getText().toString();
        npm = ins_npm.getText().toString();
        Users users = new Users(npm, user, email);
        mDatabase.child("users").child(npm).setValue(users);
    }
}