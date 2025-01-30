package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class h {
    private static final Comparator<g> a = new a();

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<g> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            int i2 = gVar.a - gVar2.a;
            return i2 == 0 ? gVar.f2162b - gVar2.f2162b : i2;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract boolean a(int i2, int i3);

        public abstract boolean b(int i2, int i3);

        public abstract Object c(int i2, int i3);

        public abstract int d();

        public abstract int e();
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class c {
        private final List<g> a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f2151b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f2152c;

        /* renamed from: d  reason: collision with root package name */
        private final b f2153d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2154e;

        /* renamed from: f  reason: collision with root package name */
        private final int f2155f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f2156g;

        c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.f2151b = iArr;
            this.f2152c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f2153d = bVar;
            this.f2154e = bVar.e();
            this.f2155f = bVar.d();
            this.f2156g = z;
            a();
            g();
        }

        private void a() {
            g gVar = this.a.isEmpty() ? null : this.a.get(0);
            if (gVar != null && gVar.a == 0 && gVar.f2162b == 0) {
                return;
            }
            g gVar2 = new g();
            gVar2.a = 0;
            gVar2.f2162b = 0;
            gVar2.f2164d = false;
            gVar2.f2163c = 0;
            gVar2.f2165e = false;
            this.a.add(0, gVar2);
        }

        private void b(List<e> list, n nVar, int i2, int i3, int i4) {
            if (!this.f2156g) {
                nVar.b(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f2152c;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    nVar.b(i2, 1);
                    for (e eVar : list) {
                        eVar.f2157b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    nVar.a(i(list, i8, true).f2157b, i2);
                    if (i7 == 4) {
                        nVar.d(i2, 1, this.f2153d.c(i8, i6));
                    }
                } else if (i7 == 16) {
                    list.add(new e(i6, i2, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        private void c(List<e> list, n nVar, int i2, int i3, int i4) {
            if (!this.f2156g) {
                nVar.c(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f2151b;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    nVar.c(i2 + i5, 1);
                    for (e eVar : list) {
                        eVar.f2157b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    e i9 = i(list, i8, false);
                    nVar.a(i2 + i5, i9.f2157b - 1);
                    if (i7 == 4) {
                        nVar.d(i9.f2157b - 1, 1, this.f2153d.c(i6, i8));
                    }
                } else if (i7 == 16) {
                    list.add(new e(i6, i2 + i5, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        private void e(int i2, int i3, int i4) {
            if (this.f2151b[i2 - 1] != 0) {
                return;
            }
            f(i2, i3, i4, false);
        }

        private boolean f(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                g gVar = this.a.get(i4);
                int i8 = gVar.a;
                int i9 = gVar.f2163c;
                int i10 = i8 + i9;
                int i11 = gVar.f2162b + i9;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.f2153d.b(i12, i5)) {
                            i7 = this.f2153d.a(i12, i5) ? 8 : 4;
                            this.f2152c[i5] = (i12 << 5) | 16;
                            this.f2151b[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.f2153d.b(i5, i13)) {
                            i7 = this.f2153d.a(i5, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.f2151b[i14] = (i13 << 5) | 16;
                            this.f2152c[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                    continue;
                }
                i6 = gVar.a;
                i3 = gVar.f2162b;
                i4--;
            }
            return false;
        }

        private void g() {
            int i2 = this.f2154e;
            int i3 = this.f2155f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g gVar = this.a.get(size);
                int i4 = gVar.a;
                int i5 = gVar.f2163c;
                int i6 = i4 + i5;
                int i7 = gVar.f2162b + i5;
                if (this.f2156g) {
                    while (i2 > i6) {
                        e(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        h(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < gVar.f2163c; i8++) {
                    int i9 = gVar.a + i8;
                    int i10 = gVar.f2162b + i8;
                    int i11 = this.f2153d.a(i9, i10) ? 1 : 2;
                    this.f2151b[i9] = (i10 << 5) | i11;
                    this.f2152c[i10] = (i9 << 5) | i11;
                }
                i2 = gVar.a;
                i3 = gVar.f2162b;
            }
        }

        private void h(int i2, int i3, int i4) {
            if (this.f2152c[i3 - 1] != 0) {
                return;
            }
            f(i2, i3, i4, true);
        }

        private static e i(List<e> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.a == i2 && eVar.f2158c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2157b += z ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public void d(n nVar) {
            androidx.recyclerview.widget.e eVar;
            if (nVar instanceof androidx.recyclerview.widget.e) {
                eVar = (androidx.recyclerview.widget.e) nVar;
            } else {
                eVar = new androidx.recyclerview.widget.e(nVar);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.f2154e;
            int i3 = this.f2155f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g gVar = this.a.get(size);
                int i4 = gVar.f2163c;
                int i5 = gVar.a + i4;
                int i6 = gVar.f2162b + i4;
                if (i5 < i2) {
                    c(arrayList, eVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    b(arrayList, eVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.f2151b;
                    int i8 = gVar.a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        eVar.d(i8 + i7, 1, this.f2153d.c(i8 + i7, gVar.f2162b + i7));
                    }
                }
                i2 = gVar.a;
                i3 = gVar.f2162b;
            }
            eVar.e();
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class d<T> {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class e {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2157b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2158c;

        public e(int i2, int i3, boolean z) {
            this.a = i2;
            this.f2157b = i3;
            this.f2158c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class f {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2159b;

        /* renamed from: c  reason: collision with root package name */
        int f2160c;

        /* renamed from: d  reason: collision with root package name */
        int f2161d;

        public f() {
        }

        public f(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.f2159b = i3;
            this.f2160c = i4;
            this.f2161d = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class g {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2162b;

        /* renamed from: c  reason: collision with root package name */
        int f2163c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2164d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2165e;

        g() {
        }
    }

    public static c a(b bVar) {
        return b(bVar, true);
    }

    public static c b(b bVar, boolean z) {
        int e2 = bVar.e();
        int d2 = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new f(0, e2, 0, d2));
        int abs = e2 + d2 + Math.abs(e2 - d2);
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            f fVar = (f) arrayList2.remove(arrayList2.size() - 1);
            g c2 = c(bVar, fVar.a, fVar.f2159b, fVar.f2160c, fVar.f2161d, iArr, iArr2, abs);
            if (c2 != null) {
                if (c2.f2163c > 0) {
                    arrayList.add(c2);
                }
                c2.a += fVar.a;
                c2.f2162b += fVar.f2160c;
                f fVar2 = arrayList3.isEmpty() ? new f() : (f) arrayList3.remove(arrayList3.size() - 1);
                fVar2.a = fVar.a;
                fVar2.f2160c = fVar.f2160c;
                if (c2.f2165e) {
                    fVar2.f2159b = c2.a;
                    fVar2.f2161d = c2.f2162b;
                } else if (c2.f2164d) {
                    fVar2.f2159b = c2.a - 1;
                    fVar2.f2161d = c2.f2162b;
                } else {
                    fVar2.f2159b = c2.a;
                    fVar2.f2161d = c2.f2162b - 1;
                }
                arrayList2.add(fVar2);
                if (c2.f2165e) {
                    if (c2.f2164d) {
                        int i3 = c2.a;
                        int i4 = c2.f2163c;
                        fVar.a = i3 + i4 + 1;
                        fVar.f2160c = c2.f2162b + i4;
                    } else {
                        int i5 = c2.a;
                        int i6 = c2.f2163c;
                        fVar.a = i5 + i6;
                        fVar.f2160c = c2.f2162b + i6 + 1;
                    }
                } else {
                    int i7 = c2.a;
                    int i8 = c2.f2163c;
                    fVar.a = i7 + i8;
                    fVar.f2160c = c2.f2162b + i8;
                }
                arrayList2.add(fVar);
            } else {
                arrayList3.add(fVar);
            }
        }
        Collections.sort(arrayList, a);
        return new c(bVar, arrayList, iArr, iArr2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r24[r13 - 1] < r24[r13 + r5]) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
        if (r25[r12 - 1] < r25[r12 + 1]) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1 A[LOOP:4: B:52:0x00cd->B:56:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ec A[EDGE_INSN: B:89:0x00ec->B:58:0x00ec ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.recyclerview.widget.h.g c(androidx.recyclerview.widget.h.b r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h.c(androidx.recyclerview.widget.h$b, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.h$g");
    }
}