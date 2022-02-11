package com.example.myapplication;
import retrofit2.http.GET;
import retrofit2.Call;
import java.util.*;
public interface myapi {
    @GET("posts")
    Call<List<Model>> getmodels();
}
