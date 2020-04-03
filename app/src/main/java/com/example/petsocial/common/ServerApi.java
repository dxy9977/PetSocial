package com.example.petsocial.common;


import com.example.petsocial.entity.ArticleEntity;
import com.example.petsocial.entity.CommentEntity;
import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.FirstEntity;
import com.example.petsocial.entity.FriendEntity;
import com.example.petsocial.entity.LoginEntity;
import com.example.petsocial.entity.MainEntity;
import com.example.petsocial.entity.MyResponse;
import com.example.petsocial.entity.NewsEntity;
import com.example.petsocial.entity.UserEntity;
import com.example.petsocial.entity.UserInfoEntity;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

/**
 * 接口
 */
public interface ServerApi {

    //1.发送验证码（专门用于注册）
    @POST("user/sendValidate")
    @FormUrlEncoded
    Observable<ResponseBody> sendValidate(@Field("phone") String phone);

    //注册
    @POST("user/register")
    Observable<ResponseBody> register(@Body RequestBody body);

    //登陆(用户密码方式)
    @POST("user/login1")
    Observable<LoginEntity> login1(@Body RequestBody body);


    //4.验证码登陆(验证码方式)
    @POST("user/login2")
    @FormUrlEncoded
    Observable<LoginEntity> login2(@Field("phone") String phone, @Field("verifyCode") String verifyCode);

    //退出登陆
    @POST("user/login2")
    Observable<ResponseBody> logout(@Body RequestBody body);


    //updateUserFirst
    @POST("user/updateUserFirst")
    Observable<ResponseBody> updateUserFirst(@Body RequestBody body);

    //updatePassword
    @POST("user/updatePassword")
    Observable<ResponseBody> updatePassword(@Body RequestBody body);

    //拉取自己的动态
    @POST("moments/pullMomentSelf")
    Observable<DataEntity> pullMomentSelf(@Body RequestBody body);

    //更改用户信息
    @POST("user/updateUser")
    Observable<ResponseBody> updateUser(@Body RequestBody body);

    //添加评论
    @POST("replies/addComment")
    Observable<ResponseBody> addComment(@Body RequestBody body);

    // 文件图片上传
    @Multipart
    @POST("file/upload")
    Observable<ResponseBody> upload(@Part MultipartBody.Part file, @Part("photoType") RequestBody description);    // 文件图片上传

    //多文件图片上传
    @Multipart
    @POST("file/uploads")
    Observable<ResponseBody> uploads(@Part List<MultipartBody.Part> list, @Part("photoType") RequestBody description);

    //发布动态
    @POST("moments/pushMoments")
    Observable<ResponseBody> pushMoments(@Body RequestBody body);

    //拉取好友列表
    @POST("subscriptions/list")
    Observable<FriendEntity> getFriendList(@Body RequestBody body);

    //查找好友
    @POST("subscriptions/findUser")
    Observable<ResponseBody> findUser(@Body RequestBody body);

    //添加好友
    @POST("subscriptions/addUser")
    Observable<ResponseBody> addUser();

    //是否确认添加好友
    @POST("subscriptions/confirmAdd")
    Observable<ResponseBody> confirmAdd(@Body RequestBody body);

    //查询是否有好友添加我
    @GET("subscriptions/findFriendToMe")
    Observable<ResponseBody> findFriendToMe(@Body RequestBody body);

    //findByMid
    @GET("replies/findByMid/{id}")
    Observable<CommentEntity> findByMid(@Path("id") String i);



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


    //首页主页
    @POST("v1/home/detail")
    Observable<FirstEntity> getMain();

    //获取动态
    @POST("v1/news/list/0/50")
    Observable<MyResponse<List<NewsEntity>>> getNews(@Body RequestBody body);


    //评论列表
    @POST("v1/comment/list/0/10")
    Observable<CommentEntity> getComment(@Body RequestBody body);


    //创建动态
    @POST("v1/news/create")
    Observable<ResponseBody> addNews(@Body RequestBody body);

    //查看文章https://api.atatakai.cn/api/v1/article/list/0/4
    @POST("v1/article/list/0/4")
    Observable<ArticleEntity> getArticle(@Body RequestBody body);
}
