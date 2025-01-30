package com.google.android.gms.internal.p000firebaseperf;

import com.google.firebase.perf.internal.b;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.j  reason: invalid package */
/* loaded from: classes2.dex */
public final class j extends z<String> {
    private static j a;

    /* renamed from: b  reason: collision with root package name */
    private static final j8<Long, String> f6765b = j8.a(461L, "FIREPERF_AUTOPUSH", 462L, "FIREPERF", 675L, "FIREPERF_INTERNAL_LOW", 676L, "FIREPERF_INTERNAL_HIGH");

    private j() {
    }

    public static synchronized j d() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String e() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String f(long j2) {
        return f6765b.get(Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(long j2) {
        return f6765b.containsKey(Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String a() {
        return "fpr_log_source";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.z
    public final String b() {
        return "com.google.firebase.perf.LogSourceName";
    }
}