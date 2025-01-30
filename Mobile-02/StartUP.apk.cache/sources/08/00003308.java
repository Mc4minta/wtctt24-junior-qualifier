package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class w1 extends t<Long> implements j1<Long>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final w1 f6602b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f6603c;

    /* renamed from: d  reason: collision with root package name */
    private int f6604d;

    static {
        w1 w1Var = new w1();
        f6602b = w1Var;
        w1Var.j();
    }

    w1() {
        this(new long[10], 0);
    }

    private w1(long[] jArr, int i2) {
        this.f6603c = jArr;
        this.f6604d = i2;
    }

    private final void k(int i2) {
        if (i2 < 0 || i2 >= this.f6604d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    private final String l(int i2) {
        int i3 = this.f6604d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    private final void m(int i2, long j2) {
        int i3;
        h();
        if (i2 < 0 || i2 > (i3 = this.f6604d)) {
            throw new IndexOutOfBoundsException(l(i2));
        }
        long[] jArr = this.f6603c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f6603c, i2, jArr2, i2 + 1, this.f6604d - i2);
            this.f6603c = jArr2;
        }
        this.f6603c[i2] = j2;
        this.f6604d++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        m(i2, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        h();
        g1.a(collection);
        if (collection instanceof w1) {
            w1 w1Var = (w1) collection;
            int i2 = w1Var.f6604d;
            if (i2 == 0) {
                return false;
            }
            int i3 = this.f6604d;
            if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
                int i4 = i3 + i2;
                long[] jArr = this.f6603c;
                if (i4 > jArr.length) {
                    this.f6603c = Arrays.copyOf(jArr, i4);
                }
                System.arraycopy(w1Var.f6603c, 0, this.f6603c, this.f6604d, w1Var.f6604d);
                this.f6604d = i4;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w1) {
            w1 w1Var = (w1) obj;
            if (this.f6604d != w1Var.f6604d) {
                return false;
            }
            long[] jArr = w1Var.f6603c;
            for (int i2 = 0; i2 < this.f6604d; i2++) {
                if (this.f6603c[i2] != jArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(i(i2));
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f6604d; i3++) {
            i2 = (i2 * 31) + g1.j(this.f6603c[i3]);
        }
        return i2;
    }

    public final long i(int i2) {
        k(i2);
        return this.f6603c[i2];
    }

    public final void o(long j2) {
        m(this.f6604d, j2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        k(i2);
        long[] jArr = this.f6603c;
        long j2 = jArr[i2];
        int i3 = this.f6604d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, i3 - i2);
        }
        this.f6604d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f6604d; i2++) {
            if (obj.equals(Long.valueOf(this.f6603c[i2]))) {
                long[] jArr = this.f6603c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, this.f6604d - i2);
                this.f6604d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        h();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f6603c;
        System.arraycopy(jArr, i3, jArr, i2, this.f6604d - i3);
        this.f6604d -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        h();
        k(i2);
        long[] jArr = this.f6603c;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6604d;
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1<Long> x0(int i2) {
        if (i2 >= this.f6604d) {
            return new w1(Arrays.copyOf(this.f6603c, i2), this.f6604d);
        }
        throw new IllegalArgumentException();
    }
}