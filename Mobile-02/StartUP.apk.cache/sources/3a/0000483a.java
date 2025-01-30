package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class a extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<a> CREATOR = new h();
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f13173b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13174c;

    public a(String str, byte[] bArr, int i2) {
        this.a = str;
        this.f13173b = bArr;
        this.f13174c = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.b.f(parcel, 3, this.f13173b, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 4, this.f13174c);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}