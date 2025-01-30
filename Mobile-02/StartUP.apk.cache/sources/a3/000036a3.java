package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class o extends com.google.android.gms.common.internal.safeparcel.a implements Iterable<String> {
    public static final Parcelable.Creator<o> CREATOR = new q();
    private final Bundle a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Bundle bundle) {
        this.a = bundle;
    }

    public final int i1() {
        return this.a.size();
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new n(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object k1(String str) {
        return this.a.get(str);
    }

    public final Bundle l1() {
        return new Bundle(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long m1(String str) {
        return Long.valueOf(this.a.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double n1(String str) {
        return Double.valueOf(this.a.getDouble(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String o1(String str) {
        return this.a.getString(str);
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 2, l1(), false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}