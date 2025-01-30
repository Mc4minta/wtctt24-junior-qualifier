package com.bugsnag.android;

import com.coinbase.ApiConstants;

/* loaded from: classes.dex */
public enum BreadcrumbType {
    ERROR("error"),
    LOG("log"),
    MANUAL("manual"),
    NAVIGATION("navigation"),
    PROCESS("process"),
    REQUEST("request"),
    STATE(ApiConstants.STATE),
    USER(ApiConstants.USER);
    
    private final String type;

    BreadcrumbType(String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}