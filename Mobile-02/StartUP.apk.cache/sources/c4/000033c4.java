package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.n0  reason: invalid package */
/* loaded from: classes2.dex */
public enum n0 {
    APP_START_TRACE_NAME("_as"),
    ON_CREATE_TRACE_NAME("_astui"),
    ON_START_TRACE_NAME("_astfd"),
    ON_RESUME_TRACE_NAME("_asti"),
    FOREGROUND_TRACE_NAME("_fs"),
    BACKGROUND_TRACE_NAME("_bs");
    

    /* renamed from: h  reason: collision with root package name */
    private String f6843h;

    n0(String str) {
        this.f6843h = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f6843h;
    }
}