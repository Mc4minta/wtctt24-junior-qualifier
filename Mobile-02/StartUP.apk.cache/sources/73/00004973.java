package e.j.f;

import h.c.b0;
import h.c.h0;

/* compiled from: SingleExtensions.kt */
/* loaded from: classes2.dex */
public final class t {
    public static final <T> b0<T> a(b0<? extends T> b0Var, final kotlin.e0.c.l<? super T, ? extends h.c.c> mapper) {
        kotlin.jvm.internal.m.g(b0Var, "<this>");
        kotlin.jvm.internal.m.g(mapper, "mapper");
        b0<T> b0Var2 = (b0<T>) b0Var.flatMap(new h.c.m0.n() { // from class: e.j.f.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return t.c(kotlin.e0.c.l.this, obj);
            }
        });
        kotlin.jvm.internal.m.f(b0Var2, "this.flatMap { mapper.invoke(it).toSingleDefault(it) }");
        return b0Var2;
    }

    public static final h0 b(kotlin.e0.c.l mapper, Object obj) {
        kotlin.jvm.internal.m.g(mapper, "$mapper");
        return ((h.c.c) mapper.invoke(obj)).x(obj);
    }

    public static /* synthetic */ h0 c(kotlin.e0.c.l lVar, Object obj) {
        return b(lVar, obj);
    }
}