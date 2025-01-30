package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.a0  reason: invalid package */
/* loaded from: classes2.dex */
public final class a0 extends z<Float> {
    private static a0 a;

    private a0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized a0 d() {
        a0 a0Var;
        synchronized (a0.class) {
            if (a == null) {
                a = new a0();
            }
            a0Var = a;
        }
        return a0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_vc_trace_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }
}