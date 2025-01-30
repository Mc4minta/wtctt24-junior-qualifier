package androidx.recyclerview.widget;

import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public class a implements o.a {
    private androidx.core.util.f<b> a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f2082b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f2083c;

    /* renamed from: d  reason: collision with root package name */
    final InterfaceC0038a f2084d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f2085e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f2086f;

    /* renamed from: g  reason: collision with root package name */
    final o f2087g;

    /* renamed from: h  reason: collision with root package name */
    private int f2088h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0038a {
        void a(int i2, int i3);

        void b(b bVar);

        void c(int i2, int i3, Object obj);

        void d(b bVar);

        RecyclerView.e0 e(int i2);

        void f(int i2, int i3);

        void g(int i2, int i3);

        void h(int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2089b;

        /* renamed from: c  reason: collision with root package name */
        Object f2090c;

        /* renamed from: d  reason: collision with root package name */
        int f2091d;

        b(int i2, int i3, int i4, Object obj) {
            this.a = i2;
            this.f2089b = i3;
            this.f2091d = i4;
            this.f2090c = obj;
        }

        String a() {
            int i2 = this.a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.a;
            if (i2 != bVar.a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f2091d - this.f2089b) == 1 && this.f2091d == bVar.f2089b && this.f2089b == bVar.f2091d) {
                return true;
            }
            if (this.f2091d == bVar.f2091d && this.f2089b == bVar.f2089b) {
                Object obj2 = this.f2090c;
                if (obj2 != null) {
                    if (!obj2.equals(bVar.f2090c)) {
                        return false;
                    }
                } else if (bVar.f2090c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.f2089b) * 31) + this.f2091d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2089b + "c:" + this.f2091d + ",p:" + this.f2090c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0038a interfaceC0038a) {
        this(interfaceC0038a, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z;
        char c2;
        int i2 = bVar.f2089b;
        int i3 = bVar.f2091d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f2084d.e(i4) != null || h(i4)) {
                if (c3 == 0) {
                    k(b(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    v(b(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != bVar.f2091d) {
            a(bVar);
            bVar = b(2, i2, i5, null);
        }
        if (c3 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i2 = bVar.f2089b;
        int i3 = bVar.f2091d + i2;
        int i4 = 0;
        boolean z = true;
        int i5 = i2;
        while (i2 < i3) {
            if (this.f2084d.e(i2) != null || h(i2)) {
                if (!z) {
                    k(b(4, i5, i4, bVar.f2090c));
                    i5 = i2;
                    i4 = 0;
                }
                z = true;
            } else {
                if (z) {
                    v(b(4, i5, i4, bVar.f2090c));
                    i5 = i2;
                    i4 = 0;
                }
                z = false;
            }
            i4++;
            i2++;
        }
        if (i4 != bVar.f2091d) {
            Object obj = bVar.f2090c;
            a(bVar);
            bVar = b(4, i5, i4, obj);
        }
        if (!z) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private boolean h(int i2) {
        int size = this.f2083c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f2083c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                if (n(bVar.f2091d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f2089b;
                int i6 = bVar.f2091d + i5;
                while (i5 < i6) {
                    if (n(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i2;
        int i3 = bVar.a;
        if (i3 != 1 && i3 != 8) {
            int z = z(bVar.f2089b, i3);
            int i4 = bVar.f2089b;
            int i5 = bVar.a;
            if (i5 == 2) {
                i2 = 0;
            } else if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            } else {
                i2 = 1;
            }
            int i6 = 1;
            for (int i7 = 1; i7 < bVar.f2091d; i7++) {
                int z2 = z(bVar.f2089b + (i2 * i7), bVar.a);
                int i8 = bVar.a;
                if (i8 == 2 ? z2 == z : i8 == 4 && z2 == z + 1) {
                    i6++;
                } else {
                    b b2 = b(i8, z, i6, bVar.f2090c);
                    l(b2, i4);
                    a(b2);
                    if (bVar.a == 4) {
                        i4 += i6;
                    }
                    i6 = 1;
                    z = z2;
                }
            }
            Object obj = bVar.f2090c;
            a(bVar);
            if (i6 > 0) {
                b b3 = b(bVar.a, z, i6, obj);
                l(b3, i4);
                a(b3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void v(b bVar) {
        this.f2083c.add(bVar);
        int i2 = bVar.a;
        if (i2 == 1) {
            this.f2084d.g(bVar.f2089b, bVar.f2091d);
        } else if (i2 == 2) {
            this.f2084d.f(bVar.f2089b, bVar.f2091d);
        } else if (i2 == 4) {
            this.f2084d.c(bVar.f2089b, bVar.f2091d, bVar.f2090c);
        } else if (i2 == 8) {
            this.f2084d.a(bVar.f2089b, bVar.f2091d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f2083c.size() - 1; size >= 0; size--) {
            b bVar = this.f2083c.get(size);
            int i6 = bVar.a;
            if (i6 == 8) {
                int i7 = bVar.f2089b;
                int i8 = bVar.f2091d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            bVar.f2089b = i7 + 1;
                            bVar.f2091d = i8 + 1;
                        } else if (i3 == 2) {
                            bVar.f2089b = i7 - 1;
                            bVar.f2091d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        bVar.f2091d = i8 + 1;
                    } else if (i3 == 2) {
                        bVar.f2091d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.f2089b = i7 + 1;
                    } else if (i3 == 2) {
                        bVar.f2089b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = bVar.f2089b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= bVar.f2091d;
                    } else if (i6 == 2) {
                        i2 += bVar.f2091d;
                    }
                } else if (i3 == 1) {
                    bVar.f2089b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.f2089b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f2083c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f2083c.get(size2);
            if (bVar2.a == 8) {
                int i10 = bVar2.f2091d;
                if (i10 == bVar2.f2089b || i10 < 0) {
                    this.f2083c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f2091d <= 0) {
                this.f2083c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.o.a
    public void a(b bVar) {
        if (this.f2086f) {
            return;
        }
        bVar.f2090c = null;
        this.a.release(bVar);
    }

    @Override // androidx.recyclerview.widget.o.a
    public b b(int i2, int i3, int i4, Object obj) {
        b acquire = this.a.acquire();
        if (acquire == null) {
            return new b(i2, i3, i4, obj);
        }
        acquire.a = i2;
        acquire.f2089b = i3;
        acquire.f2091d = i4;
        acquire.f2090c = obj;
        return acquire;
    }

    public int e(int i2) {
        int size = this.f2082b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f2082b.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f2089b;
                    if (i5 <= i2) {
                        int i6 = bVar.f2091d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f2089b;
                    if (i7 == i2) {
                        i2 = bVar.f2091d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f2091d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f2089b <= i2) {
                i2 += bVar.f2091d;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f2083c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2084d.d(this.f2083c.get(i2));
        }
        x(this.f2083c);
        this.f2088h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f2082b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2082b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                this.f2084d.d(bVar);
                this.f2084d.g(bVar.f2089b, bVar.f2091d);
            } else if (i3 == 2) {
                this.f2084d.d(bVar);
                this.f2084d.h(bVar.f2089b, bVar.f2091d);
            } else if (i3 == 4) {
                this.f2084d.d(bVar);
                this.f2084d.c(bVar.f2089b, bVar.f2091d, bVar.f2090c);
            } else if (i3 == 8) {
                this.f2084d.d(bVar);
                this.f2084d.a(bVar.f2089b, bVar.f2091d);
            }
            Runnable runnable = this.f2085e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f2082b);
        this.f2088h = 0;
    }

    void l(b bVar, int i2) {
        this.f2084d.b(bVar);
        int i3 = bVar.a;
        if (i3 == 2) {
            this.f2084d.h(i2, bVar.f2091d);
        } else if (i3 == 4) {
            this.f2084d.c(i2, bVar.f2091d, bVar.f2090c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i2) {
        return n(i2, 0);
    }

    int n(int i2, int i3) {
        int size = this.f2083c.size();
        while (i3 < size) {
            b bVar = this.f2083c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                int i5 = bVar.f2089b;
                if (i5 == i2) {
                    i2 = bVar.f2091d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f2091d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f2089b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f2091d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f2091d;
                }
            }
            i3++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i2) {
        return (i2 & this.f2088h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f2082b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f2083c.isEmpty() || this.f2082b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f2082b.add(b(4, i2, i3, obj));
        this.f2088h |= 4;
        return this.f2082b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f2082b.add(b(1, i2, i3, null));
        this.f2088h |= 1;
        return this.f2082b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f2082b.add(b(8, i2, i3, null));
            this.f2088h |= 8;
            return this.f2082b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f2082b.add(b(2, i2, i3, null));
        this.f2088h |= 2;
        return this.f2082b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f2087g.b(this.f2082b);
        int size = this.f2082b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2082b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                c(bVar);
            } else if (i3 == 2) {
                f(bVar);
            } else if (i3 == 4) {
                g(bVar);
            } else if (i3 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f2085e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2082b.clear();
    }

    void x(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        x(this.f2082b);
        x(this.f2083c);
        this.f2088h = 0;
    }

    a(InterfaceC0038a interfaceC0038a, boolean z) {
        this.a = new Pools$SimplePool(30);
        this.f2082b = new ArrayList<>();
        this.f2083c = new ArrayList<>();
        this.f2088h = 0;
        this.f2084d = interfaceC0038a;
        this.f2086f = z;
        this.f2087g = new o(this);
    }
}