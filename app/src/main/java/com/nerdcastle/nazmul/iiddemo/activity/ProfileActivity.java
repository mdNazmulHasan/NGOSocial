package com.nerdcastle.nazmul.iiddemo.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;
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
    ImageView profilePhotoView;
    ImageView expandedImage;
    TextView profileNameText;
    TextView aboutText;
    LinearLayout basicInfoHeader;
    LinearLayout infoLoader;
    CircularFillableLoaders circularFillableLoaders;
    private Handler handler;
    int progress=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        handler = new Handler();
        networkingLibraryInitilizer();
        viewInitializer();
        makeViewGone();
        getData();
        fillTheLoader();

    }

    private void fillTheLoader() {
       new Thread(new Task()).start();


    }
    class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 100; i >0; i-=15) {
                final int value = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        circularFillableLoaders.setProgress(value);
                    }
                });
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                makeViewBackAgain();
                }
            });
        }


    }

    private void viewInitializer() {
        profilePhotoView= (ImageView) findViewById(R.id.profilePhoto);
        profileNameText= (TextView) findViewById(R.id.profileNameText);
        basicInfoHeader= (LinearLayout) findViewById(R.id.basicInfoHeader);
        aboutText= (TextView) findViewById(R.id.aboutText);
        expandedImage= (ImageView) findViewById(R.id.expandedImage);
        infoLoader= (LinearLayout) findViewById(R.id.infoLoaderLayout);
        circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
    }
    private void makeViewGone(){
        expandedImage.setVisibility(View.GONE);
        infoLoader.setVisibility(View.GONE);
    }
    private void makeViewBackAgain(){
        circularFillableLoaders.setProgress(0);
        circularFillableLoaders.setVisibility(View.GONE);
        expandedImage.setVisibility(View.VISIBLE);
        infoLoader.setVisibility(View.VISIBLE);
    }

    private void getData() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("organizationId", organizationId);
        data.put("token", token);

        Call<OrganizationProfileResponse>organizationProfileResponseCall=organizationApi.getOrganizationResponseCall(data);
        organizationProfileResponseCall.enqueue(new Callback<OrganizationProfileResponse>() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onResponse(Call<OrganizationProfileResponse> call, Response<OrganizationProfileResponse> response) {
                Log.e("success", "onResponse: "+response.body());
                OrganizationProfileResponse organizationProfileResponse=response.body();
                String stringPicture=organizationProfileResponse.getProfilePhoto();
                byte[] decodedString = Base64.decode(stringPicture, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                profilePhotoView.setImageBitmap(decodedByte);
                profileNameText.setText(organizationProfileResponse.getName());
                aboutText.setText(organizationProfileResponse.getAbout());
                Log.e("name", "onResponse: "+organizationProfileResponse.getName() );

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
