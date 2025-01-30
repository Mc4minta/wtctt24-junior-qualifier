package h.c.n0.j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ArrayListSupplier.java */
/* loaded from: classes3.dex */
public enum b implements Callable<List<Object>>, h.c.m0.n<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> n() {
        return INSTANCE;
    }

    public static <T, O> h.c.m0.n<O, List<T>> q() {
        return INSTANCE;
    }

    @Override // h.c.m0.n
    /* renamed from: h */
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: s */
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}