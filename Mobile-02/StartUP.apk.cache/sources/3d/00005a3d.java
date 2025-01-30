package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.c0.f;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public interface r0 extends f.b {
    public static final b s = b.a;

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ void a(r0 r0Var, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                r0Var.v(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(r0 r0Var, R r, kotlin.e0.c.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) f.b.a.a(r0Var, r, pVar);
        }

        public static <E extends f.b> E c(r0 r0Var, f.c<E> cVar) {
            return (E) f.b.a.b(r0Var, cVar);
        }

        public static /* synthetic */ d0 d(r0 r0Var, boolean z, boolean z2, kotlin.e0.c.l lVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                if ((i2 & 2) != 0) {
                    z2 = true;
                }
                return r0Var.e(z, z2, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static kotlin.c0.f e(r0 r0Var, f.c<?> cVar) {
            return f.b.a.c(r0Var, cVar);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class b implements f.c<r0> {
        static final /* synthetic */ b a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.r;
        }

        private b() {
        }
    }

    boolean a();

    d0 e(boolean z, boolean z2, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar);

    CancellationException f();

    void v(CancellationException cancellationException);
}