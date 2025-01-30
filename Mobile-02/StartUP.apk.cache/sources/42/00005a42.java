package kotlinx.coroutines;

import java.util.Objects;
import kotlin.c0.e;
import kotlin.c0.f;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class t extends kotlin.c0.a implements kotlin.c0.e {
    public static final a a = new a(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.c0.b<kotlin.c0.e, t> {

        /* compiled from: CoroutineDispatcher.kt */
        /* renamed from: kotlinx.coroutines.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0423a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<f.b, t> {
            public static final C0423a a = new C0423a();

            C0423a() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            /* renamed from: a */
            public final t invoke(f.b bVar) {
                if (!(bVar instanceof t)) {
                    bVar = null;
                }
                return (t) bVar;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
            super(kotlin.c0.e.o, C0423a.a);
        }
    }

    public t() {
        super(kotlin.c0.e.o);
    }

    public abstract void A(kotlin.c0.f fVar, Runnable runnable);

    public boolean G(kotlin.c0.f fVar) {
        return true;
    }

    @Override // kotlin.c0.e
    public void b(kotlin.c0.d<?> dVar) {
        Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        f<?> m = ((kotlinx.coroutines.internal.d) dVar).m();
        if (m != null) {
            m.s();
        }
    }

    @Override // kotlin.c0.e
    public final <T> kotlin.c0.d<T> c(kotlin.c0.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.d(this, dVar);
    }

    @Override // kotlin.c0.a, kotlin.c0.f.b, kotlin.c0.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // kotlin.c0.a, kotlin.c0.f
    public kotlin.c0.f minusKey(f.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    public String toString() {
        return y.a(this) + '@' + y.b(this);
    }
}