package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //"Альбомная ориентация"
            if(savedInstanceState == null || getSupportFragmentManager().getBackStackEntryCount()==0)
                showFragment("start", "start text");
        }
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                    hideMenu();
                showFragment("label1", "text1");
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                    hideMenu();
                showFragment("label2", "text2");
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                    hideMenu();
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
                .addToBackStack("Button")
                .replace(R.id.frame, fragment)
                .commit();
    }

    public void hideMenu(){
        MenuFragment firstFragment = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_menu);
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .hide(firstFragment)
                .commit();
    }

    public void showMenu(){
        MenuFragment firstFragment = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_menu);
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_out, android.R.anim.fade_in)
                .show(firstFragment)
                .commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Проверяем ориентацию экрана
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showMenu();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            hideMenu();
        }
    }

    @Override
    public void onBackPressed() {
        int index = getSupportFragmentManager().getBackStackEntryCount() - 1;
        String tag = "";
        if(index>=0) {
            FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index);
            tag = backEntry.getName();
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            if(tag.equals("Button"))
                this.finish();
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            if(tag.equals("Button")){
                MenuFragment firstFragment = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_menu);
                if(firstFragment.isHidden()) {
                    getSupportFragmentManager().popBackStack("Button", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    showMenu();
                    return;
                }else
                    this.finish();
            }
        }
        super.onBackPressed();
    }
}