package c.f.b.k.n;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RunGroup.java */
/* loaded from: classes.dex */
public class k {
    public static int a;

    /* renamed from: d  reason: collision with root package name */
    m f2871d;

    /* renamed from: e  reason: collision with root package name */
    m f2872e;

    /* renamed from: g  reason: collision with root package name */
    int f2874g;

    /* renamed from: h  reason: collision with root package name */
    int f2875h;

    /* renamed from: b  reason: collision with root package name */
    public int f2869b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2870c = false;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<m> f2873f = new ArrayList<>();

    public k(m mVar, int i2) {
        this.f2871d = null;
        this.f2872e = null;
        this.f2874g = 0;
        int i3 = a;
        this.f2874g = i3;
        a = i3 + 1;
        this.f2871d = mVar;
        this.f2872e = mVar;
        this.f2875h = i2;
    }

    private long c(f fVar, long j2) {
        m mVar = fVar.f2851d;
        if (mVar instanceof i) {
            return j2;
        }
        int size = fVar.f2858k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f2858k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f2851d != mVar) {
                    j3 = Math.min(j3, c(fVar2, fVar2.f2853f + j2));
                }
            }
        }
        if (fVar == mVar.f2885i) {
            long j4 = j2 - mVar.j();
            return Math.min(Math.min(j3, c(mVar.f2884h, j4)), j4 - mVar.f2884h.f2853f);
        }
        return j3;
    }

    private long d(f fVar, long j2) {
        m mVar = fVar.f2851d;
        if (mVar instanceof i) {
            return j2;
        }
        int size = fVar.f2858k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f2858k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f2851d != mVar) {
                    j3 = Math.max(j3, d(fVar2, fVar2.f2853f + j2));
                }
            }
        }
        if (fVar == mVar.f2884h) {
            long j4 = j2 + mVar.j();
            return Math.max(Math.max(j3, d(mVar.f2885i, j4)), j4 - mVar.f2885i.f2853f);
        }
        return j3;
    }

    public void a(m mVar) {
        this.f2873f.add(mVar);
        this.f2872e = mVar;
    }

    public long b(c.f.b.k.f fVar, int i2) {
        long j2;
        int i3;
        m mVar = this.f2871d;
        if (mVar instanceof c) {
            if (((c) mVar).f2882f != i2) {
                return 0L;
            }
        } else if (i2 == 0) {
            if (!(mVar instanceof j)) {
                return 0L;
            }
        } else if (!(mVar instanceof l)) {
            return 0L;
        }
        f fVar2 = (i2 == 0 ? fVar.f2805f : fVar.f2806g).f2884h;
        f fVar3 = (i2 == 0 ? fVar.f2805f : fVar.f2806g).f2885i;
        boolean contains = mVar.f2884h.f2859l.contains(fVar2);
        boolean contains2 = this.f2871d.f2885i.f2859l.contains(fVar3);
        long j3 = this.f2871d.j();
        if (contains && contains2) {
            long d2 = d(this.f2871d.f2884h, 0L);
            long c2 = c(this.f2871d.f2885i, 0L);
            long j4 = d2 - j3;
            m mVar2 = this.f2871d;
            int i4 = mVar2.f2885i.f2853f;
            if (j4 >= (-i4)) {
                j4 += i4;
            }
            int i5 = mVar2.f2884h.f2853f;
            long j5 = ((-c2) - j3) - i5;
            if (j5 >= i5) {
                j5 -= i5;
            }
            float p = mVar2.f2878b.p(i2);
            float f2 = (float) (p > 0.0f ? (((float) j5) / p) + (((float) j4) / (1.0f - p)) : 0L);
            long j6 = (f2 * p) + 0.5f + j3 + (f2 * (1.0f - p)) + 0.5f;
            m mVar3 = this.f2871d;
            j2 = mVar3.f2884h.f2853f + j6;
            i3 = mVar3.f2885i.f2853f;
        } else if (contains) {
            f fVar4 = this.f2871d.f2884h;
            return Math.max(d(fVar4, fVar4.f2853f), this.f2871d.f2884h.f2853f + j3);
        } else if (contains2) {
            f fVar5 = this.f2871d.f2885i;
            return Math.max(-c(fVar5, fVar5.f2853f), (-this.f2871d.f2885i.f2853f) + j3);
        } else {
            m mVar4 = this.f2871d;
            j2 = mVar4.f2884h.f2853f + mVar4.j();
            i3 = this.f2871d.f2885i.f2853f;
        }
        return j2 - i3;
    }
}