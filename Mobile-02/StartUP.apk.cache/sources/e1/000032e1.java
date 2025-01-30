package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class q4 implements Cloneable {
    private o4<?, ?> a;

    /* renamed from: b  reason: collision with root package name */
    private Object f6542b;

    /* renamed from: c  reason: collision with root package name */
    private List<Object> f6543c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[d()];
        c(m4.q(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public final q4 clone() {
        Object clone;
        q4 q4Var = new q4();
        try {
            List<Object> list = this.f6543c;
            if (list == null) {
                q4Var.f6543c = null;
            } else {
                q4Var.f6543c.addAll(list);
            }
            Object obj = this.f6542b;
            if (obj != null) {
                if (obj instanceof s4) {
                    clone = (s4) ((s4) obj).clone();
                } else if (obj instanceof byte[]) {
                    clone = ((byte[]) obj).clone();
                } else {
                    int i2 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length];
                        q4Var.f6542b = bArr2;
                        while (i2 < bArr.length) {
                            bArr2[i2] = (byte[]) bArr[i2].clone();
                            i2++;
                        }
                    } else if (obj instanceof boolean[]) {
                        clone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        clone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        clone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        clone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        clone = ((double[]) obj).clone();
                    } else if (obj instanceof s4[]) {
                        s4[] s4VarArr = (s4[]) obj;
                        s4[] s4VarArr2 = new s4[s4VarArr.length];
                        q4Var.f6542b = s4VarArr2;
                        while (i2 < s4VarArr.length) {
                            s4VarArr2[i2] = (s4) s4VarArr[i2].clone();
                            i2++;
                        }
                    }
                }
                q4Var.f6542b = clone;
            }
            return q4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(m4 m4Var) throws IOException {
        if (this.f6542b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.f6543c.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d() {
        if (this.f6542b == null) {
            Iterator<Object> it = this.f6543c.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return 0;
        }
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof q4) {
            q4 q4Var = (q4) obj;
            if (this.f6542b != null && q4Var.f6542b != null) {
                if (this.a != q4Var.a) {
                    return false;
                }
                throw null;
            }
            List<Object> list2 = this.f6543c;
            if (list2 == null || (list = q4Var.f6543c) == null) {
                try {
                    return Arrays.equals(b(), q4Var.b());
                } catch (IOException e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return list2.equals(list);
        }
        return false;
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}