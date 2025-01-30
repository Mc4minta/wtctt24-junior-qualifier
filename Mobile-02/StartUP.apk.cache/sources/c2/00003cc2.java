package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: UnknownFieldSetLite.java */
/* loaded from: classes2.dex */
public final class v {
    private static final v a = new v(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    private int f9752b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f9753c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f9754d;

    /* renamed from: e  reason: collision with root package name */
    private int f9755e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9756f;

    private v() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i2 = this.f9752b;
        int[] iArr = this.f9753c;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.f9753c = Arrays.copyOf(iArr, i3);
            this.f9754d = Arrays.copyOf(this.f9754d, i3);
        }
    }

    public static v c() {
        return a;
    }

    private v f(f fVar) throws IOException {
        int z;
        do {
            z = fVar.z();
            if (z == 0) {
                break;
            }
        } while (e(z, fVar));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v g(v vVar, v vVar2) {
        int i2 = vVar.f9752b + vVar2.f9752b;
        int[] copyOf = Arrays.copyOf(vVar.f9753c, i2);
        System.arraycopy(vVar2.f9753c, 0, copyOf, vVar.f9752b, vVar2.f9752b);
        Object[] copyOf2 = Arrays.copyOf(vVar.f9754d, i2);
        System.arraycopy(vVar2.f9754d, 0, copyOf2, vVar.f9752b, vVar2.f9752b);
        return new v(i2, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v h() {
        return new v();
    }

    private void j(int i2, Object obj) {
        b();
        int[] iArr = this.f9753c;
        int i3 = this.f9752b;
        iArr[i3] = i2;
        this.f9754d[i3] = obj;
        this.f9752b = i3 + 1;
    }

    void a() {
        if (!this.f9756f) {
            throw new UnsupportedOperationException();
        }
    }

    public void d() {
        this.f9756f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(int i2, f fVar) throws IOException {
        a();
        int a2 = y.a(i2);
        int b2 = y.b(i2);
        if (b2 == 0) {
            j(i2, Long.valueOf(fVar.o()));
            return true;
        } else if (b2 == 1) {
            j(i2, Long.valueOf(fVar.m()));
            return true;
        } else if (b2 == 2) {
            j(i2, fVar.j());
            return true;
        } else if (b2 == 3) {
            v vVar = new v();
            vVar.f(fVar);
            fVar.a(y.c(a2, 4));
            j(i2, vVar);
            return true;
        } else if (b2 != 4) {
            if (b2 == 5) {
                j(i2, Integer.valueOf(fVar.l()));
                return true;
            }
            throw InvalidProtocolBufferException.d();
        } else {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof v)) {
            v vVar = (v) obj;
            return this.f9752b == vVar.f9752b && Arrays.equals(this.f9753c, vVar.f9753c) && Arrays.deepEquals(this.f9754d, vVar.f9754d);
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f9752b) * 31) + Arrays.hashCode(this.f9753c)) * 31) + Arrays.deepHashCode(this.f9754d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f9752b; i3++) {
            p.c(sb, i2, String.valueOf(y.a(this.f9753c[i3])), this.f9754d[i3]);
        }
    }

    private v(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f9755e = -1;
        this.f9752b = i2;
        this.f9753c = iArr;
        this.f9754d = objArr;
        this.f9756f = z;
    }
}