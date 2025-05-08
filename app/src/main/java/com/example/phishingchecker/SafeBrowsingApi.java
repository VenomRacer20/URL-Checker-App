package com.example.phishingchecker;

import android.webkit.SafeBrowsingResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
public interface SafeBrowsingApi {

    @POST("v4/threatMatches:find")
    @Headers("Content-Type: application/json")
    Call<SafeBrowsingResponse> checkUrl(@Body SafeBrowsingRequest request);
}
