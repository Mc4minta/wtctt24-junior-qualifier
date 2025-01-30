package e.a.a.w.k;

/* compiled from: Repeater.java */
/* loaded from: classes.dex */
public class k implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a.a.w.j.b f11838b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.b f11839c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.j.l f11840d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11841e;

    public k(String str, e.a.a.w.j.b bVar, e.a.a.w.j.b bVar2, e.a.a.w.j.l lVar, boolean z) {
        this.a = str;
        this.f11838b = bVar;
        this.f11839c = bVar2;
        this.f11840d = lVar;
        this.f11841e = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.p(gVar, aVar, this);
    }

    public e.a.a.w.j.b b() {
        return this.f11838b;
    }

    public String c() {
        return this.a;
    }

    public e.a.a.w.j.b d() {
        return this.f11839c;
    }

    public e.a.a.w.j.l e() {
        return this.f11840d;
    }

    public boolean f() {
        return this.f11841e;
    }
}