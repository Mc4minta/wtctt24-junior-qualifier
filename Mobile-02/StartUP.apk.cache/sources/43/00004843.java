package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        int i2 = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 2) {
                str = SafeParcelReader.f(parcel, r);
            } else if (l2 == 3) {
                bArr = SafeParcelReader.b(parcel, r);
            } else if (l2 != 4) {
                SafeParcelReader.x(parcel, r);
            } else {
                i2 = SafeParcelReader.t(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new a(str, bArr, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}