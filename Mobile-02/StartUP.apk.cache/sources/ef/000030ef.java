package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements a.InterfaceC0134a {
    private final m a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f5848b;

    private i(m mVar, e.g.a.c.i.l lVar) {
        this.a = mVar;
        this.f5848b = lVar;
    }

    public static a.InterfaceC0134a a(m mVar, e.g.a.c.i.l lVar) {
        return new i(mVar, lVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0134a
    public Object execute() {
        Iterable E;
        E = this.a.f5856c.E(this.f5848b);
        return E;
    }
}