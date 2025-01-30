package e.a.a.w.k;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class o implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11851b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.h f11852c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11853d;

    public o(String str, int i2, e.a.a.w.j.h hVar, boolean z) {
        this.a = str;
        this.f11851b = i2;
        this.f11852c = hVar;
        this.f11853d = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.q(gVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public e.a.a.w.j.h c() {
        return this.f11852c;
    }

    public boolean d() {
        return this.f11853d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.f11851b + '}';
    }
}