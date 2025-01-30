package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.d.q;

/* loaded from: classes2.dex */
public final class User extends b {
    @q
    private String displayName;
    @q
    private String emailAddress;
    @q
    private String kind;
    @q
    private Boolean me;
    @q
    private String permissionId;
    @q
    private String photoLink;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getKind() {
        return this.kind;
    }

    public Boolean getMe() {
        return this.me;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public User setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public User setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public User setKind(String str) {
        this.kind = str;
        return this;
    }

    public User setMe(Boolean bool) {
        this.me = bool;
        return this;
    }

    public User setPermissionId(String str) {
        this.permissionId = str;
        return this;
    }

    public User setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public User set(String str, Object obj) {
        return (User) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public User clone() {
        return (User) super.clone();
    }
}