package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.o0  reason: invalid package */
/* loaded from: classes2.dex */
public enum o0 {
    TRACE_EVENT_RATE_LIMITED("_fstec"),
    NETWORK_TRACE_EVENT_RATE_LIMITED("_fsntc"),
    TRACE_STARTED_NOT_STOPPED("_tsns"),
    FRAMES_TOTAL("_fr_tot"),
    FRAMES_SLOW("_fr_slo"),
    FRAMES_FROZEN("_fr_fzn");
    

    /* renamed from: h  reason: collision with root package name */
    private String f6873h;

    o0(String str) {
        this.f6873h = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f6873h;
    }
}