package e.g.a.e.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            int l2 = SafeParcelReader.l(r);
            if (l2 == 1) {
                i2 = SafeParcelReader.t(parcel, r);
            } else if (l2 == 2) {
                i3 = SafeParcelReader.t(parcel, r);
            } else if (l2 != 3) {
                SafeParcelReader.x(parcel, r);
            } else {
                intent = (Intent) SafeParcelReader.e(parcel, r, Intent.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, y);
        return new c(i2, i3, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i2) {
        return new c[i2];
    }
}