package h.c.p0;

import h.c.n0.j.s;
import h.c.p0.a;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: BaseTestConsumer.java */
/* loaded from: classes3.dex */
public abstract class a<T, U extends a<T, U>> implements h.c.k0.b {

    /* renamed from: d  reason: collision with root package name */
    protected long f16781d;

    /* renamed from: e  reason: collision with root package name */
    protected Thread f16782e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f16783f;

    /* renamed from: g  reason: collision with root package name */
    protected int f16784g;

    /* renamed from: h  reason: collision with root package name */
    protected int f16785h;

    /* renamed from: b  reason: collision with root package name */
    protected final List<T> f16779b = new s();

    /* renamed from: c  reason: collision with root package name */
    protected final List<Throwable> f16780c = new s();
    protected final CountDownLatch a = new CountDownLatch(1);
}