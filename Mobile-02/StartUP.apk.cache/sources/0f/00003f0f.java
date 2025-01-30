package com.rumax.reactnative.pdfviewer;

/* compiled from: Errors.java */
/* loaded from: classes2.dex */
public enum b {
    E_NO_RESOURCE("source is not defined"),
    E_NO_RESOURCE_TYPE("resourceType is not defined"),
    E_INVALID_RESOURCE_TYPE("resourceType is Invalid"),
    E_INVALID_BASE64("data is not in valid Base64 scheme"),
    E_DELETE_FILE("Cannot delete downloaded file");
    

    /* renamed from: g  reason: collision with root package name */
    private final String f10843g;

    b(String str) {
        this.f10843g = str;
    }

    public String h() {
        return this.f10843g;
    }
}