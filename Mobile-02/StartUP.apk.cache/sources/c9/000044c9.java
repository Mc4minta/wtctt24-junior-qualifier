package e.a.a.w.k;

import e.a.a.u.b.s;

/* compiled from: ShapeTrimPath.java */
/* loaded from: classes.dex */
public class q implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11870b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.b f11871c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.j.b f11872d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.w.j.b f11873e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11874f;

    /* compiled from: ShapeTrimPath.java */
    /* loaded from: classes.dex */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a h(int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i2);
            }
            return SIMULTANEOUSLY;
        }
    }

    public q(String str, a aVar, e.a.a.w.j.b bVar, e.a.a.w.j.b bVar2, e.a.a.w.j.b bVar3, boolean z) {
        this.a = str;
        this.f11870b = aVar;
        this.f11871c = bVar;
        this.f11872d = bVar2;
        this.f11873e = bVar3;
        this.f11874f = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new s(aVar, this);
    }

    public e.a.a.w.j.b b() {
        return this.f11872d;
    }

    public String c() {
        return this.a;
    }

    public e.a.a.w.j.b d() {
        return this.f11873e;
    }

    public e.a.a.w.j.b e() {
        return this.f11871c;
    }

    public a f() {
        return this.f11870b;
    }

    public boolean g() {
        return this.f11874f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f11871c + ", end: " + this.f11872d + ", offset: " + this.f11873e + "}";
    }
}