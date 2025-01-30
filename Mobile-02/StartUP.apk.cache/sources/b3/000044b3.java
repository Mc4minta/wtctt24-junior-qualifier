package e.a.a.w.k;

import android.graphics.PointF;

/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class a implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a.a.w.j.m<PointF, PointF> f11781b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.f f11782c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11783d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11784e;

    public a(String str, e.a.a.w.j.m<PointF, PointF> mVar, e.a.a.w.j.f fVar, boolean z, boolean z2) {
        this.a = str;
        this.f11781b = mVar;
        this.f11782c = fVar;
        this.f11783d = z;
        this.f11784e = z2;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.f(gVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public e.a.a.w.j.m<PointF, PointF> c() {
        return this.f11781b;
    }

    public e.a.a.w.j.f d() {
        return this.f11782c;
    }

    public boolean e() {
        return this.f11784e;
    }

    public boolean f() {
        return this.f11783d;
    }
}