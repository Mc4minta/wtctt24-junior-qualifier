package e.g.a.e.d.c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.d;

/* loaded from: classes2.dex */
public final class b extends com.google.android.gms.common.internal.h<c> {
    private final Bundle G;

    public b(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, com.google.android.gms.auth.b.c cVar, d.a aVar, d.b bVar) {
        super(context, looper, 16, dVar, aVar, bVar);
        if (cVar == null) {
            this.G = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String k() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int n() {
        return com.google.android.gms.common.h.a;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final boolean p() {
        com.google.android.gms.common.internal.d h0 = h0();
        return (TextUtils.isEmpty(h0.b()) || h0.e(com.google.android.gms.auth.b.b.f6022c).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String q() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Bundle y() {
        return this.G;
    }
}