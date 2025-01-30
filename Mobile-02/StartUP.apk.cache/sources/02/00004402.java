package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.k;
import h.c.f;
import h.c.m0.p;
import h.c.s;
import java.util.Comparator;

/* compiled from: LifecycleScopes.java */
/* loaded from: classes2.dex */
public final class e {
    private static final Comparator<Comparable<Object>> a = new Comparator() { // from class: com.uber.autodispose.lifecycle.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };

    public static /* synthetic */ boolean a(Comparator comparator, Object obj, Object obj2) throws Exception {
        return comparator.compare(obj2, obj) >= 0;
    }

    public static /* synthetic */ boolean b(Object obj, Object obj2) throws Exception {
        return obj2.equals(obj);
    }

    public static <E> f c(d<E> dVar) throws OutsideScopeException {
        return d(dVar, true);
    }

    public static <E> f d(d<E> dVar, boolean z) throws OutsideScopeException {
        E peekLifecycle = dVar.peekLifecycle();
        CorrespondingEventsFunction<E> correspondingEvents = dVar.correspondingEvents();
        if (peekLifecycle != null) {
            try {
                return e(dVar.lifecycle(), correspondingEvents.apply(peekLifecycle));
            } catch (Exception e2) {
                if (z && (e2 instanceof LifecycleEndedException)) {
                    h.c.m0.f<? super OutsideScopeException> a2 = k.a();
                    if (a2 != null) {
                        try {
                            a2.accept((LifecycleEndedException) e2);
                            return h.c.c.g();
                        } catch (Exception e3) {
                            return h.c.c.q(e3);
                        }
                    }
                    throw e2;
                }
                return h.c.c.q(e2);
            }
        }
        throw new LifecycleNotStartedException();
    }

    public static <E> f e(s<E> sVar, E e2) {
        return f(sVar, e2, e2 instanceof Comparable ? a : null);
    }

    public static <E> f f(s<E> sVar, final E e2, final Comparator<E> comparator) {
        p<? super E> pVar;
        if (comparator != null) {
            pVar = new p() { // from class: com.uber.autodispose.lifecycle.b
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return e.a(comparator, e2, obj);
                }
            };
        } else {
            pVar = new p() { // from class: com.uber.autodispose.lifecycle.c
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return e.b(e2, obj);
                }
            };
        }
        return sVar.skip(1L).takeUntil(pVar).ignoreElements();
    }
}