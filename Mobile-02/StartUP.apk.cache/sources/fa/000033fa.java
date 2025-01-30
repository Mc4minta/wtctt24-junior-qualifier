package com.google.android.gms.internal.p000firebaseperf;

import okhttp3.internal.ws.RealWebSocket;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s0  reason: invalid package */
/* loaded from: classes2.dex */
public class s0 {
    private static final s0 a;

    /* renamed from: b  reason: collision with root package name */
    private static final s0 f6899b;

    /* renamed from: c  reason: collision with root package name */
    public static final s0 f6900c;

    /* renamed from: d  reason: collision with root package name */
    private static final s0 f6901d;

    /* renamed from: e  reason: collision with root package name */
    public static final s0 f6902e;

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ s0[] f6903f;

    /* renamed from: g  reason: collision with root package name */
    private long f6904g;

    static {
        r0 r0Var = new r0("TERABYTES", 0, 1099511627776L);
        a = r0Var;
        s0 s0Var = new s0("GIGABYTES", 1, 1073741824L) { // from class: com.google.android.gms.internal.firebase-perf.u0
        };
        f6899b = s0Var;
        s0 s0Var2 = new s0("MEGABYTES", 2, 1048576L) { // from class: com.google.android.gms.internal.firebase-perf.t0
        };
        f6900c = s0Var2;
        s0 s0Var3 = new s0("KILOBYTES", 3, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) { // from class: com.google.android.gms.internal.firebase-perf.w0
        };
        f6901d = s0Var3;
        s0 s0Var4 = new s0("BYTES", 4, 1L) { // from class: com.google.android.gms.internal.firebase-perf.v0
        };
        f6902e = s0Var4;
        f6903f = new s0[]{r0Var, s0Var, s0Var2, s0Var3, s0Var4};
    }

    private s0(String str, int i2, long j2) {
        this.f6904g = j2;
    }

    public static s0[] values() {
        return (s0[]) f6903f.clone();
    }

    public final long h(long j2) {
        return (j2 * this.f6904g) / f6901d.f6904g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s0(String str, int i2, long j2, r0 r0Var) {
        this(str, i2, j2);
    }
}