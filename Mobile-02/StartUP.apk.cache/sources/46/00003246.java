package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.r0;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class x extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<x> CREATOR = new a0();
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final r f6343b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6344c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6345d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, IBinder iBinder, boolean z, boolean z2) {
        this.a = str;
        this.f6343b = i1(iBinder);
        this.f6344c = z;
        this.f6345d = z2;
    }

    private static r i1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            com.google.android.gms.dynamic.a b2 = r0.p(iBinder).b();
            byte[] bArr = b2 == null ? null : (byte[]) com.google.android.gms.dynamic.b.q(b2);
            if (bArr != null) {
                return new u(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder asBinder;
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 1, this.a, false);
        r rVar = this.f6343b;
        if (rVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = rVar.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.b.k(parcel, 2, asBinder, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, this.f6344c);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, this.f6345d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, r rVar, boolean z, boolean z2) {
        this.a = str;
        this.f6343b = rVar;
        this.f6344c = z;
        this.f6345d = z2;
    }
}