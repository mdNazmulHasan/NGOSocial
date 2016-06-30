package com.nerdcastle.nazmul.iiddemo.Interfaces;

import com.nerdcastle.nazmul.iiddemo.models.TokenRequest;
import com.nerdcastle.nazmul.iiddemo.models.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by po on 6/28/16.
 */
public interface LoginApi {
    @POST("user/login")
    Call<TokenResponse>getTokenResponseCall(@Body TokenRequest tokenRequest);
}
