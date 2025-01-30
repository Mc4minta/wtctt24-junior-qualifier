package e.a.a.w;

/* compiled from: LottieCompositionCache.java */
/* loaded from: classes.dex */
public class g {
    private static final g a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final c.e.e<String, e.a.a.e> f11764b = new c.e.e<>(20);

    g() {
    }

    public static g b() {
        return a;
    }

    public e.a.a.e a(String str) {
        if (str == null) {
            return null;
        }
        return this.f11764b.c(str);
    }

    public void c(String str, e.a.a.e eVar) {
        if (str == null) {
            return;
        }
        this.f11764b.d(str, eVar);
    }
}