package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public final class b extends g0 {

    /* renamed from: g  reason: collision with root package name */
    private final Thread f17416g;

    public b(Thread thread) {
        this.f17416g = thread;
    }

    @Override // kotlinx.coroutines.h0
    protected Thread n0() {
        return this.f17416g;
    }
}