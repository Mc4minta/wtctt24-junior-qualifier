package com.coinbase.resources.users;

import com.coinbase.resources.base.DynamicResource;

/* loaded from: classes.dex */
public class User extends DynamicResource {
    private String avatarUrl;
    private String name;
    private String profileBio;
    private String profileLocation;
    private String profileUrl;
    private String username;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getProfileBio() {
        return this.profileBio;
    }

    public String getProfileLocation() {
        return this.profileLocation;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public String getUsername() {
        return this.username;
    }
}