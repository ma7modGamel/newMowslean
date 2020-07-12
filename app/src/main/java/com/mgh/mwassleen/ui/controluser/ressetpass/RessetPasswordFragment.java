package com.mgh.mwassleen.ui.controluser.ressetpass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.FragmentRessetPasswordBinding;
import com.mgh.mwassleen.utils.Utils;

public class RessetPasswordFragment extends Fragment {

    private RessetPasswordViewModel mViewModel;
    FragmentRessetPasswordBinding fragmentRessetPasswordBinding;
    public static RessetPasswordFragment newInstance() {
        return new RessetPasswordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       fragmentRessetPasswordBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_resset_password, container, false);
       return fragmentRessetPasswordBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(RessetPasswordViewModel.class);
        // TODO: Use the ViewModel
        fragmentRessetPasswordBinding.setResetPassVmodel(mViewModel);
        fragmentRessetPasswordBinding.setLifecycleOwner(this);
        Utils.setLocale(getContext(),"en");
    }
}