package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class e2 implements d2 {
    @Override // com.google.android.gms.internal.clearcut.d2
    public final Object a(Object obj) {
        return c2.d().e();
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final Object b(Object obj) {
        ((c2) obj).k();
        return obj;
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final int d(int i2, Object obj, Object obj2) {
        c2 c2Var = (c2) obj;
        if (c2Var.isEmpty()) {
            return 0;
        }
        Iterator it = c2Var.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw new NoSuchMethodError();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final boolean e(Object obj) {
        return !((c2) obj).b();
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final Object g(Object obj, Object obj2) {
        c2 c2Var = (c2) obj;
        c2 c2Var2 = (c2) obj2;
        if (!c2Var2.isEmpty()) {
            if (!c2Var.b()) {
                c2Var = c2Var.e();
            }
            c2Var.c(c2Var2);
        }
        return c2Var;
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final b2<?, ?> h(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final Map<?, ?> i(Object obj) {
        return (c2) obj;
    }

    @Override // com.google.android.gms.internal.clearcut.d2
    public final Map<?, ?> j(Object obj) {
        return (c2) obj;
    }
}