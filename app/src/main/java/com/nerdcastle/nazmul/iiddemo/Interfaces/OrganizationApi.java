package com.nerdcastle.nazmul.iiddemo.Interfaces;

import com.nerdcastle.nazmul.iiddemo.models.OrganizationProfileResponse;

import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by po on 7/19/16.
 */
public interface OrganizationApi {
    @GET("organization/getprofile")
    Call<OrganizationProfileResponse>getOrganizationResponseCall(@QueryMap LinkedHashMap<String, String> data);
}
