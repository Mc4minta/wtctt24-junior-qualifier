package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class p implements Runnable {
    private final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.a.f8003b;
        synchronized (obj) {
            bVar = this.a.f8004c;
            if (bVar != null) {
                bVar2 = this.a.f8004c;
                bVar2.b();
            }
        }
    }
}