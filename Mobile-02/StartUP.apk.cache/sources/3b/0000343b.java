package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.y  reason: invalid package */
/* loaded from: classes2.dex */
public final class y extends z<Long> {
    private static y a;

    private y() {
    }

    public static synchronized y d() {
        y yVar;
        synchronized (y.class) {
            if (a == null) {
                a = new y();
            }
            yVar = a;
        }
        return yVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_rl_trace_event_count_bg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }
}