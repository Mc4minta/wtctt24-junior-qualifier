package e.f.j.l;

import android.net.Uri;

/* compiled from: FetchState.java */
/* loaded from: classes2.dex */
public class s {
    private final k<e.f.j.i.d> a;

    /* renamed from: b  reason: collision with root package name */
    private final k0 f12731b;

    /* renamed from: c  reason: collision with root package name */
    private long f12732c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f12733d;

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.common.a f12734e;

    public s(k<e.f.j.i.d> kVar, k0 k0Var) {
        this.a = kVar;
        this.f12731b = k0Var;
    }

    public k<e.f.j.i.d> a() {
        return this.a;
    }

    public k0 b() {
        return this.f12731b;
    }

    public String c() {
        return this.f12731b.getId();
    }

    public long d() {
        return this.f12732c;
    }

    public m0 e() {
        return this.f12731b.f();
    }

    public int f() {
        return this.f12733d;
    }

    public com.facebook.imagepipeline.common.a g() {
        return this.f12734e;
    }

    public Uri h() {
        return this.f12731b.c().q();
    }

    public void i(long j2) {
        this.f12732c = j2;
    }

    public void j(int i2) {
        this.f12733d = i2;
    }

    public void k(com.facebook.imagepipeline.common.a aVar) {
        this.f12734e = aVar;
    }
}