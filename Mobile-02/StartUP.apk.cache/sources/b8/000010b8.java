package com.coinbase.resources.base;

/* loaded from: classes.dex */
public abstract class BaseResource {
    private String id;
    private String resource;
    private String resourcePath;

    public String getId() {
        return this.id;
    }

    public String getResource() {
        return this.resource;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
    }
}