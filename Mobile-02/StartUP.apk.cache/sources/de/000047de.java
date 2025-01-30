package e.g.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.t5;

/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        t5 t5Var = null;
        byte[] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[][] bArr2 = null;
        e.g.a.e.e.a[] aVarArr = null;
        boolean z = true;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 2:
                    t5Var = (t5) SafeParcelReader.e(parcel, r, t5.CREATOR);
                    break;
                case 3:
                    bArr = SafeParcelReader.b(parcel, r);
                    break;
                case 4:
                    iArr = SafeParcelReader.d(parcel, r);
                    break;
                case 5:
                    strArr = SafeParcelReader.g(parcel, r);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.d(parcel, r);
                    break;
                case 7:
                    bArr2 = SafeParcelReader.c(parcel, r);
                    break;
                case 8:
                    z = SafeParcelReader.m(parcel, r);
                    break;
                case 9:
                    aVarArr = (e.g.a.e.e.a[]) SafeParcelReader.i(parcel, r, e.g.a.e.e.a.CREATOR);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new f(t5Var, bArr, iArr, strArr, iArr2, bArr2, z, aVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i2) {
        return new f[i2];
    }
}