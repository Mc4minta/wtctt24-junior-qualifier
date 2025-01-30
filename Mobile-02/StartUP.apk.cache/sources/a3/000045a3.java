package e.f.h.a.a.i.i;

import android.graphics.drawable.Animatable;
import e.f.h.a.a.i.g;
import e.f.h.a.a.i.h;
import e.f.j.i.e;

/* compiled from: ImagePerfControllerListener.java */
/* loaded from: classes2.dex */
public class a extends e.f.h.c.c<e> {

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.time.b f12179b;

    /* renamed from: c  reason: collision with root package name */
    private final h f12180c;

    /* renamed from: d  reason: collision with root package name */
    private final g f12181d;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.f12179b = bVar;
        this.f12180c = hVar;
        this.f12181d = gVar;
    }

    private void j(long j2) {
        this.f12180c.w(false);
        this.f12180c.p(j2);
        this.f12181d.d(this.f12180c, 2);
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    public void c(String str, Throwable th) {
        long now = this.f12179b.now();
        this.f12180c.e(now);
        this.f12180c.g(str);
        this.f12181d.e(this.f12180c, 5);
        j(now);
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    public void d(String str) {
        super.d(str);
        long now = this.f12179b.now();
        int a = this.f12180c.a();
        if (a != 3 && a != 5) {
            this.f12180c.d(now);
            this.f12180c.g(str);
            this.f12181d.e(this.f12180c, 4);
        }
        j(now);
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    public void e(String str, Object obj) {
        long now = this.f12179b.now();
        this.f12180c.i(now);
        this.f12180c.g(str);
        this.f12180c.c(obj);
        this.f12181d.e(this.f12180c, 0);
        k(now);
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    /* renamed from: h */
    public void b(String str, e eVar, Animatable animatable) {
        long now = this.f12179b.now();
        this.f12180c.f(now);
        this.f12180c.n(now);
        this.f12180c.g(str);
        this.f12180c.j(eVar);
        this.f12181d.e(this.f12180c, 3);
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    /* renamed from: i */
    public void a(String str, e eVar) {
        this.f12180c.h(this.f12179b.now());
        this.f12180c.g(str);
        this.f12180c.j(eVar);
        this.f12181d.e(this.f12180c, 2);
    }

    public void k(long j2) {
        this.f12180c.w(true);
        this.f12180c.v(j2);
        this.f12181d.d(this.f12180c, 1);
    }
}