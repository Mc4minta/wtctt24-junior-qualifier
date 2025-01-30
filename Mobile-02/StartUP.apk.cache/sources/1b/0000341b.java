package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.v  reason: invalid package */
/* loaded from: classes2.dex */
public final class v extends z<Float> {
    private static v a;

    private v() {
    }

    public static synchronized v d() {
        v vVar;
        synchronized (v.class) {
            if (a == null) {
                a = new v();
            }
            vVar = a;
        }
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_vc_session_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "sessions_sampling_percentage";
    }
}