package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class r implements Runnable {
    private final /* synthetic */ g a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ q f8007b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, g gVar) {
        this.f8007b = qVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        c cVar2;
        obj = this.f8007b.f8005b;
        synchronized (obj) {
            cVar = this.f8007b.f8006c;
            if (cVar != null) {
                cVar2 = this.f8007b.f8006c;
                cVar2.a(this.a);
            }
        }
    }
}