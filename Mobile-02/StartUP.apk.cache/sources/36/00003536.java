package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class o extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.measurement.internal.f6 f7273e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ bd f7274f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(bd bdVar, com.google.android.gms.measurement.internal.f6 f6Var) {
        super(bdVar);
        this.f7274f = bdVar;
        this.f7273e = f6Var;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000b */
    @Override // com.google.android.gms.internal.measurement.bd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 0
        L1:
            com.google.android.gms.internal.measurement.bd r1 = r4.f7274f
            java.util.List r1 = com.google.android.gms.internal.measurement.bd.K(r1)
            int r1 = r1.size()
            if (r0 >= r1) goto L32
            com.google.android.gms.measurement.internal.f6 r1 = r4.f7273e
            com.google.android.gms.internal.measurement.bd r2 = r4.f7274f
            java.util.List r2 = com.google.android.gms.internal.measurement.bd.K(r2)
            java.lang.Object r2 = r2.get(r0)
            android.util.Pair r2 = (android.util.Pair) r2
            java.lang.Object r2 = r2.first
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L2f
            com.google.android.gms.internal.measurement.bd r0 = r4.f7274f
            java.lang.String r0 = com.google.android.gms.internal.measurement.bd.w(r0)
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r0, r1)
            return
        L2f:
            int r0 = r0 + 1
            goto L1
        L32:
            com.google.android.gms.internal.measurement.bd$c r0 = new com.google.android.gms.internal.measurement.bd$c
            com.google.android.gms.measurement.internal.f6 r1 = r4.f7273e
            r0.<init>(r1)
            com.google.android.gms.internal.measurement.bd r1 = r4.f7274f
            java.util.List r1 = com.google.android.gms.internal.measurement.bd.K(r1)
            android.util.Pair r2 = new android.util.Pair
            com.google.android.gms.measurement.internal.f6 r3 = r4.f7273e
            r2.<init>(r3, r0)
            r1.add(r2)
            com.google.android.gms.internal.measurement.bd r1 = r4.f7274f
            com.google.android.gms.internal.measurement.h9 r1 = com.google.android.gms.internal.measurement.bd.C(r1)
            r1.registerOnMeasurementEventListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o.a():void");
    }
}