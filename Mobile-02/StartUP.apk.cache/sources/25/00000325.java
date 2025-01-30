package androidx.lifecycle;

import androidx.lifecycle.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class p extends i {

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<o> f1792d;

    /* renamed from: b  reason: collision with root package name */
    private c.b.a.b.a<n, b> f1790b = new c.b.a.b.a<>();

    /* renamed from: e  reason: collision with root package name */
    private int f1793e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1794f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1795g = false;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<i.b> f1796h = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private i.b f1791c = i.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1797b;

        static {
            int[] iArr = new int[i.b.values().length];
            f1797b = iArr;
            try {
                iArr[i.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1797b[i.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1797b[i.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1797b[i.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1797b[i.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[i.a.values().length];
            a = iArr2;
            try {
                iArr2[i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[i.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[i.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[i.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class b {
        i.b a;

        /* renamed from: b  reason: collision with root package name */
        m f1798b;

        b(n nVar, i.b bVar) {
            this.f1798b = r.f(nVar);
            this.a = bVar;
        }

        void a(o oVar, i.a aVar) {
            i.b h2 = p.h(aVar);
            this.a = p.l(this.a, h2);
            this.f1798b.c(oVar, aVar);
            this.a = h2;
        }
    }

    public p(o oVar) {
        this.f1792d = new WeakReference<>(oVar);
    }

    private void d(o oVar) {
        Iterator<Map.Entry<n, b>> descendingIterator = this.f1790b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f1795g) {
            Map.Entry<n, b> next = descendingIterator.next();
            b value = next.getValue();
            while (value.a.compareTo(this.f1791c) > 0 && !this.f1795g && this.f1790b.contains(next.getKey())) {
                i.a f2 = f(value.a);
                o(h(f2));
                value.a(oVar, f2);
                n();
            }
        }
    }

    private i.b e(n nVar) {
        Map.Entry<n, b> q = this.f1790b.q(nVar);
        i.b bVar = null;
        i.b bVar2 = q != null ? q.getValue().a : null;
        if (!this.f1796h.isEmpty()) {
            ArrayList<i.b> arrayList = this.f1796h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return l(l(this.f1791c, bVar2), bVar);
    }

    private static i.a f(i.b bVar) {
        int i2 = a.f1797b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + bVar);
                        }
                        throw new IllegalArgumentException();
                    }
                    return i.a.ON_PAUSE;
                }
                return i.a.ON_STOP;
            }
            return i.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(o oVar) {
        c.b.a.b.b<n, b>.d k2 = this.f1790b.k();
        while (k2.hasNext() && !this.f1795g) {
            Map.Entry next = k2.next();
            b bVar = (b) next.getValue();
            while (bVar.a.compareTo(this.f1791c) < 0 && !this.f1795g && this.f1790b.contains(next.getKey())) {
                o(bVar.a);
                bVar.a(oVar, r(bVar.a));
                n();
            }
        }
    }

    static i.b h(i.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
            case 2:
                return i.b.CREATED;
            case 3:
            case 4:
                return i.b.STARTED;
            case 5:
                return i.b.RESUMED;
            case 6:
                return i.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.f1790b.size() == 0) {
            return true;
        }
        i.b bVar = this.f1790b.h().getValue().a;
        i.b bVar2 = this.f1790b.l().getValue().a;
        return bVar == bVar2 && this.f1791c == bVar2;
    }

    static i.b l(i.b bVar, i.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(i.b bVar) {
        if (this.f1791c == bVar) {
            return;
        }
        this.f1791c = bVar;
        if (!this.f1794f && this.f1793e == 0) {
            this.f1794f = true;
            q();
            this.f1794f = false;
            return;
        }
        this.f1795g = true;
    }

    private void n() {
        ArrayList<i.b> arrayList = this.f1796h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void o(i.b bVar) {
        this.f1796h.add(bVar);
    }

    private void q() {
        o oVar = this.f1792d.get();
        if (oVar != null) {
            while (!j()) {
                this.f1795g = false;
                if (this.f1791c.compareTo(this.f1790b.h().getValue().a) < 0) {
                    d(oVar);
                }
                Map.Entry<n, b> l2 = this.f1790b.l();
                if (!this.f1795g && l2 != null && this.f1791c.compareTo(l2.getValue().a) > 0) {
                    g(oVar);
                }
            }
            this.f1795g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    private static i.a r(i.b bVar) {
        int i2 = a.f1797b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return i.a.ON_START;
            }
            if (i2 == 3) {
                return i.a.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return i.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.i
    public void a(n nVar) {
        o oVar;
        i.b bVar = this.f1791c;
        i.b bVar2 = i.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = i.b.INITIALIZED;
        }
        b bVar3 = new b(nVar, bVar2);
        if (this.f1790b.o(nVar, bVar3) == null && (oVar = this.f1792d.get()) != null) {
            boolean z = this.f1793e != 0 || this.f1794f;
            i.b e2 = e(nVar);
            this.f1793e++;
            while (bVar3.a.compareTo(e2) < 0 && this.f1790b.contains(nVar)) {
                o(bVar3.a);
                bVar3.a(oVar, r(bVar3.a));
                n();
                e2 = e(nVar);
            }
            if (!z) {
                q();
            }
            this.f1793e--;
        }
    }

    @Override // androidx.lifecycle.i
    public i.b b() {
        return this.f1791c;
    }

    @Override // androidx.lifecycle.i
    public void c(n nVar) {
        this.f1790b.p(nVar);
    }

    public void i(i.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(i.b bVar) {
        p(bVar);
    }

    public void p(i.b bVar) {
        m(bVar);
    }
}