package e.a.a;

/* compiled from: L.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11493b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f11494c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f11495d;

    /* renamed from: e  reason: collision with root package name */
    private static int f11496e;

    /* renamed from: f  reason: collision with root package name */
    private static int f11497f;

    public static void a(String str) {
        if (f11493b) {
            int i2 = f11496e;
            if (i2 == 20) {
                f11497f++;
                return;
            }
            f11494c[i2] = str;
            f11495d[i2] = System.nanoTime();
            androidx.core.os.f.a(str);
            f11496e++;
        }
    }

    public static float b(String str) {
        int i2 = f11497f;
        if (i2 > 0) {
            f11497f = i2 - 1;
            return 0.0f;
        } else if (f11493b) {
            int i3 = f11496e - 1;
            f11496e = i3;
            if (i3 != -1) {
                if (str.equals(f11494c[i3])) {
                    androidx.core.os.f.b();
                    return ((float) (System.nanoTime() - f11495d[f11496e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f11494c[f11496e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}