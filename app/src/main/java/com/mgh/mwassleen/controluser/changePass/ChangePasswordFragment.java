package com.mgh.mwassleen.controluser.changePass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.controluser.login.LoginViewModel;
import com.mgh.mwassleen.controluser.login.loginFragment;

public class ChangePasswordFragment extends Fragment {

    private ChangePasswordViewModel mViewModel;

    public static ChangePasswordFragment newInstance() {
        return new ChangePasswordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(ChangePasswordViewModel.class);
        // TODO: Use the ViewModel
    }

}