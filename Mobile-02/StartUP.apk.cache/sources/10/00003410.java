package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.u  reason: invalid package */
/* loaded from: classes2.dex */
public final class u extends z<Long> {
    private static u a;

    private u() {
    }

    public static synchronized u d() {
        u uVar;
        synchronized (u.class) {
            if (a == null) {
                a = new u();
            }
            uVar = a;
        }
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_session_max_duration_min";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String c() {
        return "sessions_max_length_minutes";
    }
}