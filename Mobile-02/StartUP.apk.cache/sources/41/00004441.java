package e.a.a;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<e.a.a.w.l.d>> f11517c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, h> f11518d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, e.a.a.w.c> f11519e;

    /* renamed from: f  reason: collision with root package name */
    private List<e.a.a.w.h> f11520f;

    /* renamed from: g  reason: collision with root package name */
    private c.e.h<e.a.a.w.d> f11521g;

    /* renamed from: h  reason: collision with root package name */
    private c.e.d<e.a.a.w.l.d> f11522h;

    /* renamed from: i  reason: collision with root package name */
    private List<e.a.a.w.l.d> f11523i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f11524j;

    /* renamed from: k  reason: collision with root package name */
    private float f11525k;

    /* renamed from: l  reason: collision with root package name */
    private float f11526l;
    private float m;
    private boolean n;
    private final o a = new o();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f11516b = new HashSet<>();
    private int o = 0;

    public void a(String str) {
        e.a.a.z.d.c(str);
        this.f11516b.add(str);
    }

    public Rect b() {
        return this.f11524j;
    }

    public c.e.h<e.a.a.w.d> c() {
        return this.f11521g;
    }

    public float d() {
        return (e() / this.m) * 1000.0f;
    }

    public float e() {
        return this.f11526l - this.f11525k;
    }

    public float f() {
        return this.f11526l;
    }

    public Map<String, e.a.a.w.c> g() {
        return this.f11519e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, h> i() {
        return this.f11518d;
    }

    public List<e.a.a.w.l.d> j() {
        return this.f11523i;
    }

    public e.a.a.w.h k(String str) {
        this.f11520f.size();
        for (int i2 = 0; i2 < this.f11520f.size(); i2++) {
            e.a.a.w.h hVar = this.f11520f.get(i2);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public int l() {
        return this.o;
    }

    public o m() {
        return this.a;
    }

    public List<e.a.a.w.l.d> n(String str) {
        return this.f11517c.get(str);
    }

    public float o() {
        return this.f11525k;
    }

    public boolean p() {
        return this.n;
    }

    public void q(int i2) {
        this.o += i2;
    }

    public void r(Rect rect, float f2, float f3, float f4, List<e.a.a.w.l.d> list, c.e.d<e.a.a.w.l.d> dVar, Map<String, List<e.a.a.w.l.d>> map, Map<String, h> map2, c.e.h<e.a.a.w.d> hVar, Map<String, e.a.a.w.c> map3, List<e.a.a.w.h> list2) {
        this.f11524j = rect;
        this.f11525k = f2;
        this.f11526l = f3;
        this.m = f4;
        this.f11523i = list;
        this.f11522h = dVar;
        this.f11517c = map;
        this.f11518d = map2;
        this.f11521g = hVar;
        this.f11519e = map3;
        this.f11520f = list2;
    }

    public e.a.a.w.l.d s(long j2) {
        return this.f11522h.h(j2);
    }

    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (e.a.a.w.l.d dVar : this.f11523i) {
            sb.append(dVar.w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}