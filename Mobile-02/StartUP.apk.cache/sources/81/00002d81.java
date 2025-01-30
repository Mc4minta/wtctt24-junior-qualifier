package com.facebook.react.bridge;

/* loaded from: classes2.dex */
public class JavaScriptContextHolder {
    private long mContext;

    public JavaScriptContextHolder(long j2) {
        this.mContext = j2;
    }

    public synchronized void clear() {
        this.mContext = 0L;
    }

    public long get() {
        return this.mContext;
    }
}