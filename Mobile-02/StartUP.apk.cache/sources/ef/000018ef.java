package com.coinbase.wallet.core.extensions;

import com.coinbase.wallet.core.models.Five;
import com.coinbase.wallet.core.models.Four;
import com.coinbase.wallet.core.models.Seven;
import com.coinbase.wallet.core.models.Six;
import com.coinbase.wallet.core.util.Optional;
import h.c.b0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;

/* compiled from: Singles+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0003\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0007*\u00020\u0001H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001a\u007f\u0010\u0014\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00130\u0003\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u000e*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0099\u0001\u0010\u0014\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00180\u0003\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u000e\"\u0004\b\u0004\u0010\u0016*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003¢\u0006\u0004\b\u0014\u0010\u0019\u001a³\u0001\u0010\u0014\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001c0\u0003\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u000e\"\u0004\b\u0004\u0010\u0016\"\u0004\b\u0005\u0010\u001a*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003¢\u0006\u0004\b\u0014\u0010\u001d\u001aÍ\u0001\u0010\u0014\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00060 0\u0003\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u000e\"\u0004\b\u0004\u0010\u0016\"\u0004\b\u0005\u0010\u001a\"\u0004\b\u0006\u0010\u001e*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00050\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00060\u0003¢\u0006\u0004\b\u0014\u0010!¨\u0006\""}, d2 = {"T", "Lh/c/t0/e;", "", "Lh/c/b0;", "singles", "zipOrEmpty", "(Lh/c/t0/e;Ljava/util/List;)Lh/c/b0;", "", "Lcom/coinbase/wallet/core/util/Optional;", "justNull", "(Lh/c/t0/e;)Lh/c/b0;", "A", "B", "C", "D", "s1", "s2", "s3", "s4", "Lcom/coinbase/wallet/core/models/Four;", "zip", "(Lh/c/t0/e;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;)Lh/c/b0;", "E", "s5", "Lcom/coinbase/wallet/core/models/Five;", "(Lh/c/t0/e;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;)Lh/c/b0;", "F", "s6", "Lcom/coinbase/wallet/core/models/Six;", "(Lh/c/t0/e;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;)Lh/c/b0;", "G", "s7", "Lcom/coinbase/wallet/core/models/Seven;", "(Lh/c/t0/e;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;Lh/c/b0;)Lh/c/b0;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Singles_CoreKt {
    public static final /* synthetic */ <T> b0<Optional<T>> justNull(h.c.t0.e eVar) {
        kotlin.jvm.internal.m.g(eVar, "<this>");
        b0<Optional<T>> just = b0.just(new Optional(null));
        kotlin.jvm.internal.m.f(just, "just(Optional(null))");
        return just;
    }

    public static final <A, B, C, D> b0<Four<A, B, C, D>> zip(h.c.t0.e eVar, b0<A> s1, b0<B> s2, b0<C> s3, b0<D> s4) {
        kotlin.jvm.internal.m.g(eVar, "<this>");
        kotlin.jvm.internal.m.g(s1, "s1");
        kotlin.jvm.internal.m.g(s2, "s2");
        kotlin.jvm.internal.m.g(s3, "s3");
        kotlin.jvm.internal.m.g(s4, "s4");
        h.c.t0.e eVar2 = h.c.t0.e.a;
        b0<Four<A, B, C, D>> zip = b0.zip(s1, s2, s3, s4, new h.c.m0.h<T1, T2, T3, T4, R>() { // from class: com.coinbase.wallet.core.extensions.Singles_CoreKt$zip$$inlined$zip$1
            @Override // h.c.m0.h
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                return (R) new Four(t1, t2, t3, t4);
            }
        });
        kotlin.jvm.internal.m.d(zip, "Single.zip(s1, s2, s3, s…invoke(t1, t2, t3, t4) })");
        return zip;
    }

    public static final /* synthetic */ <T> b0<List<T>> zipOrEmpty(h.c.t0.e eVar, List<? extends b0<T>> singles) {
        List g2;
        kotlin.jvm.internal.m.g(eVar, "<this>");
        kotlin.jvm.internal.m.g(singles, "singles");
        if (singles.isEmpty()) {
            g2 = r.g();
            b0<List<T>> just = b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        kotlin.jvm.internal.m.k();
        b0<List<T>> zip = b0.zip(singles, new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.Singles_CoreKt$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it, "it");
                if (it.length == 0) {
                    g3 = r.g();
                    return g3;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : it) {
                    kotlin.jvm.internal.m.l(3, "T");
                    if (obj instanceof Object) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    public static final <A, B, C, D, E> b0<Five<A, B, C, D, E>> zip(h.c.t0.e eVar, b0<A> s1, b0<B> s2, b0<C> s3, b0<D> s4, b0<E> s5) {
        kotlin.jvm.internal.m.g(eVar, "<this>");
        kotlin.jvm.internal.m.g(s1, "s1");
        kotlin.jvm.internal.m.g(s2, "s2");
        kotlin.jvm.internal.m.g(s3, "s3");
        kotlin.jvm.internal.m.g(s4, "s4");
        kotlin.jvm.internal.m.g(s5, "s5");
        h.c.t0.e eVar2 = h.c.t0.e.a;
        b0<Five<A, B, C, D, E>> zip = b0.zip(s1, s2, s3, s4, s5, new h.c.m0.i<T1, T2, T3, T4, T5, R>() { // from class: com.coinbase.wallet.core.extensions.Singles_CoreKt$zip$$inlined$zip$2
            @Override // h.c.m0.i
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                return (R) new Five(t1, t2, t3, t4, t5);
            }
        });
        kotlin.jvm.internal.m.d(zip, "Single.zip(s1, s2, s3, s…ke(t1, t2, t3, t4, t5) })");
        return zip;
    }

    public static final <A, B, C, D, E, F> b0<Six<A, B, C, D, E, F>> zip(h.c.t0.e eVar, b0<A> s1, b0<B> s2, b0<C> s3, b0<D> s4, b0<E> s5, b0<F> s6) {
        kotlin.jvm.internal.m.g(eVar, "<this>");
        kotlin.jvm.internal.m.g(s1, "s1");
        kotlin.jvm.internal.m.g(s2, "s2");
        kotlin.jvm.internal.m.g(s3, "s3");
        kotlin.jvm.internal.m.g(s4, "s4");
        kotlin.jvm.internal.m.g(s5, "s5");
        kotlin.jvm.internal.m.g(s6, "s6");
        h.c.t0.e eVar2 = h.c.t0.e.a;
        b0<Six<A, B, C, D, E, F>> zip = b0.zip(s1, s2, s3, s4, s5, s6, new h.c.m0.j<T1, T2, T3, T4, T5, T6, R>() { // from class: com.coinbase.wallet.core.extensions.Singles_CoreKt$zip$$inlined$zip$3
            @Override // h.c.m0.j
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
                return (R) new Six(t1, t2, t3, t4, t5, t6);
            }
        });
        kotlin.jvm.internal.m.d(zip, "Single.zip(s1, s2, s3, s…1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    public static final <A, B, C, D, E, F, G> b0<Seven<A, B, C, D, E, E, G>> zip(h.c.t0.e eVar, b0<A> s1, b0<B> s2, b0<C> s3, b0<D> s4, b0<E> s5, b0<F> s6, b0<G> s7) {
        kotlin.jvm.internal.m.g(eVar, "<this>");
        kotlin.jvm.internal.m.g(s1, "s1");
        kotlin.jvm.internal.m.g(s2, "s2");
        kotlin.jvm.internal.m.g(s3, "s3");
        kotlin.jvm.internal.m.g(s4, "s4");
        kotlin.jvm.internal.m.g(s5, "s5");
        kotlin.jvm.internal.m.g(s6, "s6");
        kotlin.jvm.internal.m.g(s7, "s7");
        h.c.t0.e eVar2 = h.c.t0.e.a;
        b0<Seven<A, B, C, D, E, E, G>> zip = b0.zip(s1, s2, s3, s4, s5, s6, s7, new h.c.m0.k<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: com.coinbase.wallet.core.extensions.Singles_CoreKt$zip$$inlined$zip$4
            @Override // h.c.m0.k
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
                return (R) new Seven(t1, t2, t3, t4, t5, t5, t7);
            }
        });
        kotlin.jvm.internal.m.d(zip, "Single.zip(s1, s2, s3, s…2, t3, t4, t5, t6, t7) })");
        return zip;
    }
}