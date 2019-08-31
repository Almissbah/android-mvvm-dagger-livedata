package com.almissbah.wasit.data.remote.interceptor;


import java.io.IOException;

import com.almissbah.wasit.AppConstants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder newRequest = originalRequest.newBuilder();
        newRequest.header("api_key", AppConstants.SERVER_API_KEY);
        HttpUrl originalUrl = newRequest.build().url();
        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key", AppConstants.SERVER_API_KEY)
                .build();

        Request.Builder requestBuilder = originalRequest.newBuilder().url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
