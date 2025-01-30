package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class u0 {
    public static final void a(kotlin.c0.f fVar, CancellationException cancellationException) {
        r0 r0Var = (r0) fVar.get(r0.s);
        if (r0Var != null) {
            r0Var.v(cancellationException);
        }
    }

    public static /* synthetic */ void b(kotlin.c0.f fVar, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        t0.a(fVar, cancellationException);
    }
}