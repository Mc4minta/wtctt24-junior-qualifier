package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class u1 extends s1 {

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f6571c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private u1() {
        super();
    }

    private static <E> List<E> e(Object obj, long j2) {
        return (List) x3.M(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.s1
    public final void a(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) x3.M(obj, j2);
        if (list instanceof r1) {
            unmodifiableList = ((r1) list).R0();
        } else if (f6571c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        x3.i(obj, j2, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.s1
    public final <E> void b(Object obj, Object obj2, long j2) {
        q1 q1Var;
        List e2 = e(obj2, j2);
        int size = e2.size();
        List e3 = e(obj, j2);
        if (e3.isEmpty()) {
            e3 = e3 instanceof r1 ? new q1(size) : new ArrayList(size);
            x3.i(obj, j2, e3);
        } else {
            if (f6571c.isAssignableFrom(e3.getClass())) {
                ArrayList arrayList = new ArrayList(e3.size() + size);
                arrayList.addAll(e3);
                q1Var = arrayList;
            } else if (e3 instanceof u3) {
                q1 q1Var2 = new q1(e3.size() + size);
                q1Var2.addAll((u3) e3);
                q1Var = q1Var2;
            }
            x3.i(obj, j2, q1Var);
            e3 = q1Var;
        }
        int size2 = e3.size();
        int size3 = e2.size();
        if (size2 > 0 && size3 > 0) {
            e3.addAll(e2);
        }
        if (size2 > 0) {
            e2 = e3;
        }
        x3.i(obj, j2, e2);
    }
}