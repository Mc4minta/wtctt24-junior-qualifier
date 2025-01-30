package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public final class d1 {

    /* renamed from: b  reason: collision with root package name */
    public static final d1 f17420b = new d1();
    private static final ThreadLocal<f0> a = new ThreadLocal<>();

    private d1() {
    }

    public final f0 a() {
        ThreadLocal<f0> threadLocal = a;
        f0 f0Var = threadLocal.get();
        if (f0Var != null) {
            return f0Var;
        }
        f0 a2 = i0.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void b() {
        a.set(null);
    }

    public final void c(f0 f0Var) {
        a.set(f0Var);
    }
}