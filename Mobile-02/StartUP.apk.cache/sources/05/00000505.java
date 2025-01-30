package c.f.b.k;

import c.f.b.i;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintAnchor.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public final e f2786b;

    /* renamed from: c  reason: collision with root package name */
    public final b f2787c;

    /* renamed from: d  reason: collision with root package name */
    public d f2788d;

    /* renamed from: g  reason: collision with root package name */
    c.f.b.i f2791g;
    private HashSet<d> a = null;

    /* renamed from: e  reason: collision with root package name */
    public int f2789e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f2790f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f2786b = eVar;
        this.f2787c = bVar;
    }

    public boolean a(d dVar, int i2) {
        return b(dVar, i2, -1, false);
    }

    public boolean b(d dVar, int i2, int i3, boolean z) {
        if (dVar == null) {
            l();
            return true;
        } else if (z || k(dVar)) {
            this.f2788d = dVar;
            if (dVar.a == null) {
                dVar.a = new HashSet<>();
            }
            this.f2788d.a.add(this);
            if (i2 > 0) {
                this.f2789e = i2;
            } else {
                this.f2789e = 0;
            }
            this.f2790f = i3;
            return true;
        } else {
            return false;
        }
    }

    public int c() {
        d dVar;
        if (this.f2786b.P() == 8) {
            return 0;
        }
        if (this.f2790f > -1 && (dVar = this.f2788d) != null && dVar.f2786b.P() == 8) {
            return this.f2790f;
        }
        return this.f2789e;
    }

    public final d d() {
        switch (a.a[this.f2787c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f2786b.G;
            case 3:
                return this.f2786b.E;
            case 4:
                return this.f2786b.H;
            case 5:
                return this.f2786b.F;
            default:
                throw new AssertionError(this.f2787c.name());
        }
    }

    public e e() {
        return this.f2786b;
    }

    public c.f.b.i f() {
        return this.f2791g;
    }

    public d g() {
        return this.f2788d;
    }

    public b h() {
        return this.f2787c;
    }

    public boolean i() {
        HashSet<d> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().d().j()) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        return this.f2788d != null;
    }

    public boolean k(d dVar) {
        boolean z = false;
        if (dVar == null) {
            return false;
        }
        b h2 = dVar.h();
        b bVar = this.f2787c;
        if (h2 == bVar) {
            return bVar != b.BASELINE || (dVar.e().T() && e().T());
        }
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return (h2 == b.BASELINE || h2 == b.CENTER_X || h2 == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z2 = h2 == b.LEFT || h2 == b.RIGHT;
                if (dVar.e() instanceof h) {
                    if (z2 || h2 == b.CENTER_X) {
                        z = true;
                    }
                    return z;
                }
                return z2;
            case 4:
            case 5:
                boolean z3 = h2 == b.TOP || h2 == b.BOTTOM;
                if (dVar.e() instanceof h) {
                    if (z3 || h2 == b.CENTER_Y) {
                        z = true;
                    }
                    return z;
                }
                return z3;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f2787c.name());
        }
    }

    public void l() {
        HashSet<d> hashSet;
        d dVar = this.f2788d;
        if (dVar != null && (hashSet = dVar.a) != null) {
            hashSet.remove(this);
        }
        this.f2788d = null;
        this.f2789e = 0;
        this.f2790f = -1;
    }

    public void m(c.f.b.c cVar) {
        c.f.b.i iVar = this.f2791g;
        if (iVar == null) {
            this.f2791g = new c.f.b.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public void n(int i2) {
        if (j()) {
            this.f2790f = i2;
        }
    }

    public String toString() {
        return this.f2786b.s() + ":" + this.f2787c.toString();
    }
}