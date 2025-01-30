package com.uber.autodispose;

import h.c.b0;
import h.c.e0;
import h.c.h0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoDisposeSingle.java */
/* loaded from: classes2.dex */
public final class l<T> extends b0<T> implements a0<T> {
    private final h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final h.c.f f11435b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h0<T> h0Var, h.c.f fVar) {
        this.a = h0Var;
        this.f11435b = fVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(e0<? super T> e0Var) {
        this.a.subscribe(new p(this.f11435b, e0Var));
    }
}