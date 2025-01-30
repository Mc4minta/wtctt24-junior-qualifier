package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class i extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<i> CREATOR = new j();
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final a[] f13186b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13187c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f13188d;

    public i(long j2, a[] aVarArr, int i2, boolean z) {
        this.a = j2;
        this.f13186b = aVarArr;
        this.f13188d = z;
        if (z) {
            this.f13187c = i2;
        } else {
            this.f13187c = -1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 2, this.a);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 3, this.f13186b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 4, this.f13187c);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 5, this.f13188d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}