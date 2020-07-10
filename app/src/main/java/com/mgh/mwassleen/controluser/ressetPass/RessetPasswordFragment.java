package com.mgh.mwassleen.controluser.ressetPass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mgh.mwassleen.R;

public class RessetPasswordFragment extends Fragment {

    private RessetPasswordViewModel mViewModel;

    public static RessetPasswordFragment newInstance() {
        return new RessetPasswordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resset_password, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(RessetPasswordViewModel.class);
        // TODO: Use the ViewModel
    }

}