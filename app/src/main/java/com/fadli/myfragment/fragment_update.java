package com.fadli.myfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fragment_update extends Fragment implements View.OnClickListener{
    static EditText up_npm,up_user,up_email;
    static String user, email, npm;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_update, container, false);
        Button bt1 = (Button)v.findViewById(R.id.bt_update);
        bt1.setOnClickListener(this);
        return v;
    }
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_update:
                up_users();
                break;
        }

    }
    public void up_users() {
        up_npm = (EditText) getView().findViewById(R.id.update_npm);
        up_user = (EditText) getView().findViewById(R.id.update_name);
        up_email = (EditText ) getView().findViewById(R.id.update_email);
        user = up_user.getText().toString();
        email = up_email.getText().toString();
        npm = up_npm.getText().toString();
        Users users = new Users(npm, user, email);
        mDatabase.child("users").child(npm).setValue(users);
    }
}