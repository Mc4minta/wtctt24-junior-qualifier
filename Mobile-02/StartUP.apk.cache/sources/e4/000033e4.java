package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.q  reason: invalid package */
/* loaded from: classes2.dex */
public final class q extends z<String> {
    private static q a;

    protected q() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized q d() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                a = new q();
            }
            qVar = a;
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_disabled_android_versions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }
}