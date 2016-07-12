package com.nerdcastle.nazmul.iiddemo.Interfaces;

import com.nerdcastle.nazmul.iiddemo.models.SingleActivityResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by po on 7/12/16.
 */
public interface ActivitiesApi {
    @GET("activity/getallactivities")
    Call<ArrayList<SingleActivityResponse>>getActivitiesResponseCall();

}
