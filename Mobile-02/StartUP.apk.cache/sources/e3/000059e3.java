package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class f0 extends t {

    /* renamed from: b  reason: collision with root package name */
    private long f17425b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17426c;

    /* renamed from: d  reason: collision with root package name */
    private kotlinx.coroutines.internal.a<a0<?>> f17427d;

    private final long N(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public static /* synthetic */ void d0(f0 f0Var, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            f0Var.a0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void K(boolean z) {
        long N = this.f17425b - N(z);
        this.f17425b = N;
        if (N > 0) {
            return;
        }
        if (x.a()) {
            if (!(this.f17425b == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f17426c) {
            shutdown();
        }
    }

    public final void O(a0<?> a0Var) {
        kotlinx.coroutines.internal.a<a0<?>> aVar = this.f17427d;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f17427d = aVar;
        }
        aVar.a(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long V() {
        kotlinx.coroutines.internal.a<a0<?>> aVar = this.f17427d;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void a0(boolean z) {
        this.f17425b += N(z);
        if (z) {
            return;
        }
        this.f17426c = true;
    }

    public final boolean e0() {
        return this.f17425b >= N(true);
    }

    public final boolean g0() {
        kotlinx.coroutines.internal.a<a0<?>> aVar = this.f17427d;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean k0() {
        a0<?> d2;
        kotlinx.coroutines.internal.a<a0<?>> aVar = this.f17427d;
        if (aVar == null || (d2 = aVar.d()) == null) {
            return false;
        }
        d2.run();
        return true;
    }

    protected void shutdown() {
    }
}