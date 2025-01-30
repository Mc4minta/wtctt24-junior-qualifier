package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.r  reason: invalid package */
/* loaded from: classes2.dex */
public final class r extends z<Long> {
    private static r a;

    private r() {
    }

    public static synchronized r d() {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                a = new r();
            }
            rVar = a;
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }
}