package e.g.a.e.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.u;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class j extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<j> CREATOR = new i();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final u f13203b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i2, u uVar) {
        this.a = i2;
        this.f13203b = uVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 2, this.f13203b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    public j(u uVar) {
        this(1, uVar);
    }
}