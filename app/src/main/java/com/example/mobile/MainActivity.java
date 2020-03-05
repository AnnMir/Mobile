package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null)
            showFragment("start", "start text");
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment("label1", "text1");
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment("label2", "text2");
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment("label3", "text3");
            }
        });
    }

    public void showFragment(String label, String text){
        ButtonFragment fragment = new ButtonFragment();
        Bundle bundle = new Bundle();
        bundle.putString("label", label);
        bundle.putString("text", text);
        fragment.setArguments(bundle);
        getSupportFragmentManager().popBackStack("Text", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, fragment)
                .commit();
    }
}