package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class q {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.v.j.c f5867b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5868c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f5869d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Executor executor, e.g.a.c.i.v.j.c cVar, s sVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.a = executor;
        this.f5867b = cVar;
        this.f5868c = sVar;
        this.f5869d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(q qVar) {
        for (e.g.a.c.i.l lVar : qVar.f5867b.T()) {
            qVar.f5868c.a(lVar, 1);
        }
        return null;
    }

    public void a() {
        this.a.execute(o.a(this));
    }
}