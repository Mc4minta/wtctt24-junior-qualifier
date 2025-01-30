package e.g.a.e.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            if (SafeParcelReader.l(r) != 2) {
                SafeParcelReader.x(parcel, r);
            } else {
                str = SafeParcelReader.f(parcel, r);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new f(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i2) {
        return new f[i2];
    }
}