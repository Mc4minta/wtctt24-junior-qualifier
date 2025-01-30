package e.g.a.e.d.c;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class h {
    private static final ClassLoader a = h.class.getClassLoader();

    private h() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}