package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public abstract class s0 extends e.g.a.e.d.e.a implements t0 {
    public static t0 p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof t0) {
            return (t0) queryLocalInterface;
        }
        return new u0(iBinder);
    }
}