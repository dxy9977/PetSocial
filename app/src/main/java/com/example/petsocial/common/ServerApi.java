package com.example.petsocial.common;


import com.example.petsocial.entity.ArticleEntity;
import com.example.petsocial.entity.CommentEntity;
import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.FirstEntity;
import com.example.petsocial.entity.MainEntity;
import com.example.petsocial.entity.MyResponse;
import com.example.petsocial.entity.NewsEntity;
import com.example.petsocial.entity.UserEntity;
import com.example.petsocial.entity.UserInfoEntity;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

/**
 * 接口
 */
public interface ServerApi {

    //1.发送验证码（专门用于注册）
    @POST("/api/user/sendValidate1")
    Observable<ResponseBody> sendValidate1(@Body RequestBody body);

    //注册
    @POST("/api/user/register")
    Observable<ResponseBody> register(@Body RequestBody body);

    //登陆(用户密码方式)
    @POST("/api/user/login1")
    Observable<ResponseBody> login1(@Body RequestBody body);

    //4.验证码登陆(验证码方式)
    @POST("/api/user/sendValidate2")
    Observable<ResponseBody> sendValidate2(@Body RequestBody body);

    //4.验证码登陆(验证码方式)
    @POST("/api/user/login2")
    Observable<ResponseBody> login2(@Body RequestBody body);

    //退出登陆
    @POST("/api/user/login2")
    Observable<ResponseBody> logout(@Body RequestBody body);























    //账号登录
    @POST("v1/public/account/login")
    Observable<MyResponse<UserEntity>> checkLogin(@Body RequestBody body);

    //手机验证码登录
    @GET("")
    Observable<ResponseBody> checkLogin1(@Query("phone") String phone, @Query("code") String code);

    //获取验证码
    @GET("v1/public/captcha/send")
    Observable<ResponseBody> getCode(@Body RequestBody body);

    //重置密码
    @GET("v1/public/account/reset")
    Observable<ResponseBody> resetPsd(@Body RequestBody body);

   /* //注册账号
    @GET("v1/public/account/register")
    Observable<ResponseBody> register(@Query("phone") String phone, @Query("code") String code, @Query("psd") String psd);*/


    //个人详细信息
    @GET("v1/account/detail/{id}")
    Observable<UserInfoEntity> getInfo(@Path("id") int i);


    //个人信息修改
    @POST("v1/account/modify")
    Observable<MyResponse> modifyAccount(@Body RequestBody body);


    // 文件图片上传
    @Multipart
    @POST("v1/file/upload")
    Observable<MyResponse<String>> upload(@Part MultipartBody.Part file);


    //首页主页
    @POST("v1/home/detail")
    Observable<FirstEntity> getMain();

    //获取动态
    @POST("v1/news/list/0/50")
    Observable<MyResponse<List<NewsEntity>>> getNews(@Body RequestBody body);

    //获取个人主页http://api.atatakai.cn/api/v1/account/main/0
    @GET("v1/account/main/{id}")
    Observable<MyResponse<DataEntity>> getData(@Path("id") int i);

    //评论列表
    @POST("v1/comment/list/0/10")
    Observable<CommentEntity> getComment(@Body RequestBody body);

    //创建评论/v1/comment/create
    //评论列表
    @POST("v1/comment/create")
    Observable<ResponseBody> addComment(@Body RequestBody body);


    //创建动态
    @POST("v1/news/create")
    Observable<ResponseBody> addNews(@Body RequestBody body);

    //查看文章https://api.atatakai.cn/api/v1/article/list/0/4
    @POST("v1/article/list/0/4")
    Observable<ArticleEntity> getArticle(@Body RequestBody body);
}
