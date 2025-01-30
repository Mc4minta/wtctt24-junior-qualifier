package com.google.api.client.http.f0;

import e.g.b.a.c.c;
import e.g.b.a.c.d;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: JsonHttpContent.java */
/* loaded from: classes2.dex */
public class a extends com.google.api.client.http.a {

    /* renamed from: c  reason: collision with root package name */
    private final Object f8359c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8360d;

    /* renamed from: e  reason: collision with root package name */
    private String f8361e;

    public a(c cVar, Object obj) {
        super("application/json; charset=UTF-8");
        this.f8360d = (c) y.d(cVar);
        this.f8359c = y.d(obj);
    }

    public a f(String str) {
        this.f8361e = str;
        return this;
    }

    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        d a = this.f8360d.a(outputStream, d());
        if (this.f8361e != null) {
            a.q();
            a.h(this.f8361e);
        }
        a.c(this.f8359c);
        if (this.f8361e != null) {
            a.g();
        }
        a.b();
    }
}