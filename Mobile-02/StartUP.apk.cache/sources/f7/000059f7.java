package kotlinx.coroutines.i1;

import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.t;

/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public final class c extends d {

    /* renamed from: h  reason: collision with root package name */
    private static final t f17459h;

    /* renamed from: j  reason: collision with root package name */
    public static final c f17460j;

    static {
        int b2;
        int d2;
        c cVar = new c();
        f17460j = cVar;
        b2 = kotlin.i0.f.b(64, p.a());
        d2 = r.d("kotlinx.coroutines.io.parallelism", b2, 0, 0, 12, null);
        f17459h = new f(cVar, d2, "Dispatchers.IO", 1);
    }

    private c() {
        super(0, 0, null, 7, null);
    }

    public final t O() {
        return f17459h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.t
    public String toString() {
        return "Dispatchers.Default";
    }
}