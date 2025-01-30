package e.a.a.w.k;

import android.graphics.PointF;

/* compiled from: PolystarShape.java */
/* loaded from: classes.dex */
public class i implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11822b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.b f11823c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.j.m<PointF, PointF> f11824d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.w.j.b f11825e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.w.j.b f11826f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.w.j.b f11827g;

    /* renamed from: h  reason: collision with root package name */
    private final e.a.a.w.j.b f11828h;

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.w.j.b f11829i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f11830j;

    /* compiled from: PolystarShape.java */
    /* loaded from: classes.dex */
    public enum a {
        STAR(1),
        POLYGON(2);
        

        /* renamed from: d  reason: collision with root package name */
        private final int f11833d;

        a(int i2) {
            this.f11833d = i2;
        }

        public static a h(int i2) {
            a[] values;
            for (a aVar : values()) {
                if (aVar.f11833d == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, e.a.a.w.j.b bVar, e.a.a.w.j.m<PointF, PointF> mVar, e.a.a.w.j.b bVar2, e.a.a.w.j.b bVar3, e.a.a.w.j.b bVar4, e.a.a.w.j.b bVar5, e.a.a.w.j.b bVar6, boolean z) {
        this.a = str;
        this.f11822b = aVar;
        this.f11823c = bVar;
        this.f11824d = mVar;
        this.f11825e = bVar2;
        this.f11826f = bVar3;
        this.f11827g = bVar4;
        this.f11828h = bVar5;
        this.f11829i = bVar6;
        this.f11830j = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.n(gVar, aVar, this);
    }

    public e.a.a.w.j.b b() {
        return this.f11826f;
    }

    public e.a.a.w.j.b c() {
        return this.f11828h;
    }

    public String d() {
        return this.a;
    }

    public e.a.a.w.j.b e() {
        return this.f11827g;
    }

    public e.a.a.w.j.b f() {
        return this.f11829i;
    }

    public e.a.a.w.j.b g() {
        return this.f11823c;
    }

    public e.a.a.w.j.m<PointF, PointF> h() {
        return this.f11824d;
    }

    public e.a.a.w.j.b i() {
        return this.f11825e;
    }

    public a j() {
        return this.f11822b;
    }

    public boolean k() {
        return this.f11830j;
    }
}