package com.mgh.mwassleen.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.ui.controluser.login.LoginFragment;
import com.mgh.mwassleen.ui.controluser.regester.RegisterFragment;

import com.mgh.mwassleen.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Utils.setLocale(this,"en");


    }

    public void openLogin(View view) {
       showFragment(new LoginFragment());
    }
    public void showFragment(Fragment fragment) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void openRegester(View view) {
        showFragment(new RegisterFragment());
    }
}