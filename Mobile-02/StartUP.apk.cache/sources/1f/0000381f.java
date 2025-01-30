package com.google.api.client.http;

import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* compiled from: HttpRequestFactory.java */
/* loaded from: classes2.dex */
public final class p {
    private final u a;

    /* renamed from: b  reason: collision with root package name */
    private final q f8392b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(u uVar, q qVar) {
        this.a = uVar;
        this.f8392b = qVar;
    }

    public o a(g gVar) throws IOException {
        return d(HttpGet.METHOD_NAME, gVar, null);
    }

    public o b(g gVar, h hVar) throws IOException {
        return d(HttpPost.METHOD_NAME, gVar, hVar);
    }

    public o c(g gVar, h hVar) throws IOException {
        return d(HttpPut.METHOD_NAME, gVar, hVar);
    }

    public o d(String str, g gVar, h hVar) throws IOException {
        o a = this.a.a();
        q qVar = this.f8392b;
        if (qVar != null) {
            qVar.b(a);
        }
        a.w(str);
        if (gVar != null) {
            a.A(gVar);
        }
        if (hVar != null) {
            a.r(hVar);
        }
        return a;
    }

    public q e() {
        return this.f8392b;
    }

    public u f() {
        return this.a;
    }
}