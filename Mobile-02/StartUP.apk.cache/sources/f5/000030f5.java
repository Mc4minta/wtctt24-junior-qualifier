package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class o implements Runnable {
    private final q a;

    private o(q qVar) {
        this.a = qVar;
    }

    public static Runnable a(q qVar) {
        return new o(qVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.f5869d.a(p.a(this.a));
    }
}