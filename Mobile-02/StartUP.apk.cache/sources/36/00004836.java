package e.g.a.e.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int y = SafeParcelReader.y(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        while (parcel.dataPosition() < y) {
            int r = SafeParcelReader.r(parcel);
            switch (SafeParcelReader.l(r)) {
                case 2:
                    str = SafeParcelReader.f(parcel, r);
                    break;
                case 3:
                    bArr = SafeParcelReader.b(parcel, r);
                    break;
                case 4:
                    bArr2 = SafeParcelReader.c(parcel, r);
                    break;
                case 5:
                    bArr3 = SafeParcelReader.c(parcel, r);
                    break;
                case 6:
                    bArr4 = SafeParcelReader.c(parcel, r);
                    break;
                case 7:
                    bArr5 = SafeParcelReader.c(parcel, r);
                    break;
                case 8:
                    iArr = SafeParcelReader.d(parcel, r);
                    break;
                case 9:
                    bArr6 = SafeParcelReader.c(parcel, r);
                    break;
                default:
                    SafeParcelReader.x(parcel, r);
                    break;
            }
        }
        SafeParcelReader.k(parcel, y);
        return new a(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}