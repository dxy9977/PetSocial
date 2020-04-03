package com.example.petsocial.common;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {
    public static String BASE_URL = "http://47.99.60.167:11002/api/";//测试服务器
    //public static String BASE_URL = "http://192.168.3.53:8080/";//本地
    public static String basic = "OFAKFX2aGYMk1jqNn7hMg5mqXUF0sQWuqa_E8gLUudc";
    private static NetWorkManager mInstance;
    private static Retrofit retrofit;
    private static volatile ServerApi request = null;

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * Route route, Response response
     * 初始化必要对象和参数
     * "api-key: myBblGC5xliTlK01a7C7bDT4fig=",
     * "Content-Type: application/json"
     */
    public void init() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor((chain) -> {
            Request request = chain.request().newBuilder()
                    .addHeader("token", basic)
                    .addHeader("Content-Type", "application/json")
                    .build();
            return chain.proceed(request);
        }).authenticator((route, response) -> {
            return response.request().newBuilder().header("token", basic).build();
        }).build();


        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServerApi getServerApi() {
        if (request == null) {
            synchronized (ServerApi.class) {
                request = retrofit.create(ServerApi.class);
            }
        }
        return request;
    }
}

