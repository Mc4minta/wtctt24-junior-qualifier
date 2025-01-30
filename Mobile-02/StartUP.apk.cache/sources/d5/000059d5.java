package kotlinx.coroutines;

import java.util.Objects;
import kotlin.p;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public final class b0 {
    public static final <T> void a(a0<? super T> a0Var, int i2) {
        if (x.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        kotlin.c0.d<? super T> g2 = a0Var.g();
        boolean z = i2 == 4;
        if (!z && (g2 instanceof kotlinx.coroutines.internal.d) && b(i2) == b(a0Var.f17415c)) {
            t tVar = ((kotlinx.coroutines.internal.d) g2).f17491h;
            kotlin.c0.f e2 = g2.e();
            if (tVar.G(e2)) {
                tVar.A(e2, a0Var);
                return;
            } else {
                e(a0Var);
                return;
            }
        }
        d(a0Var, g2, z);
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(a0<? super T> a0Var, kotlin.c0.d<? super T> dVar, boolean z) {
        Object i2;
        Object k2 = a0Var.k();
        Throwable h2 = a0Var.h(k2);
        if (h2 != null) {
            p.a aVar = kotlin.p.a;
            i2 = kotlin.q.a(h2);
        } else {
            p.a aVar2 = kotlin.p.a;
            i2 = a0Var.i(k2);
        }
        Object a = kotlin.p.a(i2);
        if (z) {
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            kotlinx.coroutines.internal.d dVar2 = (kotlinx.coroutines.internal.d) dVar;
            kotlin.c0.f e2 = dVar2.e();
            Object c2 = kotlinx.coroutines.internal.s.c(e2, dVar2.f17490g);
            try {
                dVar2.f17492j.b(a);
                kotlin.x xVar = kotlin.x.a;
                return;
            } finally {
                kotlinx.coroutines.internal.s.a(e2, c2);
            }
        }
        dVar.b(a);
    }

    private static final void e(a0<?> a0Var) {
        f0 a = d1.f17420b.a();
        if (a.e0()) {
            a.O(a0Var);
            return;
        }
        a.a0(true);
        try {
            d(a0Var, a0Var.g(), true);
            do {
            } while (a.k0());
        } finally {
            try {
            } finally {
            }
        }
    }
}