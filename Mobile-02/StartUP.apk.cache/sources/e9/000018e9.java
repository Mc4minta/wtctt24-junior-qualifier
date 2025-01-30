package com.coinbase.wallet.core.extensions;

import h.c.s;
import h.c.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.a0.r;

/* compiled from: Observables+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a<\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a<\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0086\b¢\u0006\u0004\b\u0007\u0010\u0006\u001aW\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\b\u001a\u00028\u00002\u0014\b\u0004\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"T", "Lh/c/t0/c;", "", "Lh/c/s;", "observables", "zipOrEmpty", "(Lh/c/t0/c;Ljava/util/List;)Lh/c/s;", "combineLatestOrEmpty", "initialState", "Lkotlin/Function1;", "nextValue", "", "endWhen", "sequential", "(Lh/c/t0/c;Ljava/lang/Object;Lkotlin/e0/c/l;Lkotlin/e0/c/l;)Lh/c/s;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Observables_CoreKt {
    public static final /* synthetic */ <T> s<List<T>> combineLatestOrEmpty(h.c.t0.c cVar, List<? extends s<T>> observables) {
        List g2;
        kotlin.jvm.internal.m.g(cVar, "<this>");
        kotlin.jvm.internal.m.g(observables, "observables");
        if (observables.isEmpty()) {
            g2 = r.g();
            s<List<T>> just = s.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        Object[] array = observables.toArray(new s[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        kotlin.jvm.internal.m.k();
        s<List<T>> combineLatest = s.combineLatest((x[]) array, new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.Observables_CoreKt$combineLatestOrEmpty$1
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

    public static final <T> s<T> sequential(h.c.t0.c cVar, final T t, final kotlin.e0.c.l<? super T, ? extends T> nextValue, final kotlin.e0.c.l<? super T, Boolean> endWhen) {
        kotlin.jvm.internal.m.g(cVar, "<this>");
        kotlin.jvm.internal.m.g(nextValue, "nextValue");
        kotlin.jvm.internal.m.g(endWhen, "endWhen");
        s<T> generate = s.generate(new Callable() { // from class: com.coinbase.wallet.core.extensions.Observables_CoreKt$sequential$1
            @Override // java.util.concurrent.Callable
            public final T call() {
                return t;
            }
        }, new h.c.m0.c() { // from class: com.coinbase.wallet.core.extensions.Observables_CoreKt$sequential$2
            @Override // h.c.m0.c
            public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
                return apply((Observables_CoreKt$sequential$2<T1, T2, R>) obj, (h.c.g<Observables_CoreKt$sequential$2<T1, T2, R>>) obj2);
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
            public final T apply(T t2, h.c.g<T> emitter) {
                kotlin.jvm.internal.m.g(emitter, "emitter");
                if (endWhen.invoke(t2).booleanValue()) {
                    emitter.onComplete();
                } else {
                    emitter.onNext(t2);
                }
                return nextValue.invoke(t2);
            }
        });
        kotlin.jvm.internal.m.f(generate, "initialState: T,\n    crossinline nextValue: (T) -> T,\n    crossinline endWhen: (T) -> Boolean\n): Observable<T> {\n    return Observable.generate(\n        Callable<T> { initialState },\n        BiFunction<T, Emitter<T>, T> { currentValue, emitter ->\n            if (endWhen(currentValue)) {\n                emitter.onComplete()\n            } else {\n                emitter.onNext(currentValue)\n            }\n\n            nextValue(currentValue)\n        }\n    )");
        return generate;
    }

    public static final /* synthetic */ <T> s<List<T>> zipOrEmpty(h.c.t0.c cVar, List<? extends s<T>> observables) {
        List g2;
        kotlin.jvm.internal.m.g(cVar, "<this>");
        kotlin.jvm.internal.m.g(observables, "observables");
        if (observables.isEmpty()) {
            g2 = r.g();
            s<List<T>> just = s.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        kotlin.jvm.internal.m.k();
        s<List<T>> zip = s.zip(observables, new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.Observables_CoreKt$zipOrEmpty$1
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
        kotlin.jvm.internal.m.f(zip, "zip(observables) {\n        if (it.isEmpty()) emptyList() else it.filterIsInstance<T>()\n    }");
        return zip;
    }
}