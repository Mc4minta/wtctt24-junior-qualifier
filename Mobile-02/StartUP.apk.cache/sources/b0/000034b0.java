package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class f5 extends d5 {

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f7132c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private f5() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> e(Object obj, long j2, int i2) {
        b5 b5Var;
        List<L> arrayList;
        List<L> f2 = f(obj, j2);
        if (f2.isEmpty()) {
            if (f2 instanceof e5) {
                arrayList = new b5(i2);
            } else if ((f2 instanceof f6) && (f2 instanceof v4)) {
                arrayList = ((v4) f2).f(i2);
            } else {
                arrayList = new ArrayList<>(i2);
            }
            j7.j(obj, j2, arrayList);
            return arrayList;
        }
        if (f7132c.isAssignableFrom(f2.getClass())) {
            ArrayList arrayList2 = new ArrayList(f2.size() + i2);
            arrayList2.addAll(f2);
            j7.j(obj, j2, arrayList2);
            b5Var = arrayList2;
        } else if (f2 instanceof e7) {
            b5 b5Var2 = new b5(f2.size() + i2);
            b5Var2.addAll((e7) f2);
            j7.j(obj, j2, b5Var2);
            b5Var = b5Var2;
        } else if ((f2 instanceof f6) && (f2 instanceof v4)) {
            v4 v4Var = (v4) f2;
            if (v4Var.a()) {
                return f2;
            }
            v4 f3 = v4Var.f(f2.size() + i2);
            j7.j(obj, j2, f3);
            return f3;
        } else {
            return f2;
        }
        return b5Var;
    }

    private static <E> List<E> f(Object obj, long j2) {
        return (List) j7.F(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d5
    public final <E> void b(Object obj, Object obj2, long j2) {
        List f2 = f(obj2, j2);
        List e2 = e(obj, j2, f2.size());
        int size = e2.size();
        int size2 = f2.size();
        if (size > 0 && size2 > 0) {
            e2.addAll(f2);
        }
        if (size > 0) {
            f2 = e2;
        }
        j7.j(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d5
    public final void d(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) j7.F(obj, j2);
        if (list instanceof e5) {
            unmodifiableList = ((e5) list).e();
        } else if (f7132c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof f6) && (list instanceof v4)) {
                v4 v4Var = (v4) list;
                if (v4Var.a()) {
                    v4Var.b();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        j7.j(obj, j2, unmodifiableList);
    }
}