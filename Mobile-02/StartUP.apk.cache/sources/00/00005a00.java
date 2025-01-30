package kotlinx.coroutines.i1;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.r;

/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class l {
    public static final long a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f17475b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f17476c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f17477d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f17478e;

    /* renamed from: f  reason: collision with root package name */
    public static m f17479f;

    static {
        long e2;
        int d2;
        int b2;
        int d3;
        int f2;
        int d4;
        long e3;
        e2 = r.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        a = e2;
        d2 = r.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f17475b = d2;
        b2 = kotlin.i0.f.b(p.a(), 2);
        d3 = r.d("kotlinx.coroutines.scheduler.core.pool.size", b2, 1, 0, 8, null);
        f17476c = d3;
        f2 = kotlin.i0.f.f(p.a() * 128, d3, 2097150);
        d4 = r.d("kotlinx.coroutines.scheduler.max.pool.size", f2, 0, 2097150, 4, null);
        f17477d = d4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e3 = r.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f17478e = timeUnit.toNanos(e3);
        f17479f = g.a;
    }
}