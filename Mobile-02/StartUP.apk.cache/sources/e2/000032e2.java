package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class q5 extends a implements p5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q5(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    @Override // com.google.android.gms.internal.clearcut.p5
    public final void K(n5 n5Var, e.g.a.e.c.f fVar) throws RemoteException {
        Parcel n = n();
        x0.b(n, n5Var);
        x0.c(n, fVar);
        p(1, n);
    }
}