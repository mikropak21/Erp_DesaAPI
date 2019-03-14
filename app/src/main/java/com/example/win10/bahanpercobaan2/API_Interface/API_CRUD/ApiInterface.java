package com.example.win10.bahanpercobaan2.API_Interface.API_CRUD;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
//    @GET("padi")
//    Call<GetPadi> getPadi();

    @FormUrlEncoded
    @POST("padi/input")
    Call<CRUDPadi> postPadi(@Field("luas_lahan") Integer luas_lahan,
                            @Field("tgl_tanam") String tgl_tanam,
                            @Field("tgl_siap_panen") String tgl_siap_panen,
                            @Field("hasil_panen") String hasil_panen,
                            @Field("pemilik") String pemilik,
                            @Field("nik") Integer nik,
                            @Field("pekerja") Integer pekerja
    );
    @FormUrlEncoded
    @PUT("padi/update")
    Call<CRUDPadi> putPadi(@Field("luas_lahan") Integer luas_lahan,
                           @Field("tgl_tanam") String tgl_tanam,
                           @Field("tgl_siap_panen") String tgl_siap_panen,
                           @Field("hasil_panen") String hasil_panen,
                           @Field("pemilik") String pemilik,
                           @Field("nik") Integer nik,
                           @Field("pekerja") Integer pekerja,
                           @Field("id") Integer id);
    @FormUrlEncoded
    @HTTP(method = "DELETE",path = "padi/delete",hasBody = true)
    Call<CRUDPadi> deletePadi(@Field("id") String id);
}