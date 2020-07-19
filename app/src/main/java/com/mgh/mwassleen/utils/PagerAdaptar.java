package com.mgh.mwassleen.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

public class PagerAdaptar extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentList;

    public PagerAdaptar(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addNewFragment(Fragment fragment) {
        reverse(fragmentList);
        fragmentList.add(fragment);
    }
}
