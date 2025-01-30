package e.g.a.e.d.h;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d;

/* loaded from: classes2.dex */
public final class n extends com.google.android.gms.common.internal.h<h> {
    private final Context G;

    public n(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, d.a aVar, d.b bVar) {
        super(context, looper, 45, dVar, aVar, bVar);
        this.G = context;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String k() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return queryLocalInterface instanceof h ? (h) queryLocalInterface : new i(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int n() {
        return 12200000;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String q() {
        return "com.google.android.gms.safetynet.service.START";
    }
}