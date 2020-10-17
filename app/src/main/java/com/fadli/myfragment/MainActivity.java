package com.fadli.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    static Button bt_list, bt_insert, bt_update, bt_delete;
    static Fragment fragment;
    static TextView statusFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_list = findViewById(R.id.BT_LIST);
        bt_update = findViewById(R.id.BT_UPDATE);
        bt_insert = findViewById(R.id.BT_INSERT);
        bt_delete = findViewById(R.id.BT_DELETE);
        bt_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new fragment_list();
                getFragmentPage(fragment);
            }
        });
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new fragment_update();
                getFragmentPage(fragment);
            }
        });
        bt_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new fragment_insert();
                getFragmentPage(fragment);
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new fragment_delete();
                getFragmentPage(fragment);
            }
        });

    }
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}