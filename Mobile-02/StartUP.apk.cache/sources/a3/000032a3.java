package com.google.android.gms.internal.clearcut;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import e.g.a.e.c.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h5 extends com.google.android.gms.common.api.internal.d<Status, l5> {
    private final e.g.a.e.c.f s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h5(e.g.a.e.c.f fVar, com.google.android.gms.common.api.d dVar) {
        super(e.g.a.e.c.a.f13097c, dVar);
        this.s = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ com.google.android.gms.common.api.i c(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.d
    protected final /* synthetic */ void n(l5 l5Var) throws RemoteException {
        l5 l5Var2 = l5Var;
        k5 k5Var = new k5(this);
        try {
            e.g.a.e.c.f fVar = this.s;
            a.c cVar = fVar.f13128k;
            if (cVar != null) {
                i5 i5Var = fVar.f13127j;
                if (i5Var.p.length == 0) {
                    i5Var.p = cVar.a();
                }
            }
            a.c cVar2 = fVar.f13129l;
            if (cVar2 != null) {
                i5 i5Var2 = fVar.f13127j;
                if (i5Var2.y.length == 0) {
                    i5Var2.y = cVar2.a();
                }
            }
            i5 i5Var3 = fVar.f13127j;
            int d2 = i5Var3.d();
            byte[] bArr = new byte[d2];
            s4.c(i5Var3, bArr, 0, d2);
            fVar.f13120b = bArr;
            ((p5) l5Var2.B()).K(k5Var, this.s);
        } catch (RuntimeException e2) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e2);
            r(new Status(10, "MessageProducer"));
        }
    }
}