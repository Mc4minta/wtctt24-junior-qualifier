package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class f extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<f> CREATOR = new g();
    private final String a;

    public f(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}