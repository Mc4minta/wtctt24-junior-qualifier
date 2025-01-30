package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class x implements Runnable {
    private final /* synthetic */ g a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ w f8016b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, g gVar) {
        this.f8016b = wVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        try {
            fVar = this.f8016b.f8014b;
            g a = fVar.a(this.a.m());
            if (a == null) {
                this.f8016b.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = i.f7989b;
            a.g(executor, this.f8016b);
            a.e(executor, this.f8016b);
            a.a(executor, this.f8016b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f8016b.c((Exception) e2.getCause());
            } else {
                this.f8016b.c(e2);
            }
        } catch (CancellationException unused) {
            this.f8016b.b();
        } catch (Exception e3) {
            this.f8016b.c(e3);
        }
    }
}