package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {
    private final m a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f5845b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5846c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f5847d;

    private h(m mVar, e.g.a.c.i.l lVar, int i2, Runnable runnable) {
        this.a = mVar;
        this.f5845b = lVar;
        this.f5846c = i2;
        this.f5847d = runnable;
    }

    public static Runnable a(m mVar, e.g.a.c.i.l lVar, int i2, Runnable runnable) {
        return new h(mVar, lVar, i2, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        m.e(this.a, this.f5845b, this.f5846c, this.f5847d);
    }
}