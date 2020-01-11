package model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestController {
    @GET("/posts")
    Call<User> doGetListUserResources();

    @POST("/posts")
    Call<Task> createTask(@Body Task task);

    @GET("/posts")
    Call<User> doGetUserList(@Query("userId") String page);

    @FormUrlEncoded
    @POST("/posts")
    Call<Task> doCreateTaskWithField(@Field("title") String name, @Field("body") String job);


}
