package com.google.api.client.http;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.message.TokenParser;

/* compiled from: HttpResponse.java */
/* loaded from: classes2.dex */
public final class r {
    private InputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8393b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8394c;

    /* renamed from: d  reason: collision with root package name */
    private final n f8395d;

    /* renamed from: e  reason: collision with root package name */
    y f8396e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8397f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8398g;

    /* renamed from: h  reason: collision with root package name */
    private final o f8399h;

    /* renamed from: i  reason: collision with root package name */
    private int f8400i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8401j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8402k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, y yVar) throws IOException {
        StringBuilder sb;
        this.f8399h = oVar;
        this.f8400i = oVar.c();
        this.f8401j = oVar.q();
        this.f8396e = yVar;
        this.f8393b = yVar.c();
        int i2 = yVar.i();
        boolean z = false;
        i2 = i2 < 0 ? 0 : i2;
        this.f8397f = i2;
        String h2 = yVar.h();
        this.f8398g = h2;
        Logger logger = u.a;
        if (this.f8401j && logger.isLoggable(Level.CONFIG)) {
            z = true;
        }
        if (z) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------");
            String str = e.g.b.a.d.c0.a;
            sb.append(str);
            String j2 = yVar.j();
            if (j2 != null) {
                sb.append(j2);
            } else {
                sb.append(i2);
                if (h2 != null) {
                    sb.append(TokenParser.SP);
                    sb.append(h2);
                }
            }
            sb.append(str);
        } else {
            sb = null;
        }
        oVar.j().e(yVar, z ? sb : null);
        String d2 = yVar.d();
        d2 = d2 == null ? oVar.j().getContentType() : d2;
        this.f8394c = d2;
        this.f8395d = d2 != null ? new n(d2) : null;
        if (z) {
            logger.config(sb.toString());
        }
    }

    private boolean j() throws IOException {
        int h2 = h();
        if (g().i().equals(HttpHead.METHOD_NAME) || h2 / 100 == 1 || h2 == 204 || h2 == 304) {
            k();
            return false;
        }
        return true;
    }

    public void a() throws IOException {
        k();
        this.f8396e.a();
    }

    public void b(OutputStream outputStream) throws IOException {
        e.g.b.a.d.o.b(c(), outputStream);
    }

    public InputStream c() throws IOException {
        if (!this.f8402k) {
            InputStream b2 = this.f8396e.b();
            if (b2 != null) {
                try {
                    String str = this.f8393b;
                    if (str != null && str.contains("gzip")) {
                        b2 = new GZIPInputStream(b2);
                    }
                    Logger logger = u.a;
                    if (this.f8401j) {
                        Level level = Level.CONFIG;
                        if (logger.isLoggable(level)) {
                            b2 = new e.g.b.a.d.s(b2, logger, level, this.f8400i);
                        }
                    }
                    this.a = b2;
                } catch (EOFException unused) {
                    b2.close();
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
            }
            this.f8402k = true;
        }
        return this.a;
    }

    public Charset d() {
        n nVar = this.f8395d;
        if (nVar != null && nVar.e() != null) {
            return this.f8395d.e();
        }
        return e.g.b.a.d.h.f13411b;
    }

    public String e() {
        return this.f8394c;
    }

    public l f() {
        return this.f8399h.j();
    }

    public o g() {
        return this.f8399h;
    }

    public int h() {
        return this.f8397f;
    }

    public String i() {
        return this.f8398g;
    }

    public void k() throws IOException {
        InputStream c2 = c();
        if (c2 != null) {
            c2.close();
        }
    }

    public boolean l() {
        return t.b(this.f8397f);
    }

    public <T> T m(Class<T> cls) throws IOException {
        if (j()) {
            return (T) this.f8399h.h().a(c(), d(), cls);
        }
        return null;
    }

    public String n() throws IOException {
        InputStream c2 = c();
        if (c2 == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e.g.b.a.d.o.b(c2, byteArrayOutputStream);
        return byteArrayOutputStream.toString(d().name());
    }
}