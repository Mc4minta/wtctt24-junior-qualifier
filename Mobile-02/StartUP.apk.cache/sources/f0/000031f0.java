package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class k0 implements Parcelable.Creator<g> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        com.google.android.gms.common.d[] dVarArr = null;
        com.google.android.gms.common.d[] dVarArr2 = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 1:
                    i2 = SafeParcelReader.t(parcel, r);
                    break;
                case 2:
                    i3 = SafeParcelReader.t(parcel, r);
                    break;
                case 3:
                    i4 = SafeParcelReader.t(parcel, r);
                    break;
                case 4:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 5:
                    iBinder = SafeParcelReader.s(parcel, r);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.i(parcel, r, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel, r);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.e(parcel, r, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
                case 10:
                    dVarArr = (com.google.android.gms.common.d[]) SafeParcelReader.i(parcel, r, com.google.android.gms.common.d.CREATOR);
                    break;
                case 11:
                    dVarArr2 = (com.google.android.gms.common.d[]) SafeParcelReader.i(parcel, r, com.google.android.gms.common.d.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 13:
                    i5 = SafeParcelReader.t(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new g(i2, i3, i4, str, iBinder, scopeArr, bundle, account, dVarArr, dVarArr2, z, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g[] newArray(int i2) {
        return new g[i2];
    }
}