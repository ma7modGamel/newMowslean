package com.mgh.mwassleen.ui;

import android.os.Bundle;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.ActivityMainBinding;
import com.mgh.mwassleen.ui.mainfragments.notifications.NotificationsFragment;
import com.mgh.mwassleen.ui.mainfragments.orders.OrdersFragment;
import com.mgh.mwassleen.ui.mainfragments.profile.ProfileFragment;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.PagerAdaptar;
import com.mgh.mwassleen.utils.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    ActivityMainBinding activityMainBinding;


    GlobalPrefrencies globalPrefrencies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel= new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityMainBinding.setMainVmodel(viewModel);
        globalPrefrencies=new GlobalPrefrencies(this);
        activityMainBinding.setLifecycleOwner(this);
        Utils.setLocale(this,globalPrefrencies.getLanguage());
        setSupportActionBar(activityMainBinding.toolbar);

        initWidget();
    }
    PagerAdaptar adaptar;
    private void initWidget() {

        adaptar = new PagerAdaptar(getSupportFragmentManager());
        adaptar.addNewFragment(new OrdersFragment());
        adaptar.addNewFragment(new NotificationsFragment());
        adaptar.addNewFragment(new ProfileFragment());
        activityMainBinding.tabLayout.setupWithViewPager(activityMainBinding.viewpager);
        activityMainBinding.viewpager.setAdapter(adaptar);
        setUpTabsTopPager();

    }
    private void setUpTabsTopPager() {
     activityMainBinding.tabLayout.getTabAt(0).setText("الطلبات");
        activityMainBinding.tabLayout.getTabAt(0).setIcon(R.drawable.avatar);
        activityMainBinding.tabLayout.getTabAt(1).setText("");
        activityMainBinding.tabLayout.getTabAt(2 ).setText("حسابي");

        //tabLayout.setTabTextColors(Color.parseColor("#FFAFAFAF"), Color.parseColor("#000000"));

    }


}