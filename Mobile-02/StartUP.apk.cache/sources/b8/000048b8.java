package e.g.b.a.c.j;

import e.g.b.a.c.d;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: GsonGenerator.java */
/* loaded from: classes2.dex */
class b extends d {
    private final com.google.gson.stream.c a;

    /* renamed from: b  reason: collision with root package name */
    private final a f13394b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.google.gson.stream.c cVar) {
        this.f13394b = aVar;
        this.a = cVar;
        cVar.d0(true);
    }

    @Override // e.g.b.a.c.d
    public void a() throws IOException {
        this.a.a0("  ");
    }

    @Override // e.g.b.a.c.d
    public void b() throws IOException {
        this.a.flush();
    }

    @Override // e.g.b.a.c.d
    public void e(boolean z) throws IOException {
        this.a.w0(z);
    }

    @Override // e.g.b.a.c.d
    public void f() throws IOException {
        this.a.f();
    }

    @Override // e.g.b.a.c.d
    public void g() throws IOException {
        this.a.g();
    }

    @Override // e.g.b.a.c.d
    public void h(String str) throws IOException {
        this.a.v(str);
    }

    @Override // e.g.b.a.c.d
    public void i() throws IOException {
        this.a.A();
    }

    @Override // e.g.b.a.c.d
    public void j(double d2) throws IOException {
        this.a.k0(d2);
    }

    @Override // e.g.b.a.c.d
    public void k(float f2) throws IOException {
        this.a.k0(f2);
    }

    @Override // e.g.b.a.c.d
    public void l(int i2) throws IOException {
        this.a.n0(i2);
    }

    @Override // e.g.b.a.c.d
    public void m(long j2) throws IOException {
        this.a.n0(j2);
    }

    @Override // e.g.b.a.c.d
    public void n(BigDecimal bigDecimal) throws IOException {
        this.a.r0(bigDecimal);
    }

    @Override // e.g.b.a.c.d
    public void o(BigInteger bigInteger) throws IOException {
        this.a.r0(bigInteger);
    }

    @Override // e.g.b.a.c.d
    public void p() throws IOException {
        this.a.c();
    }

    @Override // e.g.b.a.c.d
    public void q() throws IOException {
        this.a.d();
    }

    @Override // e.g.b.a.c.d
    public void r(String str) throws IOException {
        this.a.s0(str);
    }
}