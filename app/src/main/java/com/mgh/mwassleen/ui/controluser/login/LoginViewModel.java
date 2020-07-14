package com.mgh.mwassleen.ui.controluser.login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mgh.mwassleen.NetWork.RetroWeb;
import com.mgh.mwassleen.NetWork.ServiceApi;
import com.mgh.mwassleen.models.Login.Data;
import com.mgh.mwassleen.models.Login.UserLoginModel;
import com.mgh.mwassleen.ui.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    MutableLiveData<UserLoginModel> userLoginModelMutableLiveData = new MutableLiveData<>();
    UserLoginModel model;

    public void onClickLogin(String phone, final Context context) {

        model = null;

        RetroWeb.getClient().create(ServiceApi.class).onLogin(phone).enqueue(new Callback<UserLoginModel>() {
            @Override
            public void onResponse(Call<UserLoginModel> call, Response<UserLoginModel> response) {

                    model = response.body();
                    userLoginModelMutableLiveData.setValue(response.body());
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<UserLoginModel> call, Throwable t) {
                    Log.e("Error Login ," ,t.getMessage());
            }
        });
        }
    }
