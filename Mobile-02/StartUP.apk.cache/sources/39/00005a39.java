package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
final class p0 extends s0<r0> {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17527e = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.e0.c.l<Throwable, kotlin.x> f17528f;

    /* JADX WARN: Multi-variable type inference failed */
    public p0(r0 r0Var, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        super(r0Var);
        this.f17528f = lVar;
        this._invoked = 0;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        q(th);
        return kotlin.x.a;
    }

    @Override // kotlinx.coroutines.p
    public void q(Throwable th) {
        if (f17527e.compareAndSet(this, 0, 1)) {
            this.f17528f.invoke(th);
        }
    }
}