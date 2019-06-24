package com.example.myapplication.Network;

import com.example.myapplication.POJO.User;
import com.example.myapplication.utlis.url_Manager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GithubAndroidClint {

    @GET("/users/{user}/repos")
    Call<List<User>> reposForUser(@Path("user") String user);
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET(url_Manager.GITHUB_API_USERS)
    Call<List<User>> getUsers(@Path("user") String user);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("users/new")
    Call<User> createUser(@Body User user);

}

