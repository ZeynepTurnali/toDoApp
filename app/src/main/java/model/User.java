package model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId")
    int userId;
    @SerializedName("id")
    int id;

    public User(int userId, int id) {
        this.userId = userId;
        this.id = id;
    }

}
