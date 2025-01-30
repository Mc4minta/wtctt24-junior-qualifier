package h.c.t0;

import h.c.s;
import h.c.x;
import kotlin.jvm.internal.m;

/* compiled from: observable.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <T> s<T> a(Iterable<? extends x<T>> receiver) {
        m.h(receiver, "$receiver");
        return s.concat(receiver);
    }

    public static final <T> s<T> b(Iterable<? extends s<? extends T>> receiver) {
        m.h(receiver, "$receiver");
        s<T> merge = s.merge(c(receiver));
        m.d(merge, "Observable.merge(this.toObservable())");
        return merge;
    }

    public static final <T> s<T> c(Iterable<? extends T> receiver) {
        m.h(receiver, "$receiver");
        s<T> fromIterable = s.fromIterable(receiver);
        m.d(fromIterable, "Observable.fromIterable(this)");
        return fromIterable;
    }
}