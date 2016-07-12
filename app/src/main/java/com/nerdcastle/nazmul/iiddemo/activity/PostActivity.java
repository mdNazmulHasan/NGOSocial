package com.nerdcastle.nazmul.iiddemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nerdcastle.nazmul.iiddemo.Interfaces.ActivitiesApi;
import com.nerdcastle.nazmul.iiddemo.R;
import com.nerdcastle.nazmul.iiddemo.Utils.Constants;
import com.nerdcastle.nazmul.iiddemo.models.SingleActivityResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by po on 6/30/16.
 */
public class PostActivity extends AppCompatActivity {
    private Toolbar toolbar;
    Spinner spinnerActivities;
    private ArrayList<SingleActivityResponse> singleActivityResponses=new ArrayList<>();
    ActivitiesApi activitiesApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        networkingLibraryInitilizer();
        getActivities();
        initializeView();


    }

    private void getActivities() {
        Call<ArrayList<SingleActivityResponse>>call=activitiesApi.getActivitiesResponseCall();
        call.enqueue(new Callback<ArrayList<SingleActivityResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<SingleActivityResponse>> call, Response<ArrayList<SingleActivityResponse>> response) {
                singleActivityResponses=response.body();
                Log.d("activity", "onResponse: "+singleActivityResponses);
                ArrayAdapter<SingleActivityResponse> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.custom_spinner, singleActivityResponses);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerActivities.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<SingleActivityResponse>> call, Throwable t) {

            }
        });
    }

    private void networkingLibraryInitilizer() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.IID_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        activitiesApi=retrofit.create(ActivitiesApi.class);
    }

    private void initializeView() {
        spinnerActivities= (Spinner) findViewById(R.id.activitiesSpinner);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void onPostPressed(View view) {
        Toast.makeText(PostActivity.this, "posting", Toast.LENGTH_SHORT).show();
    }
}
