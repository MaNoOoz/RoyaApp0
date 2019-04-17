package com.example.myapplication.Network;

/*
 * Copyright (c) Created By Yaman Alkhateeb  2019.
 */

import com.example.myapplication.POJO.Comment;
import com.example.myapplication.POJO.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface myApi {

    //Specify the request type and pass the relative URL//
    @GET("/users")
    //Wrap the response in a Call object with the type of the expected result// *ps: i can pass Integer(accept null value)
    Call<List<com.example.myapplication.POJO.Comment>> getAllUsers(
            @Query("id") Integer userId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    @GET("/comments")
        //Wrap the response in a Call object with the type of the expected result//
    Call<List<com.example.myapplication.POJO.Comment>> getAllComments(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    // Using Map
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET
    Call<List<Comment>> getComments(@Url String url);

    //    Post =================================================================

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);


    @Headers("Static Header :123")
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Header("Dynamic") String header, @Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
