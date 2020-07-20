package com.mgh.mwassleen.ui.mainfragments.profile.setting;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.SettingFragmentBinding;

public class SettingFragment extends Fragment {

    private SettingViewModel mViewModel;

    SettingFragmentBinding settingFragmentBinding;
    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        settingFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.setting_fragment, container, false);

        return  settingFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingViewModel.class);
        settingFragmentBinding.setSettingVmodel(mViewModel);

    }

}