package com.uber.autodispose;

import java.util.concurrent.Callable;

/* compiled from: Scopes.java */
/* loaded from: classes2.dex */
public final class z {
    public static h.c.c a(final y yVar) {
        return h.c.c.i(new Callable() { // from class: com.uber.autodispose.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z.b(y.this);
            }
        });
    }

    public static /* synthetic */ h.c.f b(y yVar) throws Exception {
        try {
            return yVar.requestScope();
        } catch (OutsideScopeException e2) {
            h.c.m0.f<? super OutsideScopeException> a = k.a();
            if (a != null) {
                a.accept(e2);
                return h.c.c.g();
            }
            return h.c.c.q(e2);
        }
    }
}