package com.google.android.gms.internal.clearcut;

import android.net.Uri;

/* loaded from: classes2.dex */
public final class p {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f6525b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6526c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6527d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6528e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6529f;

    public p(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private p(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.a = str;
        this.f6525b = uri;
        this.f6526c = str2;
        this.f6527d = str3;
        this.f6528e = z;
        this.f6529f = z2;
    }

    public final <T> f<T> a(String str, T t, o<T> oVar) {
        return f.i(this, str, t, oVar);
    }

    public final f<String> b(String str, String str2) {
        return f.j(this, str, null);
    }

    public final f<Boolean> e(String str, boolean z) {
        return f.k(this, str, false);
    }

    public final p f(String str) {
        boolean z = this.f6528e;
        if (z) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new p(this.a, this.f6525b, str, this.f6527d, z, this.f6529f);
    }

    public final p h(String str) {
        return new p(this.a, this.f6525b, this.f6526c, str, this.f6528e, this.f6529f);
    }
}