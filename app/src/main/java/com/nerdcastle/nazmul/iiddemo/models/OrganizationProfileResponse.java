package com.nerdcastle.nazmul.iiddemo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by po on 7/19/16.
 */
public class OrganizationProfileResponse {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("LoginId")
    @Expose
    private Object loginId;
    @SerializedName("Password")
    @Expose
    private Object password;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ProfilePhoto")
    @Expose
    private String profilePhoto;
    @SerializedName("About")
    @Expose
    private String about;
    @SerializedName("AreaOfInterest")
    @Expose
    private String areaOfInterest;
    @SerializedName("EstablishedDate")
    @Expose
    private String establishedDate;
    @SerializedName("Address")
    @Expose
    private Object address;
    @SerializedName("ContactNo")
    @Expose
    private Object contactNo;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("WebAddress")
    @Expose
    private Object webAddress;
    @SerializedName("EntryDateTime")
    @Expose
    private String entryDateTime;
    @SerializedName("UpazillaId")
    @Expose
    private Integer upazillaId;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The loginId
     */
    public Object getLoginId() {
        return loginId;
    }

    /**
     *
     * @param loginId
     * The LoginId
     */
    public void setLoginId(Object loginId) {
        this.loginId = loginId;
    }

    /**
     *
     * @return
     * The password
     */
    public Object getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The Password
     */
    public void setPassword(Object password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The profilePhoto
     */
    public String getProfilePhoto() {
        return profilePhoto;
    }

    /**
     *
     * @param profilePhoto
     * The ProfilePhoto
     */
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    /**
     *
     * @return
     * The about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The About
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The areaOfInterest
     */
    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    /**
     *
     * @param areaOfInterest
     * The AreaOfInterest
     */
    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    /**
     *
     * @return
     * The establishedDate
     */
    public String getEstablishedDate() {
        return establishedDate;
    }

    /**
     *
     * @param establishedDate
     * The EstablishedDate
     */
    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }

    /**
     *
     * @return
     * The address
     */
    public Object getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The Address
     */
    public void setAddress(Object address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The contactNo
     */
    public Object getContactNo() {
        return contactNo;
    }

    /**
     *
     * @param contactNo
     * The ContactNo
     */
    public void setContactNo(Object contactNo) {
        this.contactNo = contactNo;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The webAddress
     */
    public Object getWebAddress() {
        return webAddress;
    }

    /**
     *
     * @param webAddress
     * The WebAddress
     */
    public void setWebAddress(Object webAddress) {
        this.webAddress = webAddress;
    }

    /**
     *
     * @return
     * The entryDateTime
     */
    public String getEntryDateTime() {
        return entryDateTime;
    }

    /**
     *
     * @param entryDateTime
     * The EntryDateTime
     */
    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     *
     * @return
     * The upazillaId
     */
    public Integer getUpazillaId() {
        return upazillaId;
    }

    /**
     *
     * @param upazillaId
     * The UpazillaId
     */
    public void setUpazillaId(Integer upazillaId) {
        this.upazillaId = upazillaId;
    }

    @Override
    public String toString() {
        return name;
    }
}
