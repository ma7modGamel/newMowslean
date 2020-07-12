package com.mgh.mwassleen.ui;

import android.os.Bundle;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.ui.controluser.login.LoginFragment;
import com.mgh.mwassleen.utils.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class UserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Utils.setLocale(this,"en");
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
}