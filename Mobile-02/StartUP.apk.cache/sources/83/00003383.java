package com.google.android.gms.internal.p000firebaseperf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h5  reason: invalid package */
/* loaded from: classes2.dex */
final class h5 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f6731c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private h5() {
        super();
    }

    private static <E> List<E> e(Object obj, long j2) {
        return (List) k7.G(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f5
    public final void a(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) k7.G(obj, j2);
        if (list instanceof b5) {
            unmodifiableList = ((b5) list).r0();
        } else if (f6731c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof f6) && (list instanceof t4)) {
                t4 t4Var = (t4) list;
                if (t4Var.K()) {
                    t4Var.Q0();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        k7.g(obj, j2, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f5
    public final <E> void b(Object obj, Object obj2, long j2) {
        ArrayList arrayList;
        List e2 = e(obj2, j2);
        int size = e2.size();
        List e3 = e(obj, j2);
        if (e3.isEmpty()) {
            if (e3 instanceof b5) {
                e3 = new d5(size);
            } else if ((e3 instanceof f6) && (e3 instanceof t4)) {
                e3 = ((t4) e3).J0(size);
            } else {
                e3 = new ArrayList(size);
            }
            k7.g(obj, j2, e3);
        } else {
            if (f6731c.isAssignableFrom(e3.getClass())) {
                ArrayList arrayList2 = new ArrayList(e3.size() + size);
                arrayList2.addAll(e3);
                k7.g(obj, j2, arrayList2);
                arrayList = arrayList2;
            } else if (e3 instanceof f7) {
                List d5Var = new d5(e3.size() + size);
                d5Var.addAll((f7) e3);
                k7.g(obj, j2, d5Var);
                arrayList = d5Var;
            } else if ((e3 instanceof f6) && (e3 instanceof t4)) {
                t4 t4Var = (t4) e3;
                if (!t4Var.K()) {
                    e3 = t4Var.J0(e3.size() + size);
                    k7.g(obj, j2, e3);
                }
            }
            e3 = arrayList;
        }
        int size2 = e3.size();
        int size3 = e2.size();
        if (size2 > 0 && size3 > 0) {
            e3.addAll(e2);
        }
        if (size2 > 0) {
            e2 = e3;
        }
        k7.g(obj, j2, e2);
    }
}