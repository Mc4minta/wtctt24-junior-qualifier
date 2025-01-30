package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class h extends a0 {

    /* renamed from: b  reason: collision with root package name */
    private static final k f16678b = new k("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f16679c;

    public h() {
        this(f16678b);
    }

    @Override // h.c.a0
    public a0.c a() {
        return new i(this.f16679c);
    }

    public h(ThreadFactory threadFactory) {
        this.f16679c = threadFactory;
    }
}