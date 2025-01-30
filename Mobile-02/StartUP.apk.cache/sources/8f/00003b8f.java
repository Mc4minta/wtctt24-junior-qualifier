package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
final class a implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
        return new b(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}