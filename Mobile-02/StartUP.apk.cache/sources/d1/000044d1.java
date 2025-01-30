package e.a.a.w.l;

import e.a.a.w.j.j;
import e.a.a.w.j.k;
import e.a.a.w.j.l;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer.java */
/* loaded from: classes.dex */
public class d {
    private final List<e.a.a.w.k.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a.a.e f11889b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11890c;

    /* renamed from: d  reason: collision with root package name */
    private final long f11891d;

    /* renamed from: e  reason: collision with root package name */
    private final a f11892e;

    /* renamed from: f  reason: collision with root package name */
    private final long f11893f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11894g;

    /* renamed from: h  reason: collision with root package name */
    private final List<e.a.a.w.k.g> f11895h;

    /* renamed from: i  reason: collision with root package name */
    private final l f11896i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11897j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11898k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11899l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final e.a.a.w.j.b s;
    private final List<e.a.a.a0.a<Float>> t;
    private final b u;
    private final boolean v;

    /* compiled from: Layer.java */
    /* loaded from: classes.dex */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Layer.java */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public d(List<e.a.a.w.k.b> list, e.a.a.e eVar, String str, long j2, a aVar, long j3, String str2, List<e.a.a.w.k.g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, j jVar, k kVar, List<e.a.a.a0.a<Float>> list3, b bVar, e.a.a.w.j.b bVar2, boolean z) {
        this.a = list;
        this.f11889b = eVar;
        this.f11890c = str;
        this.f11891d = j2;
        this.f11892e = aVar;
        this.f11893f = j3;
        this.f11894g = str2;
        this.f11895h = list2;
        this.f11896i = lVar;
        this.f11897j = i2;
        this.f11898k = i3;
        this.f11899l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.a.a.e a() {
        return this.f11889b;
    }

    public long b() {
        return this.f11891d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<e.a.a.a0.a<Float>> c() {
        return this.t;
    }

    public a d() {
        return this.f11892e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<e.a.a.w.k.g> e() {
        return this.f11895h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f11890c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.f11893f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.f11894g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<e.a.a.w.k.b> l() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f11899l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f11898k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f11897j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.n / this.f11889b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j q() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.a.a.w.j.b s() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l u() {
        return this.f11896i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        d s = this.f11889b.s(h());
        if (s != null) {
            sb.append("\t\tParents: ");
            sb.append(s.g());
            d s2 = this.f11889b.s(s.h());
            while (s2 != null) {
                sb.append("->");
                sb.append(s2.g());
                s2 = this.f11889b.s(s2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (e.a.a.w.k.b bVar : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}