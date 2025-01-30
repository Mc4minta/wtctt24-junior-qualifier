package com.google.android.gms.internal.p000firebaseperf;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.j5  reason: invalid package */
/* loaded from: classes2.dex */
final class j5 extends h3<Long> implements t4<Long>, f6, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final j5 f6777b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f6778c;

    /* renamed from: d  reason: collision with root package name */
    private int f6779d;

    static {
        j5 j5Var = new j5(new long[0], 0);
        f6777b = j5Var;
        j5Var.Q0();
    }

    j5() {
        this(new long[10], 0);
    }

    private final void k(int i2) {
        if (i2 < 0 || i2 >= this.f6779d) {
            throw new IndexOutOfBoundsException(l(i2));
        }
    }

    private final String l(int i2) {
        int i3 = this.f6779d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t4
    public final /* synthetic */ t4<Long> J0(int i2) {
        if (i2 >= this.f6779d) {
            return new j5(Arrays.copyOf(this.f6778c, i2), this.f6779d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f6779d)) {
            long[] jArr = this.f6778c;
            if (i3 < jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
            } else {
                long[] jArr2 = new long[((i3 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i2);
                System.arraycopy(this.f6778c, i2, jArr2, i2 + 1, this.f6779d - i2);
                this.f6778c = jArr2;
            }
            this.f6778c[i2] = longValue;
            this.f6779d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(l(i2));
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        h();
        n4.a(collection);
        if (!(collection instanceof j5)) {
            return super.addAll(collection);
        }
        j5 j5Var = (j5) collection;
        int i2 = j5Var.f6779d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f6779d;
        if (RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f6778c;
            if (i4 > jArr.length) {
                this.f6778c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(j5Var.f6778c, 0, this.f6778c, this.f6779d, j5Var.f6779d);
            this.f6779d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j5)) {
            return super.equals(obj);
        }
        j5 j5Var = (j5) obj;
        if (this.f6779d != j5Var.f6779d) {
            return false;
        }
        long[] jArr = j5Var.f6778c;
        for (int i2 = 0; i2 < this.f6779d; i2++) {
            if (this.f6778c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(i(i2));
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f6779d; i3++) {
            i2 = (i2 * 31) + n4.e(this.f6778c[i3]);
        }
        return i2;
    }

    public final long i(int i2) {
        k(i2);
        return this.f6778c[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f6778c[i2] == longValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f6779d; i2++) {
            if (obj.equals(Long.valueOf(this.f6778c[i2]))) {
                long[] jArr = this.f6778c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f6779d - i2) - 1);
                this.f6779d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            long[] jArr = this.f6778c;
            System.arraycopy(jArr, i3, jArr, i2, this.f6779d - i3);
            this.f6779d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        h();
        k(i2);
        long[] jArr = this.f6778c;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6779d;
    }

    private j5(long[] jArr, int i2) {
        this.f6778c = jArr;
        this.f6779d = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        h();
        k(i2);
        long[] jArr = this.f6778c;
        long j2 = jArr[i2];
        if (i2 < this.f6779d - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f6779d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        long longValue = ((Long) obj).longValue();
        h();
        int i2 = this.f6779d;
        long[] jArr = this.f6778c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f6778c = jArr2;
        }
        long[] jArr3 = this.f6778c;
        int i3 = this.f6779d;
        this.f6779d = i3 + 1;
        jArr3[i3] = longValue;
        return true;
    }
}