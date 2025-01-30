package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.t  reason: invalid package */
/* loaded from: classes2.dex */
public final class t extends z<Long> {
    private static t a;

    private t() {
    }

    public static synchronized t d() {
        t tVar;
        synchronized (t.class) {
            if (a == null) {
                a = new t();
            }
            tVar = a;
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "sessions_memory_capture_frequency_bg_ms";
    }
}