package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.f;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class o0<A extends d<? extends com.google.android.gms.common.api.i, a.b>> extends g0 {

    /* renamed from: b  reason: collision with root package name */
    private final A f6127b;

    public o0(int i2, A a) {
        super(i2);
        this.f6127b = a;
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final void b(Status status) {
        this.f6127b.r(status);
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final void c(x0 x0Var, boolean z) {
        x0Var.b(this.f6127b, z);
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final void d(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f6127b.r(new Status(10, sb.toString()));
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final void f(f.a<?> aVar) throws DeadObjectException {
        try {
            this.f6127b.p(aVar.l());
        } catch (RuntimeException e2) {
            d(e2);
        }
    }
}