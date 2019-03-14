package com.example.win10.bahanpercobaan2.API_Interface.API_CRUD;

import com.example.win10.bahanpercobaan2.Model.DbPadi;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class CRUDPadi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    DbPadi mDbPadi;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public DbPadi getPadi() {
        return mDbPadi;
    }
    public void setPadi(DbPadi DbPadi) {
        mDbPadi = DbPadi;
    }

}