package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class j implements Runnable {
    static final ThreadLocal<j> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static Comparator<c> f2178b = new a();

    /* renamed from: d  reason: collision with root package name */
    long f2180d;

    /* renamed from: e  reason: collision with root package name */
    long f2181e;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<RecyclerView> f2179c = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<c> f2182f = new ArrayList<>();

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f2188d;
            if ((recyclerView == null) != (cVar2.f2188d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i2 = cVar2.f2186b - cVar.f2186b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = cVar.f2187c - cVar2.f2187c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {
        int a;

        /* renamed from: b  reason: collision with root package name */
        int f2183b;

        /* renamed from: c  reason: collision with root package name */
        int[] f2184c;

        /* renamed from: d  reason: collision with root package name */
        int f2185d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 >= 0) {
                int i4 = this.f2185d * 2;
                int[] iArr = this.f2184c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f2184c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[i4 * 2];
                    this.f2184c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f2184c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f2185d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f2184c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2185d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.f2185d = 0;
            int[] iArr = this.f2184c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.z0()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.p()) {
                    oVar.z(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.y(this.a, this.f2183b, recyclerView.mState, this);
            }
            int i2 = this.f2185d;
            if (i2 > oVar.n) {
                oVar.n = i2;
                oVar.p = z;
                recyclerView.mRecycler.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (this.f2184c != null) {
                int i3 = this.f2185d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f2184c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i2, int i3) {
            this.a = i2;
            this.f2183b = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class c {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f2186b;

        /* renamed from: c  reason: collision with root package name */
        public int f2187c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f2188d;

        /* renamed from: e  reason: collision with root package name */
        public int f2189e;

        c() {
        }

        public void a() {
            this.a = false;
            this.f2186b = 0;
            this.f2187c = 0;
            this.f2188d = null;
            this.f2189e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f2179c.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f2179c.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f2185d;
            }
        }
        this.f2182f.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f2179c.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.a) + Math.abs(bVar.f2183b);
                for (int i6 = 0; i6 < bVar.f2185d * 2; i6 += 2) {
                    if (i4 >= this.f2182f.size()) {
                        cVar = new c();
                        this.f2182f.add(cVar);
                    } else {
                        cVar = this.f2182f.get(i4);
                    }
                    int[] iArr = bVar.f2184c;
                    int i7 = iArr[i6 + 1];
                    cVar.a = i7 <= abs;
                    cVar.f2186b = abs;
                    cVar.f2187c = i7;
                    cVar.f2188d = recyclerView2;
                    cVar.f2189e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f2182f, f2178b);
    }

    private void c(c cVar, long j2) {
        RecyclerView.e0 i2 = i(cVar.f2188d, cVar.f2189e, cVar.a ? Long.MAX_VALUE : j2);
        if (i2 == null || i2.mNestedRecyclerView == null || !i2.isBound() || i2.isInvalid()) {
            return;
        }
        h(i2.mNestedRecyclerView.get(), j2);
    }

    private void d(long j2) {
        for (int i2 = 0; i2 < this.f2182f.size(); i2++) {
            c cVar = this.f2182f.get(i2);
            if (cVar.f2188d == null) {
                return;
            }
            c(cVar, j2);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int j2 = recyclerView.mChildHelper.j();
        for (int i3 = 0; i3 < j2; i3++) {
            RecyclerView.e0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f2185d != 0) {
            try {
                androidx.core.os.f.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i2 = 0; i2 < bVar.f2185d * 2; i2 += 2) {
                    i(recyclerView, bVar.f2184c[i2], j2);
                }
            } finally {
                androidx.core.os.f.b();
            }
        }
    }

    private RecyclerView.e0 i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.e0 I = vVar.I(i2, false, j2);
            if (I != null) {
                if (I.isBound() && !I.isInvalid()) {
                    vVar.B(I.itemView);
                } else {
                    vVar.a(I, false);
                }
            }
            return I;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2179c.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f2180d == 0) {
            this.f2180d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i2, i3);
    }

    void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f2179c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.f.a("RV Prefetch");
            if (!this.f2179c.isEmpty()) {
                int size = this.f2179c.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f2179c.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j2) + this.f2181e);
                }
            }
        } finally {
            this.f2180d = 0L;
            androidx.core.os.f.b();
        }
    }
}