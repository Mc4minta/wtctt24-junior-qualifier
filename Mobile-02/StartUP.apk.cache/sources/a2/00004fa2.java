package h.c.n0.e.g;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* compiled from: SingleInternalHelper.java */
/* loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleInternalHelper.java */
    /* loaded from: classes3.dex */
    public enum a implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* renamed from: h */
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleInternalHelper.java */
    /* loaded from: classes3.dex */
    public enum b implements h.c.m0.n<h.c.h0, k.a.b> {
        INSTANCE;

        @Override // h.c.m0.n
        /* renamed from: h */
        public k.a.b apply(h.c.h0 h0Var) {
            return new u0(h0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleInternalHelper.java */
    /* loaded from: classes3.dex */
    public enum c implements h.c.m0.n<h.c.h0, h.c.s> {
        INSTANCE;

        @Override // h.c.m0.n
        /* renamed from: h */
        public h.c.s apply(h.c.h0 h0Var) {
            return new v0(h0Var);
        }
    }

    public static <T> Callable<NoSuchElementException> a() {
        return a.INSTANCE;
    }

    public static <T> h.c.m0.n<h.c.h0<? extends T>, k.a.b<? extends T>> b() {
        return b.INSTANCE;
    }

    public static <T> h.c.m0.n<h.c.h0<? extends T>, h.c.s<? extends T>> c() {
        return c.INSTANCE;
    }
}