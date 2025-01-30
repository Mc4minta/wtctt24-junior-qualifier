package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements a.InterfaceC0134a {
    private final e.g.a.c.i.v.j.c a;

    private k(e.g.a.c.i.v.j.c cVar) {
        this.a = cVar;
    }

    public static a.InterfaceC0134a a(e.g.a.c.i.v.j.c cVar) {
        return new k(cVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0134a
    public Object execute() {
        return Integer.valueOf(this.a.h());
    }
}