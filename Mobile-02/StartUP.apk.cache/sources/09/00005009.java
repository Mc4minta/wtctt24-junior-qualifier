package h.c.n0.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory.java */
/* loaded from: classes3.dex */
public final class k extends AtomicLong implements ThreadFactory {
    final String a;

    /* renamed from: b  reason: collision with root package name */
    final int f16681b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16682c;

    /* compiled from: RxThreadFactory.java */
    /* loaded from: classes3.dex */
    static final class a extends Thread implements j {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public k(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.a + '-' + incrementAndGet();
        Thread aVar = this.f16682c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f16681b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.a + "]";
    }

    public k(String str, int i2) {
        this(str, i2, false);
    }

    public k(String str, int i2, boolean z) {
        this.a = str;
        this.f16681b = i2;
        this.f16682c = z;
    }
}