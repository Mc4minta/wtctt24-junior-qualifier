package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h  reason: invalid package */
/* loaded from: classes2.dex */
public final class h extends z<Boolean> {
    private static h a;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized h d() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
            hVar = a;
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "firebase_performance_collection_deactivated";
    }
}