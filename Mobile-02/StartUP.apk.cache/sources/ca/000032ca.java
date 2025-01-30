package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class n2<T> implements z2<T> {
    private final i2 a;

    /* renamed from: b  reason: collision with root package name */
    private final q3<?, ?> f6518b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6519c;

    /* renamed from: d  reason: collision with root package name */
    private final r0<?> f6520d;

    private n2(q3<?, ?> q3Var, r0<?> r0Var, i2 i2Var) {
        this.f6518b = q3Var;
        this.f6519c = r0Var.g(i2Var);
        this.f6520d = r0Var;
        this.a = i2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n2<T> a(q3<?, ?> q3Var, r0<?> r0Var, i2 i2Var) {
        return new n2<>(q3Var, r0Var, i2Var);
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final void b(T t) {
        this.f6518b.d(t);
        this.f6520d.f(t);
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final void c(T t, T t2) {
        b3.i(this.f6518b, t, t2);
        if (this.f6519c) {
            b3.g(this.f6520d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final int d(T t) {
        q3<?, ?> q3Var = this.f6518b;
        int l2 = q3Var.l(q3Var.k(t)) + 0;
        return this.f6519c ? l2 + this.f6520d.b(t).m() : l2;
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final boolean e(T t, T t2) {
        if (this.f6518b.k(t).equals(this.f6518b.k(t2))) {
            if (this.f6519c) {
                return this.f6520d.b(t).equals(this.f6520d.b(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final int f(T t) {
        int hashCode = this.f6518b.k(t).hashCode();
        return this.f6519c ? (hashCode * 53) + this.f6520d.b(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final void g(T t, l4 l4Var) throws IOException {
        Iterator<Map.Entry<?, Object>> e2 = this.f6520d.b(t).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            y0 y0Var = (y0) next.getKey();
            if (y0Var.o() != k4.MESSAGE || y0Var.r() || y0Var.j()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            l4Var.i(y0Var.c(), next instanceof n1 ? ((n1) next).a().d() : next.getValue());
        }
        q3<?, ?> q3Var = this.f6518b;
        q3Var.e(q3Var.k(t), l4Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0061 A[EDGE_INSN: B:49:0x0061->B:27:0x0061 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(T r8, byte[] r9, int r10, int r11, com.google.android.gms.internal.clearcut.w r12) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.clearcut.e1 r8 = (com.google.android.gms.internal.clearcut.e1) r8
            com.google.android.gms.internal.clearcut.r3 r0 = r8.zzjp
            com.google.android.gms.internal.clearcut.r3 r1 = com.google.android.gms.internal.clearcut.r3.h()
            if (r0 != r1) goto L10
            com.google.android.gms.internal.clearcut.r3 r0 = com.google.android.gms.internal.clearcut.r3.i()
            r8.zzjp = r0
        L10:
            r8 = r0
        L11:
            if (r10 >= r11) goto L6b
            int r2 = com.google.android.gms.internal.clearcut.v.e(r9, r10, r12)
            int r0 = r12.a
            r10 = 11
            r1 = 2
            if (r0 == r10) goto L30
            r10 = r0 & 7
            if (r10 != r1) goto L2b
            r1 = r9
            r3 = r11
            r4 = r8
            r5 = r12
            int r10 = com.google.android.gms.internal.clearcut.v.c(r0, r1, r2, r3, r4, r5)
            goto L11
        L2b:
            int r10 = com.google.android.gms.internal.clearcut.v.a(r0, r9, r2, r11, r12)
            goto L11
        L30:
            r10 = 0
            r0 = 0
        L32:
            if (r2 >= r11) goto L61
            int r2 = com.google.android.gms.internal.clearcut.v.e(r9, r2, r12)
            int r3 = r12.a
            int r4 = r3 >>> 3
            r5 = r3 & 7
            if (r4 == r1) goto L4f
            r6 = 3
            if (r4 == r6) goto L44
            goto L58
        L44:
            if (r5 != r1) goto L58
            int r2 = com.google.android.gms.internal.clearcut.v.m(r9, r2, r12)
            java.lang.Object r0 = r12.f6600c
            com.google.android.gms.internal.clearcut.a0 r0 = (com.google.android.gms.internal.clearcut.a0) r0
            goto L32
        L4f:
            if (r5 != 0) goto L58
            int r2 = com.google.android.gms.internal.clearcut.v.e(r9, r2, r12)
            int r10 = r12.a
            goto L32
        L58:
            r4 = 12
            if (r3 == r4) goto L61
            int r2 = com.google.android.gms.internal.clearcut.v.a(r3, r9, r2, r11, r12)
            goto L32
        L61:
            if (r0 == 0) goto L69
            int r10 = r10 << 3
            r10 = r10 | r1
            r8.e(r10, r0)
        L69:
            r10 = r2
            goto L11
        L6b:
            if (r10 != r11) goto L6e
            return
        L6e:
            com.google.android.gms.internal.clearcut.zzco r8 = com.google.android.gms.internal.clearcut.zzco.d()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.n2.h(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.w):void");
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final T i() {
        return (T) this.a.k().g0();
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final boolean j(T t) {
        return this.f6520d.b(t).d();
    }
}