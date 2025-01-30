package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
final class c implements Parcelable.Creator<Trace> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Trace createFromParcel(Parcel parcel) {
        return new Trace(parcel, true, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Trace[] newArray(int i2) {
        return new Trace[i2];
    }
}