package h.c.n0.e.d;

import h.c.h0;
import h.c.n0.e.g.v0;
import h.c.q;
import h.c.z;
import java.util.concurrent.Callable;

/* compiled from: ScalarXMapZHelper.java */
/* loaded from: classes3.dex */
final class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(Object obj, h.c.m0.n<? super T, ? extends h.c.f> nVar, h.c.e eVar) {
        if (obj instanceof Callable) {
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                h.c.f fVar = obj2 != 0 ? (h.c.f) h.c.n0.b.b.e(nVar.apply(obj2), "The mapper returned a null CompletableSource") : null;
                if (fVar == null) {
                    h.c.n0.a.d.h(eVar);
                } else {
                    fVar.c(eVar);
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.s(th, eVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean b(Object obj, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, z<? super R> zVar) {
        if (obj instanceof Callable) {
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                q qVar = obj2 != 0 ? (q) h.c.n0.b.b.e(nVar.apply(obj2), "The mapper returned a null MaybeSource") : null;
                if (qVar == null) {
                    h.c.n0.a.d.q(zVar);
                } else {
                    qVar.b(h.c.n0.e.c.c.b(zVar));
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.y(th, zVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean c(Object obj, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, z<? super R> zVar) {
        if (obj instanceof Callable) {
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                h0 h0Var = obj2 != 0 ? (h0) h.c.n0.b.b.e(nVar.apply(obj2), "The mapper returned a null SingleSource") : null;
                if (h0Var == null) {
                    h.c.n0.a.d.q(zVar);
                } else {
                    h0Var.subscribe(v0.b(zVar));
                }
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.y(th, zVar);
                return true;
            }
        }
        return false;
    }
}