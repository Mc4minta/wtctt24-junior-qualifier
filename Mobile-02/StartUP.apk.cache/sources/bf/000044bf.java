package e.a.a.w.k;

import android.graphics.PointF;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class j implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a.a.w.j.m<PointF, PointF> f11834b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.f f11835c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.j.b f11836d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11837e;

    public j(String str, e.a.a.w.j.m<PointF, PointF> mVar, e.a.a.w.j.f fVar, e.a.a.w.j.b bVar, boolean z) {
        this.a = str;
        this.f11834b = mVar;
        this.f11835c = fVar;
        this.f11836d = bVar;
        this.f11837e = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.o(gVar, aVar, this);
    }

    public e.a.a.w.j.b b() {
        return this.f11836d;
    }

    public String c() {
        return this.a;
    }

    public e.a.a.w.j.m<PointF, PointF> d() {
        return this.f11834b;
    }

    public e.a.a.w.j.f e() {
        return this.f11835c;
    }

    public boolean f() {
        return this.f11837e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f11834b + ", size=" + this.f11835c + '}';
    }
}