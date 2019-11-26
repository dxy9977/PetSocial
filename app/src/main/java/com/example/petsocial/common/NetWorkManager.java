package com.example.petsocial.common;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {
    String BASE_URL = "http://api.heclouds.com/devices/";
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
     * 初始化必要对象和参数
     * "api-key: myBblGC5xliTlK01a7C7bDT4fig=",
     * "Content-Type: application/json"
     */
    public void init() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        //.addHeader("api-key", "myBblGC5xliTlK01a7C7bDT4fig=")
                        //.addHeader("Content-Type", "application/json")
                        .build();

                return chain.proceed(request);
            }
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

