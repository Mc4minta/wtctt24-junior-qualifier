package com.uber.autodispose;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoDisposeCompletable.java */
/* loaded from: classes2.dex */
public final class f extends h.c.c implements s {
    private final h.c.c a;

    /* renamed from: b  reason: collision with root package name */
    private final h.c.f f11430b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h.c.c cVar, h.c.f fVar) {
        this.a = cVar;
        this.f11430b = fVar;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.c(new n(this.f11430b, eVar));
    }
}