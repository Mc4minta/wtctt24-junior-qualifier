package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class p0<T> extends u {

    /* renamed from: b  reason: collision with root package name */
    protected final com.google.android.gms.tasks.h<T> f6128b;

    public p0(int i2, com.google.android.gms.tasks.h<T> hVar) {
        super(i2);
        this.f6128b = hVar;
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public void b(Status status) {
        this.f6128b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public void d(RuntimeException runtimeException) {
        this.f6128b.d(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final void f(f.a<?> aVar) throws DeadObjectException {
        Status a;
        Status a2;
        try {
            i(aVar);
        } catch (DeadObjectException e2) {
            a2 = g0.a(e2);
            b(a2);
            throw e2;
        } catch (RemoteException e3) {
            a = g0.a(e3);
            b(a);
        } catch (RuntimeException e4) {
            d(e4);
        }
    }

    protected abstract void i(f.a<?> aVar) throws RemoteException;
}