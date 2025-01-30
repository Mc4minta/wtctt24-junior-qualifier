package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.n4;
import java.io.IOException;

/* loaded from: classes2.dex */
public class n4<M extends n4<M>> extends s4 {

    /* renamed from: b  reason: collision with root package name */
    protected p4 f6521b;

    @Override // com.google.android.gms.internal.clearcut.s4
    public void b(m4 m4Var) throws IOException {
        if (this.f6521b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f6521b.c(); i2++) {
            this.f6521b.d(i2).c(m4Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.s4
    public int e() {
        if (this.f6521b != null) {
            for (int i2 = 0; i2 < this.f6521b.c(); i2++) {
                this.f6521b.d(i2).d();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.s4
    public /* synthetic */ s4 f() throws CloneNotSupportedException {
        return (n4) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.s4
    /* renamed from: h */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        r4.h(this, m);
        return m;
    }
}