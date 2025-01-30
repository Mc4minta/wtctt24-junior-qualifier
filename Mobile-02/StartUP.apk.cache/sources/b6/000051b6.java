package kotlin.c0.i.a;

import java.io.Serializable;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlin.q;
import kotlin.x;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class a implements kotlin.c0.d<Object>, d, Serializable {
    private final kotlin.c0.d<Object> a;

    public a(kotlin.c0.d<Object> dVar) {
        this.a = dVar;
    }

    @Override // kotlin.c0.i.a.d
    public d a() {
        kotlin.c0.d<Object> dVar = this.a;
        if (!(dVar instanceof d)) {
            dVar = null;
        }
        return (d) dVar;
    }

    @Override // kotlin.c0.d
    public final void b(Object obj) {
        Object h2;
        Object c2;
        a aVar = this;
        while (true) {
            g.b(aVar);
            kotlin.c0.d<Object> dVar = aVar.a;
            m.e(dVar);
            try {
                h2 = aVar.h(obj);
                c2 = kotlin.c0.h.d.c();
            } catch (Throwable th) {
                p.a aVar2 = p.a;
                obj = p.a(q.a(th));
            }
            if (h2 == c2) {
                return;
            }
            p.a aVar3 = p.a;
            obj = p.a(h2);
            aVar.i();
            if (dVar instanceof a) {
                aVar = (a) dVar;
            } else {
                dVar.b(obj);
                return;
            }
        }
    }

    @Override // kotlin.c0.i.a.d
    public StackTraceElement d() {
        return f.d(this);
    }

    public kotlin.c0.d<x> f(Object obj, kotlin.c0.d<?> completion) {
        m.g(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final kotlin.c0.d<Object> g() {
        return this.a;
    }

    protected abstract Object h(Object obj);

    protected void i() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object d2 = d();
        if (d2 == null) {
            d2 = getClass().getName();
        }
        sb.append(d2);
        return sb.toString();
    }
}