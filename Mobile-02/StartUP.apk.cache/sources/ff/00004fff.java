package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.TimeUnit;

/* compiled from: ImmediateThinScheduler.java */
/* loaded from: classes3.dex */
public final class e extends a0 {

    /* renamed from: b  reason: collision with root package name */
    public static final a0 f16653b = new e();

    /* renamed from: c  reason: collision with root package name */
    static final a0.c f16654c = new a();

    /* renamed from: d  reason: collision with root package name */
    static final h.c.k0.b f16655d;

    /* compiled from: ImmediateThinScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends a0.c {
        a() {
        }

        @Override // h.c.a0.c
        public h.c.k0.b b(Runnable runnable) {
            runnable.run();
            return e.f16655d;
        }

        @Override // h.c.a0.c
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // h.c.a0.c
        public h.c.k0.b d(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        @Override // h.c.k0.b
        public void dispose() {
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return false;
        }
    }

    static {
        h.c.k0.b b2 = h.c.k0.c.b();
        f16655d = b2;
        b2.dispose();
    }

    private e() {
    }

    @Override // h.c.a0
    public a0.c a() {
        return f16654c;
    }

    @Override // h.c.a0
    public h.c.k0.b c(Runnable runnable) {
        runnable.run();
        return f16655d;
    }

    @Override // h.c.a0
    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // h.c.a0
    public h.c.k0.b e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}