package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
final class u implements Parcelable.Creator<r> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r createFromParcel(Parcel parcel) {
        return new r(parcel, (u) null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r[] newArray(int i2) {
        return new r[i2];
    }
}