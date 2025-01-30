package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.c0.f;
import kotlinx.coroutines.c1;

/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class s {
    private static final o a = new o("ZERO");

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.e0.c.p<Object, f.b, Object> f17509b = a.a;

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.e0.c.p<c1<?>, f.b, c1<?>> f17510c = b.a;

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.e0.c.p<v, f.b, v> f17511d = d.a;

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.e0.c.p<v, f.b, v> f17512e = c.a;

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.p<Object, f.b, Object> {
        public static final a a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        /* renamed from: a */
        public final Object invoke(Object obj, f.b bVar) {
            if (bVar instanceof c1) {
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                Integer num = (Integer) obj;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.p<c1<?>, f.b, c1<?>> {
        public static final b a = new b();

        b() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        /* renamed from: a */
        public final c1<?> invoke(c1<?> c1Var, f.b bVar) {
            if (c1Var != null) {
                return c1Var;
            }
            if (!(bVar instanceof c1)) {
                bVar = null;
            }
            return (c1) bVar;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.p<v, f.b, v> {
        public static final c a = new c();

        c() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        /* renamed from: a */
        public final v invoke(v vVar, f.b bVar) {
            if (bVar instanceof c1) {
                ((c1) bVar).m(vVar.b(), vVar.d());
            }
            return vVar;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.p<v, f.b, v> {
        public static final d a = new d();

        d() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        /* renamed from: a */
        public final v invoke(v vVar, f.b bVar) {
            if (bVar instanceof c1) {
                vVar.a(((c1) bVar).z(vVar.b()));
            }
            return vVar;
        }
    }

    public static final void a(kotlin.c0.f fVar, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof v) {
            ((v) obj).c();
            fVar.fold(obj, f17512e);
            return;
        }
        Object fold = fVar.fold(null, f17510c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((c1) fold).m(fVar, obj);
    }

    public static final Object b(kotlin.c0.f fVar) {
        Object fold = fVar.fold(0, f17509b);
        kotlin.jvm.internal.m.e(fold);
        return fold;
    }

    public static final Object c(kotlin.c0.f fVar, Object obj) {
        if (obj == null) {
            obj = b(fVar);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return fVar.fold(new v(fVar, ((Number) obj).intValue()), f17511d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((c1) obj).z(fVar);
    }
}