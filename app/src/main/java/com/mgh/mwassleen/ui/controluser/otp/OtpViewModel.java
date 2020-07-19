package com.mgh.mwassleen.ui.controluser.otp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mgh.mwassleen.NetWork.RetroWeb;
import com.mgh.mwassleen.NetWork.ServiceApi;
import com.mgh.mwassleen.models.Otp.OtpModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    MutableLiveData<OtpModel> otpModelMutableLiveData = new MutableLiveData<>();
    public void onClickVerify(String phone, String VerifyCode,final Context context) {

        RetroWeb.getClient().create(ServiceApi.class).onVerify(VerifyCode,phone).enqueue(new Callback<OtpModel>() {
            @Override
            public void onResponse(Call<OtpModel> call, Response<OtpModel> response) {

                if (response.isSuccessful()) {
                    otpModelMutableLiveData.setValue(response.body());
                } else {
                    Toast.makeText(context, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OtpModel> call, Throwable t) {
                Log.e("Error Login ,", t.getMessage());
            }
        });
    }
}