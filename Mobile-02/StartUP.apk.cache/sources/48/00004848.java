package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class m extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<m> CREATOR = new n();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13189b;

    public m(int i2, boolean z) {
        this.a = i2;
        this.f13189b = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 2, this.a);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, this.f13189b);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}