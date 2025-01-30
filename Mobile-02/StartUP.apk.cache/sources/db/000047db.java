package e.g.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class d extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<d> CREATOR = new e();
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final long f13118b;

    /* renamed from: c  reason: collision with root package name */
    private final long f13119c;

    public d(boolean z, long j2, long j3) {
        this.a = z;
        this.f13118b = j2;
        this.f13119c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a == dVar.a && this.f13118b == dVar.f13118b && this.f13119c == dVar.f13119c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return r.b(Boolean.valueOf(this.a), Long.valueOf(this.f13118b), Long.valueOf(this.f13119c));
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.a + ",collectForDebugStartTimeMillis: " + this.f13118b + ",collectForDebugExpiryTimeMillis: " + this.f13119c + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 2, this.f13119c);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 3, this.f13118b);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }
}