package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class i6<E> extends b3<E> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final i6<Object> f7184b;

    /* renamed from: c  reason: collision with root package name */
    private E[] f7185c;

    /* renamed from: d  reason: collision with root package name */
    private int f7186d;

    static {
        i6<Object> i6Var = new i6<>(new Object[0], 0);
        f7184b = i6Var;
        i6Var.b();
    }

    private i6(E[] eArr, int i2) {
        this.f7185c = eArr;
        this.f7186d = i2;
    }

    private final void i(int i2) {
        if (i2 < 0 || i2 >= this.f7186d) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    private final String k(int i2) {
        int i3 = this.f7186d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public static <E> i6<E> l() {
        return (i6<E>) f7184b;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        h();
        int i2 = this.f7186d;
        E[] eArr = this.f7185c;
        if (i2 == eArr.length) {
            this.f7185c = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f7185c;
        int i3 = this.f7186d;
        this.f7186d = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.v4
    public final /* synthetic */ v4 f(int i2) {
        if (i2 >= this.f7186d) {
            return new i6(Arrays.copyOf(this.f7185c, i2), this.f7186d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        i(i2);
        return this.f7185c[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        int i3;
        h();
        i(i2);
        E[] eArr = this.f7185c;
        E e2 = eArr[i2];
        if (i2 < this.f7186d - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f7186d--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        h();
        i(i2);
        E[] eArr = this.f7185c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7186d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        int i3;
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f7186d)) {
            E[] eArr = this.f7185c;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i2);
                System.arraycopy(this.f7185c, i2, eArr2, i2 + 1, this.f7186d - i2);
                this.f7185c = eArr2;
            }
            this.f7185c[i2] = e2;
            this.f7186d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(k(i2));
    }
}