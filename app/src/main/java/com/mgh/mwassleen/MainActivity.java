package com.mgh.mwassleen;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mgh.mwassleen.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel= new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityMainBinding.setMainVmodel(viewModel);
        activityMainBinding.setLifecycleOwner(this);
        setSupportActionBar(activityMainBinding.toolbar);



    }


}