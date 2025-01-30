package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1509b = versionedParcel.p(iconCompat.f1509b, 1);
        iconCompat.f1511d = versionedParcel.j(iconCompat.f1511d, 2);
        iconCompat.f1512e = versionedParcel.r(iconCompat.f1512e, 3);
        iconCompat.f1513f = versionedParcel.p(iconCompat.f1513f, 4);
        iconCompat.f1514g = versionedParcel.p(iconCompat.f1514g, 5);
        iconCompat.f1515h = (ColorStateList) versionedParcel.r(iconCompat.f1515h, 6);
        iconCompat.f1517j = versionedParcel.t(iconCompat.f1517j, 7);
        iconCompat.f1518k = versionedParcel.t(iconCompat.f1518k, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.o(versionedParcel.f());
        int i2 = iconCompat.f1509b;
        if (-1 != i2) {
            versionedParcel.F(i2, 1);
        }
        byte[] bArr = iconCompat.f1511d;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1512e;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i3 = iconCompat.f1513f;
        if (i3 != 0) {
            versionedParcel.F(i3, 4);
        }
        int i4 = iconCompat.f1514g;
        if (i4 != 0) {
            versionedParcel.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f1515h;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f1517j;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f1518k;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}