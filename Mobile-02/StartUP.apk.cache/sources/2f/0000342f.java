package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.x  reason: invalid package */
/* loaded from: classes2.dex */
public final class x extends z<Long> {
    private static x a;

    private x() {
    }

    public static synchronized x d() {
        x xVar;
        synchronized (x.class) {
            if (a == null) {
                a = new x();
            }
            xVar = a;
        }
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_rl_trace_event_count_fg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }
}