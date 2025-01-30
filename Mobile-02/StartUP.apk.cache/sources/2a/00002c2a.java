package com.facebook.common.references;

import e.f.d.c.i;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: CloseableReference.java */
/* loaded from: classes2.dex */
public final class a<T> implements Cloneable, Closeable {
    private static Class<a> a = a.class;

    /* renamed from: b  reason: collision with root package name */
    private static final com.facebook.common.references.c<Closeable> f4496b = new C0106a();

    /* renamed from: c  reason: collision with root package name */
    private static final c f4497c = new b();

    /* renamed from: d  reason: collision with root package name */
    private boolean f4498d = false;

    /* renamed from: e  reason: collision with root package name */
    private final SharedReference<T> f4499e;

    /* renamed from: f  reason: collision with root package name */
    private final c f4500f;

    /* renamed from: g  reason: collision with root package name */
    private final Throwable f4501g;

    /* compiled from: CloseableReference.java */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0106a implements com.facebook.common.references.c<Closeable> {
        C0106a() {
        }

        @Override // com.facebook.common.references.c
        /* renamed from: a */
        public void release(Closeable closeable) {
            try {
                e.f.d.c.b.a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: CloseableReference.java */
    /* loaded from: classes2.dex */
    static class b implements c {
        b() {
        }

        @Override // com.facebook.common.references.a.c
        public void a(SharedReference<Object> sharedReference, Throwable th) {
            e.f.d.d.a.y(a.a, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.f().getClass().getName());
        }

        @Override // com.facebook.common.references.a.c
        public boolean b() {
            return false;
        }
    }

    /* compiled from: CloseableReference.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(SharedReference<Object> sharedReference, Throwable th);

        boolean b();
    }

    private a(SharedReference<T> sharedReference, c cVar, Throwable th) {
        this.f4499e = (SharedReference) i.g(sharedReference);
        sharedReference.b();
        this.f4500f = cVar;
        this.f4501g = th;
    }

    public static boolean G(a<?> aVar) {
        return aVar != null && aVar.A();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a K(Closeable closeable) {
        return e0(closeable, f4496b);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;Lcom/facebook/common/references/a$c;)Lcom/facebook/common/references/a<TT;>; */
    public static a N(Closeable closeable, c cVar) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, f4496b, cVar, cVar.b() ? new Throwable() : null);
    }

    public static <T> a<T> e(a<T> aVar) {
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public static <T> a<T> e0(T t, com.facebook.common.references.c<T> cVar) {
        return n0(t, cVar, f4497c);
    }

    public static void f(a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    public static <T> a<T> n0(T t, com.facebook.common.references.c<T> cVar, c cVar2) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar, cVar2, cVar2.b() ? new Throwable() : null);
    }

    public synchronized boolean A() {
        return !this.f4498d;
    }

    /* renamed from: c */
    public synchronized a<T> clone() {
        i.i(A());
        return new a<>(this.f4499e, this.f4500f, this.f4501g);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.f4498d) {
                return;
            }
            this.f4498d = true;
            this.f4499e.d();
        }
    }

    public synchronized a<T> d() {
        if (A()) {
            return clone();
        }
        return null;
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.f4498d) {
                    return;
                }
                this.f4500f.a(this.f4499e, this.f4501g);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public synchronized T n() {
        i.i(!this.f4498d);
        return this.f4499e.f();
    }

    public int v() {
        if (A()) {
            return System.identityHashCode(this.f4499e.f());
        }
        return 0;
    }

    private a(T t, com.facebook.common.references.c<T> cVar, c cVar2, Throwable th) {
        this.f4499e = new SharedReference<>(t, cVar);
        this.f4500f = cVar2;
        this.f4501g = th;
    }
}