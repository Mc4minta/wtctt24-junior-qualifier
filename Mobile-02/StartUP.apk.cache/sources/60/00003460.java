package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class a6<T> implements m6<T> {
    private final u5 a;

    /* renamed from: b  reason: collision with root package name */
    private final d7<?, ?> f7027b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7028c;

    /* renamed from: d  reason: collision with root package name */
    private final b4<?> f7029d;

    private a6(d7<?, ?> d7Var, b4<?> b4Var, u5 u5Var) {
        this.f7027b = d7Var;
        this.f7028c = b4Var.e(u5Var);
        this.f7029d = b4Var;
        this.a = u5Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> a6<T> j(d7<?, ?> d7Var, b4<?> b4Var, u5 u5Var) {
        return new a6<>(d7Var, b4Var, u5Var);
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final T a() {
        return (T) this.a.e().g();
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void b(T t) {
        this.f7027b.j(t);
        this.f7029d.g(t);
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final int c(T t) {
        int hashCode = this.f7027b.f(t).hashCode();
        return this.f7028c ? (hashCode * 53) + this.f7029d.b(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean d(T t) {
        return this.f7029d.b(t).q();
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final int e(T t) {
        d7<?, ?> d7Var = this.f7027b;
        int k2 = d7Var.k(d7Var.f(t)) + 0;
        return this.f7028c ? k2 + this.f7029d.b(t).r() : k2;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean f(T t, T t2) {
        if (this.f7027b.f(t).equals(this.f7027b.f(t2))) {
            if (this.f7028c) {
                return this.f7029d.b(t).equals(this.f7029d.b(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void g(T t, T t2) {
        o6.o(this.f7027b, t, t2);
        if (this.f7028c) {
            o6.m(this.f7029d, t, t2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.c3 r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.n4 r0 = (com.google.android.gms.internal.measurement.n4) r0
            com.google.android.gms.internal.measurement.c7 r1 = r0.zzb
            com.google.android.gms.internal.measurement.c7 r2 = com.google.android.gms.internal.measurement.c7.a()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.c7 r1 = com.google.android.gms.internal.measurement.c7.g()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.n4$b r10 = (com.google.android.gms.internal.measurement.n4.b) r10
            r10.B()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.d3.i(r11, r12, r14)
            int r2 = r14.a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.b4<?> r12 = r9.f7029d
            com.google.android.gms.internal.measurement.z3 r0 = r14.f7069d
            com.google.android.gms.internal.measurement.u5 r3 = r9.a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.c(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.n4$d r0 = (com.google.android.gms.internal.measurement.n4.d) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.d3.c(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.j6.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.measurement.d3.a(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.d3.i(r11, r4, r14)
            int r5 = r14.a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.d3.q(r11, r4, r14)
            java.lang.Object r2 = r14.f7068c
            com.google.android.gms.internal.measurement.h3 r2 = (com.google.android.gms.internal.measurement.h3) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.j6.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.d3.i(r11, r4, r14)
            int r12 = r14.a
            com.google.android.gms.internal.measurement.b4<?> r0 = r9.f7029d
            com.google.android.gms.internal.measurement.z3 r5 = r14.f7069d
            com.google.android.gms.internal.measurement.u5 r6 = r9.a
            java.lang.Object r0 = r0.c(r5, r6, r12)
            com.google.android.gms.internal.measurement.n4$d r0 = (com.google.android.gms.internal.measurement.n4.d) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.d3.a(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.c(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.zzfm r10 = com.google.android.gms.internal.measurement.zzfm.e()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.a6.h(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.c3):void");
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void i(T t, w7 w7Var) throws IOException {
        Iterator<Map.Entry<?, Object>> o = this.f7029d.b(t).o();
        while (o.hasNext()) {
            Map.Entry<?, Object> next = o.next();
            e4 e4Var = (e4) next.getKey();
            if (e4Var.c() == x7.MESSAGE && !e4Var.d() && !e4Var.e()) {
                if (next instanceof a5) {
                    w7Var.i(e4Var.a(), ((a5) next).a().d());
                } else {
                    w7Var.i(e4Var.a(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        d7<?, ?> d7Var = this.f7027b;
        d7Var.g(d7Var.f(t), w7Var);
    }
}