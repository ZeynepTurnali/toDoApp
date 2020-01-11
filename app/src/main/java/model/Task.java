package model;

import com.google.gson.annotations.SerializedName;

public class Task {


    @SerializedName("title")
    public String title;
    @SerializedName("body")
    public String body;

    public Task(String title, String body) {
        this.title = title;
        this.body = body;
    }
    public Task(String body){
        this.body = body;
    }

}
