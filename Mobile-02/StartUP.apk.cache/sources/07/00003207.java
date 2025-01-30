package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import okhttp3.internal.http2.Settings;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private static void A(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        String hexString = Integer.toHexString(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(i3);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static Bundle a(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + w);
        return readBundle;
    }

    public static byte[] b(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + w);
        return createByteArray;
    }

    public static byte[][] c(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + w);
        return bArr;
    }

    public static int[] d(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + w);
        return createIntArray;
    }

    public static <T extends Parcelable> T e(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + w);
        return createFromParcel;
    }

    public static String f(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + w);
        return readString;
    }

    public static String[] g(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + w);
        return createStringArray;
    }

    public static ArrayList<String> h(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + w);
        return createStringArrayList;
    }

    public static <T> T[] i(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + w);
        return tArr;
    }

    public static <T> ArrayList<T> j(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + w);
        return createTypedArrayList;
    }

    public static void k(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new ParseException(sb.toString(), parcel);
    }

    public static int l(int i2) {
        return i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public static boolean m(Parcel parcel, int i2) {
        z(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean n(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        if (w == 0) {
            return null;
        }
        A(parcel, i2, w, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static Double o(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        if (w == 0) {
            return null;
        }
        A(parcel, i2, w, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float p(Parcel parcel, int i2) {
        z(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float q(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        if (w == 0) {
            return null;
        }
        A(parcel, i2, w, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int r(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder s(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (w == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + w);
        return readStrongBinder;
    }

    public static int t(Parcel parcel, int i2) {
        z(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long u(Parcel parcel, int i2) {
        z(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long v(Parcel parcel, int i2) {
        int w = w(parcel, i2);
        if (w == 0) {
            return null;
        }
        A(parcel, i2, w, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int w(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (i2 >> 16) & Settings.DEFAULT_INITIAL_WINDOW_SIZE : parcel.readInt();
    }

    public static void x(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + w(parcel, i2));
    }

    public static int y(Parcel parcel) {
        int r = r(parcel);
        int w = w(parcel, r);
        int dataPosition = parcel.dataPosition();
        if (l(r) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(r));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = w + dataPosition;
        if (i2 < dataPosition || i2 > parcel.dataSize()) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i2);
            throw new ParseException(sb.toString(), parcel);
        }
        return i2;
    }

    private static void z(Parcel parcel, int i2, int i3) {
        int w = w(parcel, i2);
        if (w == i3) {
            return;
        }
        String hexString = Integer.toHexString(w);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(w);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }
}