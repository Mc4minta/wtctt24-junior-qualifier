package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.w  reason: invalid package */
/* loaded from: classes2.dex */
public final class w extends z<Long> {
    private static w a;

    private w() {
    }

    public static synchronized w d() {
        w wVar;
        synchronized (w.class) {
            if (a == null) {
                a = new w();
            }
            wVar = a;
        }
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "sessions_memory_capture_frequency_fg_ms";
    }
}