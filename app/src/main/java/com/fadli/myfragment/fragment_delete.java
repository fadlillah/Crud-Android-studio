package com.fadli.myfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class fragment_delete extends Fragment implements View.OnClickListener {
    static Button delete;
    static EditText npm;
    static String data_npm;
    DatabaseReference dbFirebase = FirebaseDatabase.getInstance().getReference();
    public fragment_delete() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_delete, container, false);
        delete = (Button)v.findViewById(R.id.bt_del);
        delete.setOnClickListener(this);
        return v;
    }
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_del:
                del_data();
                break;
        }
    }
    public void del_data(){
        npm = (EditText) getView().findViewById(R.id.del_npm);
        data_npm = npm.getText().toString();
        TextView txt = (TextView)getView().findViewById(R.id.text_del);
        txt.setText("DELETE DATA NPM: "+data_npm);
        dbFirebase.child("users").child(data_npm).removeValue();
    }

}