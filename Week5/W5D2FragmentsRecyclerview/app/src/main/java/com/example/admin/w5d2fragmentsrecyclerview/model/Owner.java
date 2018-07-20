package com.example.admin.w5d2fragmentsrecyclerview.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("avatar_url")
    private String avatarURL;

    public Owner(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
