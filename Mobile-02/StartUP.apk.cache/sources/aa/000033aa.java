package com.google.android.gms.internal.p000firebaseperf;

import android.util.Log;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.l0  reason: invalid package */
/* loaded from: classes2.dex */
final class l0 {
    private static l0 a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6812b = "FirebasePerformance";

    private l0() {
    }

    public static synchronized l0 a() {
        l0 l0Var;
        synchronized (l0.class) {
            if (a == null) {
                a = new l0();
            }
            l0Var = a;
        }
        return l0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        Log.d(f6812b, str);
    }
}