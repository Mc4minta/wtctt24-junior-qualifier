package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class v implements Runnable {
    private final /* synthetic */ g a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ u f8013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, g gVar) {
        this.f8013b = uVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.f8013b.f8011b;
        synchronized (obj) {
            eVar = this.f8013b.f8012c;
            if (eVar != null) {
                eVar2 = this.f8013b.f8012c;
                eVar2.onSuccess(this.a.m());
            }
        }
    }
}