package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements a.InterfaceC0134a {
    private final m a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.g f5849b;

    /* renamed from: c  reason: collision with root package name */
    private final Iterable f5850c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.i.l f5851d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5852e;

    private j(m mVar, com.google.android.datatransport.runtime.backends.g gVar, Iterable iterable, e.g.a.c.i.l lVar, int i2) {
        this.a = mVar;
        this.f5849b = gVar;
        this.f5850c = iterable;
        this.f5851d = lVar;
        this.f5852e = i2;
    }

    public static a.InterfaceC0134a a(m mVar, com.google.android.datatransport.runtime.backends.g gVar, Iterable iterable, e.g.a.c.i.l lVar, int i2) {
        return new j(mVar, gVar, iterable, lVar, i2);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0134a
    public Object execute() {
        return m.c(this.a, this.f5849b, this.f5850c, this.f5851d, this.f5852e);
    }
}