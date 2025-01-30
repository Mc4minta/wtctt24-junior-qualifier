package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class g4 implements Runnable {
    private final h4 a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7598b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f7599c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f7600d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7601e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, List<String>> f7602f;

    private g4(String str, h4 h4Var, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        com.google.android.gms.common.internal.t.k(h4Var);
        this.a = h4Var;
        this.f7598b = i2;
        this.f7599c = th;
        this.f7600d = bArr;
        this.f7601e = str;
        this.f7602f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.f7601e, this.f7598b, this.f7599c, this.f7600d, this.f7602f);
    }
}