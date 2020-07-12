package com.mgh.mwassleen.ui;

import android.os.Bundle;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel= new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityMainBinding.setMainVmodel(viewModel);
        activityMainBinding.setLifecycleOwner(this);
        setSupportActionBar(activityMainBinding.toolbar);



    }


}