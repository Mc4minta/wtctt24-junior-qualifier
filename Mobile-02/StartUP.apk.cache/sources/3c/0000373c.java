package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class l implements Runnable {
    private final /* synthetic */ g a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ k f7999b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, g gVar) {
        this.f7999b = kVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var;
        b0 b0Var2;
        b0 b0Var3;
        a aVar;
        b0 b0Var4;
        b0 b0Var5;
        if (this.a.o()) {
            b0Var5 = this.f7999b.f7998c;
            b0Var5.x();
            return;
        }
        try {
            aVar = this.f7999b.f7997b;
            Object a = aVar.a(this.a);
            b0Var4 = this.f7999b.f7998c;
            b0Var4.u(a);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                b0Var3 = this.f7999b.f7998c;
                b0Var3.t((Exception) e2.getCause());
                return;
            }
            b0Var2 = this.f7999b.f7998c;
            b0Var2.t(e2);
        } catch (Exception e3) {
            b0Var = this.f7999b.f7998c;
            b0Var.t(e3);
        }
    }
}