package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class j5 extends n4<j5> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static volatile j5[] f6472c;

    /* renamed from: d  reason: collision with root package name */
    private String f6473d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f6474e = "";

    public j5() {
        this.f6521b = null;
        this.a = -1;
    }

    public static j5[] i() {
        if (f6472c == null) {
            synchronized (r4.f6551c) {
                if (f6472c == null) {
                    f6472c = new j5[0];
                }
            }
        }
        return f6472c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    /* renamed from: k */
    public final j5 clone() {
        try {
            return (j5) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final void b(m4 m4Var) throws IOException {
        String str = this.f6473d;
        if (str != null && !str.equals("")) {
            m4Var.c(1, this.f6473d);
        }
        String str2 = this.f6474e;
        if (str2 != null && !str2.equals("")) {
            m4Var.c(2, this.f6474e);
        }
        super.b(m4Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final int e() {
        int e2 = super.e();
        String str = this.f6473d;
        if (str != null && !str.equals("")) {
            e2 += m4.h(1, this.f6473d);
        }
        String str2 = this.f6474e;
        return (str2 == null || str2.equals("")) ? e2 : e2 + m4.h(2, this.f6474e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j5) {
            j5 j5Var = (j5) obj;
            String str = this.f6473d;
            if (str == null) {
                if (j5Var.f6473d != null) {
                    return false;
                }
            } else if (!str.equals(j5Var.f6473d)) {
                return false;
            }
            String str2 = this.f6474e;
            if (str2 == null) {
                if (j5Var.f6474e != null) {
                    return false;
                }
            } else if (!str2.equals(j5Var.f6474e)) {
                return false;
            }
            p4 p4Var = this.f6521b;
            if (p4Var == null || p4Var.b()) {
                p4 p4Var2 = j5Var.f6521b;
                return p4Var2 == null || p4Var2.b();
            }
            return this.f6521b.equals(j5Var.f6521b);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final /* synthetic */ s4 f() throws CloneNotSupportedException {
        return (j5) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.n4
    public final /* synthetic */ j5 h() throws CloneNotSupportedException {
        return (j5) clone();
    }

    public final int hashCode() {
        int hashCode = (j5.class.getName().hashCode() + 527) * 31;
        String str = this.f6473d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f6474e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        p4 p4Var = this.f6521b;
        if (p4Var != null && !p4Var.b()) {
            i2 = this.f6521b.hashCode();
        }
        return hashCode3 + i2;
    }
}