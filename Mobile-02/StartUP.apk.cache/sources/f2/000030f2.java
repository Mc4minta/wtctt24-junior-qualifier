package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class l implements a.InterfaceC0134a {
    private final m a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f5853b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5854c;

    private l(m mVar, e.g.a.c.i.l lVar, int i2) {
        this.a = mVar;
        this.f5853b = lVar;
        this.f5854c = i2;
    }

    public static a.InterfaceC0134a a(m mVar, e.g.a.c.i.l lVar, int i2) {
        return new l(mVar, lVar, i2);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0134a
    public Object execute() {
        return m.d(this.a, this.f5853b, this.f5854c);
    }
}