package e.g.a.e.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class l extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<l> CREATOR = new k();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.common.b f13204b;

    /* renamed from: c  reason: collision with root package name */
    private final v f13205c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i2, com.google.android.gms.common.b bVar, v vVar) {
        this.a = i2;
        this.f13204b = bVar;
        this.f13205c = vVar;
    }

    public final com.google.android.gms.common.b i1() {
        return this.f13204b;
    }

    public final v j1() {
        return this.f13205c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 2, this.f13204b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, this.f13205c, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public l(int i2) {
        this(new com.google.android.gms.common.b(8, null), null);
    }

    private l(com.google.android.gms.common.b bVar, v vVar) {
        this(1, bVar, null);
    }
}