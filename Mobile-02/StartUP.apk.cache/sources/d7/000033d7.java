package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p  reason: invalid package */
/* loaded from: classes2.dex */
public final class p extends z<Boolean> {
    private static p a;

    protected p() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized p d() {
        p pVar;
        synchronized (p.class) {
            if (a == null) {
                a = new p();
            }
            pVar = a;
        }
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_enabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SdkEnabled";
    }
}