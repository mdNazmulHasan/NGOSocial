package com.nerdcastle.nazmul.iiddemo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by po on 6/30/16.
 */
public class TokenResponse {
    @SerializedName("Id")
    @Expose
    private int Id ;
    @SerializedName("OrganizationId")
    @Expose
    private int OrganizationId ;
    @SerializedName("Token")
    @Expose
    private String Token ;
    @SerializedName("ResultState")
    @Expose
    private boolean ResultState ;

    public int getId() {
        return Id;
    }

    public int getOrganizationId() {
        return OrganizationId;
    }

    public String getToken() {
        return Token;
    }

    public boolean isResultState() {
        return ResultState;
    }

    @Override
    public String toString() {
        return Id+" "+OrganizationId+" "+Token+" "+ResultState;
    }
}
