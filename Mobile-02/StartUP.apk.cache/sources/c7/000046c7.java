package e.f.j.m;

/* compiled from: FrescoSystrace.java */
/* loaded from: classes2.dex */
public class b {
    public static final InterfaceC0281b a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f12803b = null;

    /* compiled from: FrescoSystrace.java */
    /* renamed from: e.f.j.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0281b {
    }

    /* compiled from: FrescoSystrace.java */
    /* loaded from: classes2.dex */
    private static final class c implements InterfaceC0281b {
        private c() {
        }
    }

    /* compiled from: FrescoSystrace.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(String str);

        void b();

        boolean c();
    }

    private b() {
    }

    public static void a(String str) {
        c().a(str);
    }

    public static void b() {
        c().b();
    }

    private static d c() {
        if (f12803b == null) {
            synchronized (b.class) {
                if (f12803b == null) {
                    f12803b = new e.f.j.m.a();
                }
            }
        }
        return f12803b;
    }

    public static boolean d() {
        return c().c();
    }
}