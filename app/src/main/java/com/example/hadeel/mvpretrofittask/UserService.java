package com.example.hadeel.mvpretrofittask;

import android.telecom.Call;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dena on 10/27/2017.
 */

public class UserService {
    private static String BASE_URL="https://api.github.com";
    public interface UserAPI{
        @GET("/users")

        retrofit2.Call<List<User>> getUsers();;

    }
    public UserAPI getAPI(){
        Retrofit retrofit =new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(UserAPI.class);
    }
}
