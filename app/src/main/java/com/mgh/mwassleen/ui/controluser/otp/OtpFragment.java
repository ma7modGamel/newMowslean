package com.mgh.mwassleen.ui.controluser.otp;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.davidmiguel.numberkeyboard.NumberKeyboardListener;
import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.OtpFragmentBinding;
import com.mgh.mwassleen.models.Login.Data;

import com.mgh.mwassleen.models.Otp.OtpModel;
import com.mgh.mwassleen.ui.MainActivity;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.Utils;


public class OtpFragment extends Fragment {

    private OtpViewModel mViewModel;
    OtpFragmentBinding otpFragmentBinding;

    public static OtpFragment newInstance() {
        return new OtpFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        otpFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.otp_fragment, container, false);
        globalPrefrencies=new GlobalPrefrencies(getContext());
        Utils.setLocale(getContext(),"en");
        return  otpFragmentBinding.getRoot();
    }

    GlobalPrefrencies globalPrefrencies;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OtpViewModel.class);
        otpFragmentBinding.setLifecycleOwner(this);
        otpFragmentBinding.setOtpVmodel(mViewModel);


        final Data dataUser = (Data) getArguments().getSerializable("dataUser");


        otpFragmentBinding.etOtp.setFocusable(false);
        otpFragmentBinding.numberKeyboard.setListener(new NumberKeyboardListener() {
            @Override
            public void onNumberClicked(int number) {
                if(otpFragmentBinding.etOtp.getText().toString().length()<4) {
                    otpFragmentBinding.etOtp.setText(otpFragmentBinding.etOtp.getText().toString() + number + "");
                }
            }
            @Override
            public void onLeftAuxButtonClicked() {
            }
            @Override
            public void onRightAuxButtonClicked() {
                otpFragmentBinding.etOtp.setText("");
            }
        });
        otpFragmentBinding.btnVeriFy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerifYNow(dataUser);
            }
        });
    }

    private void VerifYNow(Data dataUser) {


        mViewModel.onClickVerify(dataUser.getPhone(),otpFragmentBinding.etOtp.getText().toString(),getContext());
        mViewModel.otpModelMutableLiveData.observe(this, new Observer<OtpModel>() {
            @Override
            public void onChanged(OtpModel otpModel) {

                com.mgh.mwassleen.models.Otp.Data dataModel = otpModel.getData();

                    int id = dataModel.getId();
                    String name =  dataModel.getName();
                    String phone =  dataModel.getPhone()+"";
                    String api_token =  dataModel.getToken();
                    Toast.makeText(getContext(), "مرحبا بك " + name, Toast.LENGTH_LONG).show();

                    globalPrefrencies.storeLoginStatus(true);

                    globalPrefrencies.storeUserId(id);
                    globalPrefrencies.storeName(name);
                    globalPrefrencies.storePhone(phone);

                    globalPrefrencies.storeApi_token(api_token);

                    Intent  intent=new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
            }
        });
    }
}
