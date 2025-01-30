package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class p implements a.InterfaceC0134a {
    private final q a;

    private p(q qVar) {
        this.a = qVar;
    }

    public static a.InterfaceC0134a a(q qVar) {
        return new p(qVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0134a
    public Object execute() {
        return q.b(this.a);
    }
}