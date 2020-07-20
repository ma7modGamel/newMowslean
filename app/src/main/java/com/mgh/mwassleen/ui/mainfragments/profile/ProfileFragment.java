package com.mgh.mwassleen.ui.mainfragments.profile;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.ProfileFragmentBinding;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.Utils;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    GlobalPrefrencies globalPrefrencies;
    ProfileFragmentBinding profileFragmentBinding;
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       profileFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.profile_fragment, container, false);
        globalPrefrencies =new GlobalPrefrencies(getContext());
        Utils.setLocale(getContext(),"en");
       return  profileFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(ProfileViewModel.class);
        profileFragmentBinding.setProfileVmodel(mViewModel);
        profileFragmentBinding.setLifecycleOwner(this);

        profileFragmentBinding.tvUserName.setText(globalPrefrencies.getName());




    }
    public void showFragment(Fragment fragment) {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.containerProfile, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


}