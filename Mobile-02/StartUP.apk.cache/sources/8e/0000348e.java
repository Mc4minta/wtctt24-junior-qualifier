package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class d2 {
    final String a;

    /* renamed from: b  reason: collision with root package name */
    final Uri f7088b;

    /* renamed from: c  reason: collision with root package name */
    final String f7089c;

    /* renamed from: d  reason: collision with root package name */
    final String f7090d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f7091e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f7092f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f7093g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f7094h;

    /* renamed from: i  reason: collision with root package name */
    final h2<Context, Boolean> f7095i;

    public d2(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final x1<Double> a(String str, double d2) {
        x1<Double> i2;
        i2 = x1.i(this, str, -3.0d);
        return i2;
    }

    public final x1<Long> b(String str, long j2) {
        x1<Long> j3;
        j3 = x1.j(this, str, j2);
        return j3;
    }

    public final x1<String> c(String str, String str2) {
        x1<String> k2;
        k2 = x1.k(this, str, str2);
        return k2;
    }

    public final x1<Boolean> d(String str, boolean z) {
        x1<Boolean> l2;
        l2 = x1.l(this, str, z);
        return l2;
    }

    private d2(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, h2<Context, Boolean> h2Var) {
        this.a = null;
        this.f7088b = uri;
        this.f7089c = str2;
        this.f7090d = str3;
        this.f7091e = false;
        this.f7092f = false;
        this.f7093g = false;
        this.f7094h = false;
        this.f7095i = null;
    }
}