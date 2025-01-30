package com.coinbase.wallet.core.extensions;

import h.c.b0;
import h.c.s;
import h.c.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.e0.c.p;

/* compiled from: List+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042$\u0010\b\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\r\"\u0006\b\u0000\u0010\f\u0018\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0003H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a4\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0010\"\u0006\b\u0000\u0010\f\u0018\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0003H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"K", "V", "E", "", "", "map", "Lkotlin/Function2;", "Lkotlin/x;", "closure", "", "reduceIntoMap", "(Ljava/util/List;Ljava/util/Map;Lkotlin/e0/c/p;)Ljava/util/Map;", "T", "Lh/c/b0;", "zipOrEmpty", "(Ljava/util/List;)Lh/c/b0;", "Lh/c/s;", "combineLatestOrEmpty", "(Ljava/util/List;)Lh/c/s;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class List_CoreKt {
    public static final /* synthetic */ <T> s<List<T>> combineLatestOrEmpty(List<? extends s<T>> list) {
        List g2;
        kotlin.jvm.internal.m.g(list, "<this>");
        h.c.t0.c cVar = h.c.t0.c.a;
        if (list.isEmpty()) {
            g2 = r.g();
            s<List<T>> just = s.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        Object[] array = list.toArray(new s[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        kotlin.jvm.internal.m.k();
        s<List<T>> combineLatest = s.combineLatest((x[]) array, new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.List_CoreKt$combineLatestOrEmpty$$inlined$combineLatestOrEmpty$1
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
        kotlin.jvm.internal.m.f(combineLatest, "combineLatest(observables.toTypedArray()) {\n        if (it.isEmpty()) emptyList() else it.filterIsInstance<T>()\n    }");
        return combineLatest;
    }

    public static final /* synthetic */ <K, V, E> Map<K, V> reduceIntoMap(List<? extends E> list, Map<K, V> map, p<? super Map<K, V>, ? super E, kotlin.x> closure) {
        kotlin.jvm.internal.m.g(list, "<this>");
        kotlin.jvm.internal.m.g(map, "map");
        kotlin.jvm.internal.m.g(closure, "closure");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            closure.invoke(map, (Object) it.next());
        }
        return map;
    }

    public static /* synthetic */ Map reduceIntoMap$default(List list, Map map, p closure, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = new LinkedHashMap();
        }
        kotlin.jvm.internal.m.g(list, "<this>");
        kotlin.jvm.internal.m.g(map, "map");
        kotlin.jvm.internal.m.g(closure, "closure");
        for (Object obj2 : list) {
            closure.invoke(map, obj2);
        }
        return map;
    }

    public static final /* synthetic */ <T> b0<List<T>> zipOrEmpty(List<? extends b0<T>> list) {
        List g2;
        kotlin.jvm.internal.m.g(list, "<this>");
        h.c.t0.e eVar = h.c.t0.e.a;
        if (list.isEmpty()) {
            g2 = r.g();
            b0<List<T>> just = b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        kotlin.jvm.internal.m.k();
        b0<List<T>> zip = b0.zip(list, new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.List_CoreKt$zipOrEmpty$$inlined$zipOrEmpty$1
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
}