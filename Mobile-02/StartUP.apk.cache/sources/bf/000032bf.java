package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d;

/* loaded from: classes2.dex */
public final class l5 extends com.google.android.gms.common.internal.h<p5> {
    public l5(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, d.a aVar, d.b bVar) {
        super(context, looper, 40, dVar, aVar, bVar);
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String k() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return queryLocalInterface instanceof p5 ? (p5) queryLocalInterface : new q5(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int n() {
        return 11925000;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String q() {
        return "com.google.android.gms.clearcut.service.START";
    }
}