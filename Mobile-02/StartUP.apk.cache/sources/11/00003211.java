package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class w<T extends IInterface> extends h<T> {
    private final a.h<T> G;

    @Override // com.google.android.gms.common.internal.c
    protected void I(int i2, T t) {
        this.G.h(i2, t);
    }

    @Override // com.google.android.gms.common.internal.c
    protected String k() {
        return this.G.k();
    }

    @Override // com.google.android.gms.common.internal.c
    protected T l(IBinder iBinder) {
        return this.G.l(iBinder);
    }

    public a.h<T> m0() {
        return this.G;
    }

    @Override // com.google.android.gms.common.internal.c
    protected String q() {
        return this.G.q();
    }
}