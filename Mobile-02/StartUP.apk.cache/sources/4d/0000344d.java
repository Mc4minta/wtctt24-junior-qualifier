package com.google.android.gms.internal.p000firebaseperf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.z3  reason: invalid package */
/* loaded from: classes2.dex */
public class z3 {
    private static volatile z3 a;

    /* renamed from: b  reason: collision with root package name */
    private static final z3 f7001b = new z3(true);

    /* renamed from: c  reason: collision with root package name */
    private final Map<Object, Object> f7002c;

    z3() {
        this.f7002c = new HashMap();
    }

    public static z3 a() {
        z3 z3Var = a;
        if (z3Var == null) {
            synchronized (z3.class) {
                z3Var = a;
                if (z3Var == null) {
                    z3Var = f7001b;
                    a = z3Var;
                }
            }
        }
        return z3Var;
    }

    private z3(boolean z) {
        this.f7002c = Collections.emptyMap();
    }
}