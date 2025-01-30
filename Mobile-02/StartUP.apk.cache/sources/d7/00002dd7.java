package com.facebook.react.common;

/* loaded from: classes2.dex */
public class JavascriptException extends RuntimeException {
    private String extraDataAsJson;

    public JavascriptException(String str) {
        super(str);
    }

    public String getExtraDataAsJson() {
        return this.extraDataAsJson;
    }

    public JavascriptException setExtraDataAsJson(String str) {
        this.extraDataAsJson = str;
        return this;
    }
}