package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Set;

/* compiled from: ImmutableSet.java */
/* loaded from: classes2.dex */
public abstract class r<E> extends j<E> implements Set<E> {
    @LazyInit
    private transient l<E> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmutableSet.java */
    /* loaded from: classes2.dex */
    public static abstract class a<E> extends r<E> {

        /* compiled from: ImmutableSet.java */
        /* renamed from: com.google.common.collect.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0159a extends h<E> {
            C0159a() {
            }

            @Override // java.util.List
            public E get(int i2) {
                return (E) a.this.get(i2);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.h
            /* renamed from: u */
            public a<E> t() {
                return a.this;
            }
        }

        abstract E get(int i2);

        @Override // com.google.common.collect.r
        l<E> m() {
            return new C0159a();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: p */
        public l0<E> iterator() {
            return i().iterator();
        }
    }

    static int k(int i2) {
        if (i2 < 751619276) {
            int highestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            while (highestOneBit * 0.7d < i2) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        com.google.common.base.l.e(i2 < 1073741824, "collection too large");
        return 1073741824;
    }

    private static <E> r<E> l(int i2, Object... objArr) {
        if (i2 != 0) {
            if (i2 != 1) {
                int k2 = k(i2);
                Object[] objArr2 = new Object[k2];
                int i3 = k2 - 1;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    Object b2 = y.b(objArr[i6], i6);
                    int hashCode = b2.hashCode();
                    int b3 = g.b(hashCode);
                    while (true) {
                        int i7 = b3 & i3;
                        Object obj = objArr2[i7];
                        if (obj == null) {
                            objArr[i4] = b2;
                            objArr2[i7] = b2;
                            i5 += hashCode;
                            i4++;
                            break;
                        } else if (obj.equals(b2)) {
                            break;
                        } else {
                            b3++;
                        }
                    }
                }
                Arrays.fill(objArr, i4, i2, (Object) null);
                if (i4 == 1) {
                    return new j0(objArr[0], i5);
                }
                if (k2 != k(i4)) {
                    return l(i4, objArr);
                }
                if (i4 < objArr.length) {
                    objArr = y.a(objArr, i4);
                }
                return new f0(objArr, i5, objArr2, i3);
            }
            return r(objArr[0]);
        }
        return q();
    }

    public static <E> r<E> q() {
        return f0.f8474b;
    }

    public static <E> r<E> r(E e2) {
        return new j0(e2);
    }

    public static <E> r<E> s(E e2, E e3, E e4) {
        return l(3, e2, e3, e4);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof r) && o() && ((r) obj).o() && hashCode() != obj.hashCode()) {
            return false;
        }
        return g0.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return g0.b(this);
    }

    public l<E> i() {
        l<E> lVar = this.a;
        if (lVar == null) {
            l<E> m = m();
            this.a = m;
            return m;
        }
        return lVar;
    }

    l<E> m() {
        return new b0(this, toArray());
    }

    boolean o() {
        return false;
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: p */
    public abstract l0<E> iterator();
}