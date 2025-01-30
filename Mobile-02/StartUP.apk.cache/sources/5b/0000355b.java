package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class q5 implements r5 {
    @Override // com.google.android.gms.internal.measurement.r5
    public final Object a(Object obj) {
        return o5.c().e();
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final Map<?, ?> b(Object obj) {
        return (o5) obj;
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final Map<?, ?> c(Object obj) {
        return (o5) obj;
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final boolean d(Object obj) {
        return !((o5) obj).i();
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final p5<?, ?> e(Object obj) {
        m5 m5Var = (m5) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final Object f(Object obj, Object obj2) {
        o5 o5Var = (o5) obj;
        o5 o5Var2 = (o5) obj2;
        if (!o5Var2.isEmpty()) {
            if (!o5Var.i()) {
                o5Var = o5Var.e();
            }
            o5Var.d(o5Var2);
        }
        return o5Var;
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final Object g(Object obj) {
        ((o5) obj).f();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.r5
    public final int h(int i2, Object obj, Object obj2) {
        o5 o5Var = (o5) obj;
        m5 m5Var = (m5) obj2;
        if (o5Var.isEmpty()) {
            return 0;
        }
        Iterator it = o5Var.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw new NoSuchMethodError();
        }
        return 0;
    }
}