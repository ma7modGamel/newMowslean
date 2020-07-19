package com.mgh.mwassleen.ui.controluser.login;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.LoginFragmentBinding;
import com.mgh.mwassleen.models.Login.UserLoginModel;
import com.mgh.mwassleen.ui.MainActivity;
import com.mgh.mwassleen.ui.controluser.otp.OtpFragment;
import com.mgh.mwassleen.ui.controluser.ressetpass.RessetPasswordFragment;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;

    LoginFragmentBinding loginFragmentBinding;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        loginFragmentBinding= DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
        loginFragmentBinding.setLoginVvModel(mViewModel);
        loginFragmentBinding.setLifecycleOwner(this);


        loginFragmentBinding.tvForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new RessetPasswordFragment());
            }
        });
        loginFragmentBinding.ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backPressed();
            }
        });
        loginFragmentBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              LoginUser();
            }
        });



    }

    private void LoginUser() {
        mViewModel.onClickLogin(loginFragmentBinding.etUserName.getText().toString(),getContext());
        mViewModel.userLoginModelMutableLiveData.observe(this, new Observer<UserLoginModel>() {
            @Override
            public void onChanged(UserLoginModel userLoginModel) {
                if(userLoginModel!=null) {

                    Bundle bundle=new Bundle();
                    bundle.putSerializable("dataUser", userLoginModel.getData());
                    OtpFragment otpFragment=new OtpFragment();
                    otpFragment.setArguments(bundle);
                    showFragment(otpFragment);

                }
            }
        });
    }

    public void showFragment(Fragment fragment) {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
    private void backPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            getActivity().finish();
        }
    }
}