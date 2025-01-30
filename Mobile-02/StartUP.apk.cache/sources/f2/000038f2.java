package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
public final class s {
    static final m0<Object> a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final Iterator<Object> f8500b = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    /* loaded from: classes2.dex */
    public static class a<T> extends com.google.common.collect.a<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object[] f8501c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8502d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, int i3, Object[] objArr, int i4) {
            super(i2, i3);
            this.f8501c = objArr;
            this.f8502d = i4;
        }

        @Override // com.google.common.collect.a
        protected T b(int i2) {
            return (T) this.f8501c[this.f8502d + i2];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    /* loaded from: classes2.dex */
    static class b<T> extends l0<T> {
        boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f8503b;

        b(Object obj) {
            this.f8503b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.a) {
                this.a = true;
                return (T) this.f8503b;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes2.dex */
    static class c extends m0<Object> {
        c() {
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes2.dex */
    static class d implements Iterator<Object> {
        d() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.d.c(false);
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.l.i(collection);
        com.google.common.base.l.i(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> boolean b(Iterator<T> it, com.google.common.base.m<? super T> mVar) {
        return h(it, mVar) != -1;
    }

    public static boolean c(Iterator<?> it, Object obj) {
        return b(it, com.google.common.base.n.a(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L0:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.i.a(r0, r2)
            if (r0 != 0) goto L0
            return r1
        L1d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.s.d(java.util.Iterator, java.util.Iterator):boolean");
    }

    static <T> m0<T> e() {
        return (m0<T>) a;
    }

    @SafeVarargs
    public static <T> l0<T> f(T... tArr) {
        return g(tArr, 0, tArr.length, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> m0<T> g(T[] tArr, int i2, int i3, int i4) {
        com.google.common.base.l.d(i3 >= 0);
        com.google.common.base.l.n(i2, i2 + i3, tArr.length);
        com.google.common.base.l.l(i4, i3);
        if (i3 == 0) {
            return e();
        }
        return new a(i3, i4, tArr, i2);
    }

    public static <T> int h(Iterator<T> it, com.google.common.base.m<? super T> mVar) {
        com.google.common.base.l.j(mVar, "predicate");
        int i2 = 0;
        while (it.hasNext()) {
            if (mVar.apply(it.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> l0<T> i(T t) {
        return new b(t);
    }
}