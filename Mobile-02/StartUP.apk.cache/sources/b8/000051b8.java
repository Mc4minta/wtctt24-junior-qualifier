package kotlin.c0.i.a;

import kotlin.c0.f;
import kotlin.jvm.internal.m;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private transient kotlin.c0.d<Object> f17264b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.c0.f f17265c;

    public c(kotlin.c0.d<Object> dVar, kotlin.c0.f fVar) {
        super(dVar);
        this.f17265c = fVar;
    }

    @Override // kotlin.c0.d
    public kotlin.c0.f e() {
        kotlin.c0.f fVar = this.f17265c;
        m.e(fVar);
        return fVar;
    }

    @Override // kotlin.c0.i.a.a
    protected void i() {
        kotlin.c0.d<?> dVar = this.f17264b;
        if (dVar != null && dVar != this) {
            f.b bVar = e().get(kotlin.c0.e.o);
            m.e(bVar);
            ((kotlin.c0.e) bVar).b(dVar);
        }
        this.f17264b = b.a;
    }

    public final kotlin.c0.d<Object> j() {
        kotlin.c0.d<Object> dVar = this.f17264b;
        if (dVar == null) {
            kotlin.c0.e eVar = (kotlin.c0.e) e().get(kotlin.c0.e.o);
            if (eVar == null || (dVar = eVar.c(this)) == null) {
                dVar = this;
            }
            this.f17264b = dVar;
        }
        return dVar;
    }

    public c(kotlin.c0.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.e() : null);
    }
}