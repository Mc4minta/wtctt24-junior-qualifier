package e.a.a.w.k;

import android.graphics.Path;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class m implements b {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f11844b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11845c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.j.a f11846d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.w.j.d f11847e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11848f;

    public m(String str, boolean z, Path.FillType fillType, e.a.a.w.j.a aVar, e.a.a.w.j.d dVar, boolean z2) {
        this.f11845c = str;
        this.a = z;
        this.f11844b = fillType;
        this.f11846d = aVar;
        this.f11847e = dVar;
        this.f11848f = z2;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.g(gVar, aVar, this);
    }

    public e.a.a.w.j.a b() {
        return this.f11846d;
    }

    public Path.FillType c() {
        return this.f11844b;
    }

    public String d() {
        return this.f11845c;
    }

    public e.a.a.w.j.d e() {
        return this.f11847e;
    }

    public boolean f() {
        return this.f11848f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}