package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
public class s4 {
    protected volatile int a = -1;

    public static final void c(s4 s4Var, byte[] bArr, int i2, int i3) {
        try {
            m4 t = m4.t(bArr, 0, i3);
            s4Var.b(t);
            t.p();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public void b(m4 m4Var) throws IOException {
    }

    public final int d() {
        int e2 = e();
        this.a = e2;
        return e2;
    }

    protected int e() {
        return 0;
    }

    @Override // 
    /* renamed from: f */
    public s4 clone() throws CloneNotSupportedException {
        return (s4) super.clone();
    }

    public String toString() {
        return u4.a(this);
    }
}