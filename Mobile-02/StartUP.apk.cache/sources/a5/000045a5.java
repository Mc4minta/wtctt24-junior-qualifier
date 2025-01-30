package e.f.h.a.a.i.i;

import e.f.h.a.a.i.h;

/* compiled from: ImagePerfRequestListener.java */
/* loaded from: classes2.dex */
public class c extends e.f.j.j.a {
    private final com.facebook.common.time.b a;

    /* renamed from: b  reason: collision with root package name */
    private final h f12183b;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.a = bVar;
        this.f12183b = hVar;
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void a(com.facebook.imagepipeline.request.b bVar, Object obj, String str, boolean z) {
        this.f12183b.o(this.a.now());
        this.f12183b.m(bVar);
        this.f12183b.c(obj);
        this.f12183b.t(str);
        this.f12183b.s(z);
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void c(com.facebook.imagepipeline.request.b bVar, String str, boolean z) {
        this.f12183b.n(this.a.now());
        this.f12183b.m(bVar);
        this.f12183b.t(str);
        this.f12183b.s(z);
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void g(com.facebook.imagepipeline.request.b bVar, String str, Throwable th, boolean z) {
        this.f12183b.n(this.a.now());
        this.f12183b.m(bVar);
        this.f12183b.t(str);
        this.f12183b.s(z);
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void k(String str) {
        this.f12183b.n(this.a.now());
        this.f12183b.t(str);
    }
}