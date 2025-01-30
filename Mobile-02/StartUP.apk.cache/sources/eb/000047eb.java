package e.g.a.e.d.b;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.b.a;
import com.google.android.gms.common.api.d;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class g extends com.google.android.gms.common.internal.h<i> {
    private final a.C0136a G;

    public g(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, a.C0136a c0136a, d.a aVar, d.b bVar) {
        super(context, looper, 68, dVar, aVar, bVar);
        this.G = new a.C0136a.C0137a(c0136a == null ? a.C0136a.a : c0136a).a(a.a()).b();
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String k() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof i) {
            return (i) queryLocalInterface;
        }
        return new h(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int n() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String q() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Bundle y() {
        return this.G.a();
    }
}