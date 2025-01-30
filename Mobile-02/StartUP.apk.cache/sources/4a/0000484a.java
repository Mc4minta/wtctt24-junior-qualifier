package e.g.a.e.f;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<b> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar, Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, bVar.l1(), false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, bVar.i1(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 4, bVar.j1(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 5, bVar.k1());
        com.google.android.gms.common.internal.safeparcel.b.f(parcel, 6, bVar.m1(), false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j2 = 0;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 2) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 3) {
                dataHolder = (DataHolder) SafeParcelReader.e(parcel, r, DataHolder.CREATOR);
            } else if (l2 == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.e(parcel, r, ParcelFileDescriptor.CREATOR);
            } else if (l2 == 5) {
                j2 = SafeParcelReader.u(parcel, r);
            } else if (l2 != 6) {
                SafeParcelReader.x(parcel, r);
            } else {
                bArr = SafeParcelReader.b(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new b(str, dataHolder, parcelFileDescriptor, j2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i2) {
        return new b[i2];
    }
}