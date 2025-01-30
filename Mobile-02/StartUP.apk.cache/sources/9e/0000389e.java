package com.google.common.base;

import java.io.Serializable;

/* compiled from: Equivalence.java */
/* loaded from: classes2.dex */
public abstract class d<T> {

    /* compiled from: Equivalence.java */
    /* loaded from: classes2.dex */
    static final class a extends d<Object> implements Serializable {
        static final a a = new a();

        a() {
        }

        @Override // com.google.common.base.d
        protected boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.d
        protected int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* compiled from: Equivalence.java */
    /* loaded from: classes2.dex */
    static final class b extends d<Object> implements Serializable {
        static final b a = new b();

        b() {
        }

        @Override // com.google.common.base.d
        protected boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.d
        protected int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected d() {
    }

    public static d<Object> c() {
        return a.a;
    }

    public static d<Object> f() {
        return b.a;
    }

    protected abstract boolean a(T t, T t2);

    protected abstract int b(T t);

    public final boolean d(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return a(t, t2);
    }

    public final int e(T t) {
        if (t == null) {
            return 0;
        }
        return b(t);
    }
}