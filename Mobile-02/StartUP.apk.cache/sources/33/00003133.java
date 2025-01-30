package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.d;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class j extends com.google.android.gms.common.internal.h<v> {
    private final GoogleSignInOptions G;

    public j(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, GoogleSignInOptions googleSignInOptions, d.a aVar, d.b bVar) {
        super(context, looper, 91, dVar, aVar, bVar);
        GoogleSignInOptions.a aVar2;
        if (googleSignInOptions != null) {
            aVar2 = new GoogleSignInOptions.a(googleSignInOptions);
        } else {
            aVar2 = new GoogleSignInOptions.a();
        }
        aVar2.f(e.g.a.e.d.b.a.a());
        if (!dVar.d().isEmpty()) {
            for (Scope scope : dVar.d()) {
                aVar2.e(scope, new Scope[0]);
            }
        }
        this.G = aVar2.a();
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String k() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof v) {
            return (v) queryLocalInterface;
        }
        return new u(iBinder);
    }

    public final GoogleSignInOptions m0() {
        return this.G;
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int n() {
        return com.google.android.gms.common.h.a;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String q() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}