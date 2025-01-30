package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k6  reason: invalid package */
/* loaded from: classes2.dex */
final class k6<E> extends h3<E> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final k6<Object> f6794b;

    /* renamed from: c  reason: collision with root package name */
    private E[] f6795c;

    /* renamed from: d  reason: collision with root package name */
    private int f6796d;

    static {
        k6<Object> k6Var = new k6<>(new Object[0], 0);
        f6794b = k6Var;
        k6Var.Q0();
    }

    private k6(E[] eArr, int i2) {
        this.f6795c = eArr;
        this.f6796d = i2;
    }

    private final void i(int i2) {
        if (i2 < 0 || i2 >= this.f6796d) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    private final String k(int i2) {
        int i3 = this.f6796d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public static <E> k6<E> l() {
        return (k6<E>) f6794b;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t4
    public final /* synthetic */ t4 J0(int i2) {
        if (i2 >= this.f6796d) {
            return new k6(Arrays.copyOf(this.f6795c, i2), this.f6796d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        h();
        int i2 = this.f6796d;
        E[] eArr = this.f6795c;
        if (i2 == eArr.length) {
            this.f6795c = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f6795c;
        int i3 = this.f6796d;
        this.f6796d = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        i(i2);
        return this.f6795c[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        int i3;
        h();
        i(i2);
        E[] eArr = this.f6795c;
        E e2 = eArr[i2];
        if (i2 < this.f6796d - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f6796d--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        h();
        i(i2);
        E[] eArr = this.f6795c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6796d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        int i3;
        h();
        if (i2 >= 0 && i2 <= (i3 = this.f6796d)) {
            E[] eArr = this.f6795c;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i2);
                System.arraycopy(this.f6795c, i2, eArr2, i2 + 1, this.f6796d - i2);
                this.f6795c = eArr2;
            }
            this.f6795c[i2] = e2;
            this.f6796d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(k(i2));
    }
}