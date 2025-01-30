package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class t implements Runnable {
    private final /* synthetic */ g a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s f8010b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, g gVar) {
        this.f8010b = sVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.f8010b.f8008b;
        synchronized (obj) {
            dVar = this.f8010b.f8009c;
            if (dVar != null) {
                dVar2 = this.f8010b.f8009c;
                dVar2.c(this.a.l());
            }
        }
    }
}