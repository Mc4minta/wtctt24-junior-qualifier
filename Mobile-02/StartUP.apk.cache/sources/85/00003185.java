package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.i;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class d<R extends com.google.android.gms.common.api.i, A extends a.b> extends BasePendingResult<R> {
    private final a.c<A> q;
    private final com.google.android.gms.common.api.a<?> r;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(com.google.android.gms.common.api.a<?> aVar, com.google.android.gms.common.api.d dVar) {
        super((com.google.android.gms.common.api.d) com.google.android.gms.common.internal.t.l(dVar, "GoogleApiClient must not be null"));
        com.google.android.gms.common.internal.t.l(aVar, "Api must not be null");
        this.q = (a.c<A>) aVar.a();
        this.r = aVar;
    }

    private void q(RemoteException remoteException) {
        r(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void n(A a) throws RemoteException;

    protected void o(R r) {
    }

    public final void p(A a) throws DeadObjectException {
        if (a instanceof com.google.android.gms.common.internal.w) {
            a = ((com.google.android.gms.common.internal.w) a).m0();
        }
        try {
            n(a);
        } catch (DeadObjectException e2) {
            q(e2);
            throw e2;
        } catch (RemoteException e3) {
            q(e3);
        }
    }

    public final void r(Status status) {
        com.google.android.gms.common.internal.t.b(!status.l1(), "Failed result must not be success");
        R c2 = c(status);
        f(c2);
        o(c2);
    }
}