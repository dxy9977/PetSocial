package com.example.petsocial.common;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 接口
 */
public interface ServerApi {

    //账号登录
    @GET("")
    Observable<ResponseBody> checkLogin(@Query("name") String name, @Query("psd") String psd);

    //手机验证码登录
    @GET("")
    Observable<ResponseBody> checkLogin1(@Query("phone") String phone, @Query("code") String code);

    //获取验证码
    @GET("")
    Observable<ResponseBody> getCode(@Query("phone") String phone);

    //重置密码
    @GET("")
    Observable<ResponseBody> resetPsd(@Query("phone") String phone, @Query("code") String code, @Query("psd") String psd);

    //注册账号
    @GET("")
    Observable<ResponseBody> register(@Query("phone") String phone, @Query("code") String code, @Query("psd") String psd);
}
