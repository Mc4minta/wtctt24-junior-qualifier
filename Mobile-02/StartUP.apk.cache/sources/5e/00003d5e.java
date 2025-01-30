package com.google.zxing.u.d;

import java.util.Formatter;

/* compiled from: DetectionResultColumn.java */
/* loaded from: classes2.dex */
class g {
    private final c a;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f10102b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.a = new c(cVar);
        this.f10102b = new d[(cVar.f() - cVar.h()) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d b(int i2) {
        return this.f10102b[e(i2)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d c(int i2) {
        d dVar;
        d dVar2;
        d b2 = b(i2);
        if (b2 != null) {
            return b2;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int e2 = e(i2) - i3;
            if (e2 >= 0 && (dVar2 = this.f10102b[e2]) != null) {
                return dVar2;
            }
            int e3 = e(i2) + i3;
            d[] dVarArr = this.f10102b;
            if (e3 < dVarArr.length && (dVar = dVarArr[e3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d[] d() {
        return this.f10102b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e(int i2) {
        return i2 - this.a.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i2, d dVar) {
        this.f10102b[e(i2)] = dVar;
    }

    public String toString() {
        d[] dVarArr;
        Formatter formatter = new Formatter();
        try {
            int i2 = 0;
            for (d dVar : this.f10102b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i2++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}