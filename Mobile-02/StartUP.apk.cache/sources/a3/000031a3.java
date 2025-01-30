package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class q0 extends p0<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    private final j<?> f6130c;

    public q0(j<?> jVar, com.google.android.gms.tasks.h<Boolean> hVar) {
        super(4, hVar);
        this.f6130c = jVar;
    }

    @Override // com.google.android.gms.common.api.internal.p0, com.google.android.gms.common.api.internal.g0
    public final /* bridge */ /* synthetic */ void b(Status status) {
        super.b(status);
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final /* bridge */ /* synthetic */ void c(x0 x0Var, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.p0, com.google.android.gms.common.api.internal.g0
    public final /* bridge */ /* synthetic */ void d(RuntimeException runtimeException) {
        super.d(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.u
    public final com.google.android.gms.common.d[] g(f.a<?> aVar) {
        if (aVar.x().get(this.f6130c) == null) {
            return null;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.u
    public final boolean h(f.a<?> aVar) {
        if (aVar.x().get(this.f6130c) == null) {
            return false;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void i(f.a<?> aVar) throws RemoteException {
        if (aVar.x().remove(this.f6130c) == null) {
            this.f6128b.e(Boolean.FALSE);
        } else {
            aVar.l();
            throw null;
        }
    }
}