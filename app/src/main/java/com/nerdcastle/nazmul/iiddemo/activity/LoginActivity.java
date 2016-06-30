package com.nerdcastle.nazmul.iiddemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.nerdcastle.nazmul.iiddemo.Interfaces.LoginApi;
import com.nerdcastle.nazmul.iiddemo.R;
import com.nerdcastle.nazmul.iiddemo.Utils.Constants;
import com.nerdcastle.nazmul.iiddemo.models.TokenRequest;
import com.nerdcastle.nazmul.iiddemo.models.TokenResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText loginIDEditText;
    EditText passwordEditText;
    LoginApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initializeView();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.IID_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service=retrofit.create(LoginApi.class);
    }

    private void initializeView() {
        loginIDEditText= (EditText) findViewById(R.id.edit_text_login_id);
        passwordEditText= (EditText) findViewById(R.id.edit_text_password);
    }

    public void onSignInPressed(View view) {

        TokenRequest tokenRequest=new TokenRequest();
        tokenRequest.setLoginId(loginIDEditText.getText().toString());
        tokenRequest.setPassword(passwordEditText.getText().toString());
        Call<TokenResponse>tokenResponseCall=service.getTokenResponseCall(tokenRequest);
        tokenResponseCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                int statusCode=response.code();
                TokenResponse tokenResponse=response.body();
                Log.d("Login", "onResponse: "+statusCode);
                Log.d("login", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.d("Login", "onFailure: "+t.getMessage());

            }
        });
    }
}
