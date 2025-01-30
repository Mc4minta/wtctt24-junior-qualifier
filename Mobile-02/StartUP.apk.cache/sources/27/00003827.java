package com.google.api.client.http;

import java.io.IOException;

/* compiled from: LowLevelHttpRequest.java */
/* loaded from: classes2.dex */
public abstract class x {
    private long a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f8407b;

    /* renamed from: c  reason: collision with root package name */
    private String f8408c;

    /* renamed from: d  reason: collision with root package name */
    private e.g.b.a.d.b0 f8409d;

    public abstract void a(String str, String str2) throws IOException;

    public abstract y b() throws IOException;

    public final String c() {
        return this.f8407b;
    }

    public final long d() {
        return this.a;
    }

    public final String e() {
        return this.f8408c;
    }

    public final e.g.b.a.d.b0 f() {
        return this.f8409d;
    }

    public final void g(String str) throws IOException {
        this.f8407b = str;
    }

    public final void h(long j2) throws IOException {
        this.a = j2;
    }

    public final void i(String str) throws IOException {
        this.f8408c = str;
    }

    public final void j(e.g.b.a.d.b0 b0Var) throws IOException {
        this.f8409d = b0Var;
    }

    public void k(int i2, int i3) throws IOException {
    }
}