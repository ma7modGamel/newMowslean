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
import android.widget.Toast;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.LoginFragmentBinding;
import com.mgh.mwassleen.models.Login.Data;
import com.mgh.mwassleen.models.Login.UserLoginModel;
import com.mgh.mwassleen.ui.MainActivity;
import com.mgh.mwassleen.ui.controluser.ressetpass.RessetPasswordFragment;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.Utils;

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

    GlobalPrefrencies globalPrefrencies;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(LoginViewModel.class);
        globalPrefrencies = new GlobalPrefrencies(getContext());
        Utils.setLocale(getContext(),globalPrefrencies.getLanguage());
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
                if (onCheackValidation()) {
                    setUpLogin();
                }
            }
        });

    }
    private void setUpLogin() {
        mViewModel.onClickLogin(loginFragmentBinding.etUserName.getText().toString(),getContext());
        mViewModel.userLoginModelMutableLiveData.observe(this, new Observer<UserLoginModel>() {
            @Override
            public void onChanged(UserLoginModel data) {
                int id = data.getData().getId();
                String name = data.getData().getName();
                String phone = data.getData().getPhone().toString();
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Toast.makeText(getContext(), "مرحبا بك " + name, Toast.LENGTH_LONG).show();

                globalPrefrencies.storeLoginStatus(true);
                globalPrefrencies.storeUserId(id);
                globalPrefrencies.storeName(name);
                globalPrefrencies.storePhone(phone);

            }
        });

        mViewModel.onClickLogin(
                loginFragmentBinding.etUserName.getText().toString()
                , getContext());
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
    public boolean onCheackValidation() {

        if (!ValidatePhone()) {
            return false;
        }
        return true;
    }


    private boolean ValidatePhone() {
        if (loginFragmentBinding.etUserName.getText().toString().trim().isEmpty()) {
            loginFragmentBinding.etUserName.setError("من فضلك املأ هذا الحقل");
            Utils.requestFocus(loginFragmentBinding.etPassword, getActivity().getWindow());
            return false;
        }
        return true;
    }
}