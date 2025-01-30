package e.g.a.e.d.a;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class c {
    private static final ClassLoader a = c.class.getClassLoader();

    private c() {
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}