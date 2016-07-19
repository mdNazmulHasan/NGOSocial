package com.nerdcastle.nazmul.iiddemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nerdcastle.nazmul.iiddemo.Interfaces.ActivitiesApi;
import com.nerdcastle.nazmul.iiddemo.Interfaces.OrganizationApi;
import com.nerdcastle.nazmul.iiddemo.R;
import com.nerdcastle.nazmul.iiddemo.Utils.Constants;
import com.nerdcastle.nazmul.iiddemo.models.OrganizationProfileResponse;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {
    OrganizationApi organizationApi;
    String organizationId=String.valueOf(1);
    String token="30-06-2016-1-4";
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        networkingLibraryInitilizer();
        getData();
    }

    private void getData() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("organizationId", organizationId);
        data.put("token", token);

        Call<OrganizationProfileResponse>organizationProfileResponseCall=organizationApi.getOrganizationResponseCall(data);
        organizationProfileResponseCall.enqueue(new Callback<OrganizationProfileResponse>() {
            @Override
            public void onResponse(Call<OrganizationProfileResponse> call, Response<OrganizationProfileResponse> response) {
                Log.e("success", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<OrganizationProfileResponse> call, Throwable t) {
                Log.e("failed", "onFailure: "+t.getMessage());
            }
        });
        Log.e("data", "getData: " +organizationProfileResponseCall.request().url());
    }

    private void networkingLibraryInitilizer() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.IID_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        organizationApi=retrofit.create(OrganizationApi.class);
    }
}
