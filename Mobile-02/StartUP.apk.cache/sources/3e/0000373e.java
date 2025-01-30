package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class n implements Runnable {
    private final /* synthetic */ g a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m f8002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, g gVar) {
        this.f8002b = mVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var;
        b0 b0Var2;
        b0 b0Var3;
        a aVar;
        try {
            aVar = this.f8002b.f8000b;
            g gVar = (g) aVar.a(this.a);
            if (gVar == null) {
                this.f8002b.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = i.f7989b;
            gVar.g(executor, this.f8002b);
            gVar.e(executor, this.f8002b);
            gVar.a(executor, this.f8002b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                b0Var3 = this.f8002b.f8001c;
                b0Var3.t((Exception) e2.getCause());
                return;
            }
            b0Var2 = this.f8002b.f8001c;
            b0Var2.t(e2);
        } catch (Exception e3) {
            b0Var = this.f8002b.f8001c;
            b0Var.t(e3);
        }
    }
}