package c.f.b.k.n;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DependencyNode.java */
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d  reason: collision with root package name */
    m f2851d;

    /* renamed from: f  reason: collision with root package name */
    int f2853f;

    /* renamed from: g  reason: collision with root package name */
    public int f2854g;
    public d a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2849b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2850c = false;

    /* renamed from: e  reason: collision with root package name */
    a f2852e = a.UNKNOWN;

    /* renamed from: h  reason: collision with root package name */
    int f2855h = 1;

    /* renamed from: i  reason: collision with root package name */
    g f2856i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2857j = false;

    /* renamed from: k  reason: collision with root package name */
    List<d> f2858k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List<f> f2859l = new ArrayList();

    /* compiled from: DependencyNode.java */
    /* loaded from: classes.dex */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(m mVar) {
        this.f2851d = mVar;
    }

    @Override // c.f.b.k.n.d
    public void a(d dVar) {
        for (f fVar : this.f2859l) {
            if (!fVar.f2857j) {
                return;
            }
        }
        this.f2850c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f2849b) {
            this.f2851d.a(this);
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f fVar3 : this.f2859l) {
            if (!(fVar3 instanceof g)) {
                i2++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.f2857j) {
            g gVar = this.f2856i;
            if (gVar != null) {
                if (!gVar.f2857j) {
                    return;
                }
                this.f2853f = this.f2855h * gVar.f2854g;
            }
            d(fVar2.f2854g + this.f2853f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f2858k.add(dVar);
        if (this.f2857j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f2859l.clear();
        this.f2858k.clear();
        this.f2857j = false;
        this.f2854g = 0;
        this.f2850c = false;
        this.f2849b = false;
    }

    public void d(int i2) {
        if (this.f2857j) {
            return;
        }
        this.f2857j = true;
        this.f2854g = i2;
        for (d dVar : this.f2858k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2851d.f2878b.s());
        sb.append(":");
        sb.append(this.f2852e);
        sb.append("(");
        sb.append(this.f2857j ? Integer.valueOf(this.f2854g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f2859l.size());
        sb.append(":d=");
        sb.append(this.f2858k.size());
        sb.append(">");
        return sb.toString();
    }
}