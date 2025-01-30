package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.x;
import kotlinx.coroutines.y;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes3.dex */
public final class d<T> extends a0<T> implements kotlin.c0.i.a.d, kotlin.c0.d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17487d = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: e  reason: collision with root package name */
    public Object f17488e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.c0.i.a.d f17489f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f17490g;

    /* renamed from: h  reason: collision with root package name */
    public final kotlinx.coroutines.t f17491h;

    /* renamed from: j  reason: collision with root package name */
    public final kotlin.c0.d<T> f17492j;

    /* JADX WARN: Multi-variable type inference failed */
    public d(kotlinx.coroutines.t tVar, kotlin.c0.d<? super T> dVar) {
        super(-1);
        o oVar;
        this.f17491h = tVar;
        this.f17492j = dVar;
        oVar = e.a;
        this.f17488e = oVar;
        this.f17489f = (kotlin.c0.i.a.d) (dVar instanceof kotlin.c0.i.a.d ? dVar : null);
        this.f17490g = s.b(e());
        this._reusableCancellableContinuation = null;
    }

    @Override // kotlin.c0.i.a.d
    public kotlin.c0.i.a.d a() {
        return this.f17489f;
    }

    @Override // kotlin.c0.d
    public void b(Object obj) {
        kotlin.c0.f e2 = this.f17492j.e();
        Object c2 = kotlinx.coroutines.q.c(obj, null, 1, null);
        if (this.f17491h.G(e2)) {
            this.f17488e = c2;
            this.f17415c = 0;
            this.f17491h.A(e2, this);
            return;
        }
        x.a();
        f0 a = d1.f17420b.a();
        if (a.e0()) {
            this.f17488e = c2;
            this.f17415c = 0;
            a.O(this);
            return;
        }
        a.a0(true);
        try {
            kotlin.c0.f e3 = e();
            Object c3 = s.c(e3, this.f17490g);
            this.f17492j.b(obj);
            kotlin.x xVar = kotlin.x.a;
            s.a(e3, c3);
            do {
            } while (a.k0());
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // kotlin.c0.i.a.d
    public StackTraceElement d() {
        return null;
    }

    @Override // kotlin.c0.d
    public kotlin.c0.f e() {
        return this.f17492j.e();
    }

    @Override // kotlinx.coroutines.a0
    public void f(Object obj, Throwable th) {
        if (obj instanceof kotlinx.coroutines.o) {
            ((kotlinx.coroutines.o) obj).f17526b.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.a0
    public kotlin.c0.d<T> g() {
        return this;
    }

    @Override // kotlinx.coroutines.a0
    public Object k() {
        o oVar;
        o oVar2;
        Object obj = this.f17488e;
        if (x.a()) {
            oVar2 = e.a;
            if (!(obj != oVar2)) {
                throw new AssertionError();
            }
        }
        oVar = e.a;
        this.f17488e = oVar;
        return obj;
    }

    public final Throwable l(kotlinx.coroutines.e<?> eVar) {
        o oVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            oVar = e.f17493b;
            if (obj != oVar) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (f17487d.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f17487d.compareAndSet(this, oVar, eVar));
        return null;
    }

    public final kotlinx.coroutines.f<?> m() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof kotlinx.coroutines.f)) {
            obj = null;
        }
        return (kotlinx.coroutines.f) obj;
    }

    public final boolean n(kotlinx.coroutines.f<?> fVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof kotlinx.coroutines.f) || obj == fVar;
        }
        return false;
    }

    public final boolean o(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            o oVar = e.f17493b;
            if (kotlin.jvm.internal.m.c(obj, oVar)) {
                if (f17487d.compareAndSet(this, oVar, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f17487d.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f17491h + ", " + y.c(this.f17492j) + ']';
    }
}