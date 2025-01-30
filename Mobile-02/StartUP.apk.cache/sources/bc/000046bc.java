package e.f.j.l;

/* compiled from: ThumbnailSizeChecker.java */
/* loaded from: classes2.dex */
public final class x0 {
    public static int a(int i2) {
        return (int) (i2 * 1.3333334f);
    }

    public static boolean b(int i2, int i3, com.facebook.imagepipeline.common.e eVar) {
        return eVar == null ? ((float) a(i2)) >= 2048.0f && a(i3) >= 2048 : a(i2) >= eVar.a && a(i3) >= eVar.f4529b;
    }

    public static boolean c(e.f.j.i.d dVar, com.facebook.imagepipeline.common.e eVar) {
        if (dVar == null) {
            return false;
        }
        int A = dVar.A();
        if (A != 90 && A != 270) {
            return b(dVar.N(), dVar.n(), eVar);
        }
        return b(dVar.n(), dVar.N(), eVar);
    }
}