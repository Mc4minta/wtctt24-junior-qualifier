package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s  reason: invalid package */
/* loaded from: classes2.dex */
public final class s extends z<Long> {
    private static s a;

    private s() {
    }

    public static synchronized s d() {
        s sVar;
        synchronized (s.class) {
            if (a == null) {
                a = new s();
            }
            sVar = a;
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }
}