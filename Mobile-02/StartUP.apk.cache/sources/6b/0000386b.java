package com.google.api.services.drive.model;

import e.g.b.a.c.b;
import e.g.b.a.c.h;
import e.g.b.a.d.q;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Channel extends b {
    @q
    private String address;
    @h
    @q
    private Long expiration;
    @q
    private String id;
    @q
    private String kind;
    @q
    private Map<String, String> params;
    @q
    private Boolean payload;
    @q
    private String resourceId;
    @q
    private String resourceUri;
    @q
    private String token;
    @q
    private String type;

    public String getAddress() {
        return this.address;
    }

    public Long getExpiration() {
        return this.expiration;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public Boolean getPayload() {
        return this.payload;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceUri() {
        return this.resourceUri;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public Channel setAddress(String str) {
        this.address = str;
        return this;
    }

    public Channel setExpiration(Long l2) {
        this.expiration = l2;
        return this;
    }

    public Channel setId(String str) {
        this.id = str;
        return this;
    }

    public Channel setKind(String str) {
        this.kind = str;
        return this;
    }

    public Channel setParams(Map<String, String> map) {
        this.params = map;
        return this;
    }

    public Channel setPayload(Boolean bool) {
        this.payload = bool;
        return this;
    }

    public Channel setResourceId(String str) {
        this.resourceId = str;
        return this;
    }

    public Channel setResourceUri(String str) {
        this.resourceUri = str;
        return this;
    }

    public Channel setToken(String str) {
        this.token = str;
        return this;
    }

    public Channel setType(String str) {
        this.type = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public Channel set(String str, Object obj) {
        return (Channel) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public Channel clone() {
        return (Channel) super.clone();
    }
}