package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@KeepName
/* loaded from: classes2.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.i> extends com.google.android.gms.common.api.e<R> {
    static final ThreadLocal<Boolean> a = new w0();

    /* renamed from: b  reason: collision with root package name */
    private final Object f6056b;

    /* renamed from: c  reason: collision with root package name */
    private final a<R> f6057c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<com.google.android.gms.common.api.d> f6058d;

    /* renamed from: e  reason: collision with root package name */
    private final CountDownLatch f6059e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<e.a> f6060f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.gms.common.api.j<? super R> f6061g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<n0> f6062h;

    /* renamed from: i  reason: collision with root package name */
    private R f6063i;

    /* renamed from: j  reason: collision with root package name */
    private Status f6064j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f6065k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6066l;
    private boolean m;
    @KeepName
    private b mResultGuardian;
    private com.google.android.gms.common.internal.m n;
    private volatile l0<R> o;
    private boolean p;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static class a<R extends com.google.android.gms.common.api.i> extends e.g.a.e.d.d.d {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(com.google.android.gms.common.api.j<? super R> jVar, R r) {
            sendMessage(obtainMessage(1, new Pair(BasePendingResult.h(jVar), r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i2);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
                }
                ((BasePendingResult) message.obj).l(Status.f6035d);
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.j jVar = (com.google.android.gms.common.api.j) pair.first;
            com.google.android.gms.common.api.i iVar = (com.google.android.gms.common.api.i) pair.second;
            try {
                jVar.a(iVar);
            } catch (RuntimeException e2) {
                BasePendingResult.k(iVar);
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public final class b {
        private b() {
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.k(BasePendingResult.this.f6063i);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, w0 w0Var) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f6056b = new Object();
        this.f6059e = new CountDownLatch(1);
        this.f6060f = new ArrayList<>();
        this.f6062h = new AtomicReference<>();
        this.p = false;
        this.f6057c = new a<>(Looper.getMainLooper());
        this.f6058d = new WeakReference<>(null);
    }

    private final R d() {
        R r;
        synchronized (this.f6056b) {
            com.google.android.gms.common.internal.t.o(!this.f6065k, "Result has already been consumed.");
            com.google.android.gms.common.internal.t.o(e(), "Result is not ready.");
            r = this.f6063i;
            this.f6063i = null;
            this.f6061g = null;
            this.f6065k = true;
        }
        n0 andSet = this.f6062h.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <R extends com.google.android.gms.common.api.i> com.google.android.gms.common.api.j<R> h(com.google.android.gms.common.api.j<R> jVar) {
        return jVar;
    }

    private final void i(R r) {
        this.f6063i = r;
        this.n = null;
        this.f6059e.countDown();
        this.f6064j = this.f6063i.getStatus();
        if (this.f6066l) {
            this.f6061g = null;
        } else if (this.f6061g == null) {
            if (this.f6063i instanceof com.google.android.gms.common.api.g) {
                this.mResultGuardian = new b(this, null);
            }
        } else {
            this.f6057c.removeMessages(2);
            this.f6057c.a(this.f6061g, d());
        }
        ArrayList<e.a> arrayList = this.f6060f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            e.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f6064j);
        }
        this.f6060f.clear();
    }

    public static void k(com.google.android.gms.common.api.i iVar) {
        if (iVar instanceof com.google.android.gms.common.api.g) {
            try {
                ((com.google.android.gms.common.api.g) iVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(iVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final void a(e.a aVar) {
        com.google.android.gms.common.internal.t.b(aVar != null, "Callback cannot be null.");
        synchronized (this.f6056b) {
            if (e()) {
                aVar.a(this.f6064j);
            } else {
                this.f6060f.add(aVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final R b(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            com.google.android.gms.common.internal.t.j("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.t.o(!this.f6065k, "Result has already been consumed.");
        com.google.android.gms.common.internal.t.o(this.o == null, "Cannot await if then() has been called.");
        try {
            if (!this.f6059e.await(j2, timeUnit)) {
                l(Status.f6035d);
            }
        } catch (InterruptedException unused) {
            l(Status.f6033b);
        }
        com.google.android.gms.common.internal.t.o(e(), "Result is not ready.");
        return d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract R c(Status status);

    public final boolean e() {
        return this.f6059e.getCount() == 0;
    }

    public final void f(R r) {
        synchronized (this.f6056b) {
            if (!this.m && !this.f6066l) {
                e();
                boolean z = true;
                com.google.android.gms.common.internal.t.o(!e(), "Results have already been set");
                if (this.f6065k) {
                    z = false;
                }
                com.google.android.gms.common.internal.t.o(z, "Result has already been consumed");
                i(r);
                return;
            }
            k(r);
        }
    }

    public final void l(Status status) {
        synchronized (this.f6056b) {
            if (!e()) {
                f(c(status));
                this.m = true;
            }
        }
    }

    public final void m() {
        this.p = this.p || a.get().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePendingResult(com.google.android.gms.common.api.d dVar) {
        this.f6056b = new Object();
        this.f6059e = new CountDownLatch(1);
        this.f6060f = new ArrayList<>();
        this.f6062h = new AtomicReference<>();
        this.p = false;
        this.f6057c = new a<>(dVar != null ? dVar.d() : Looper.getMainLooper());
        this.f6058d = new WeakReference<>(dVar);
    }
}