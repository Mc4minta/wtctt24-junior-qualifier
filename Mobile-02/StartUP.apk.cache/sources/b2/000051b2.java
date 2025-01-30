package kotlin.c0.h;

import java.util.Objects;
import kotlin.c0.f;
import kotlin.c0.i.a.g;
import kotlin.c0.i.a.i;
import kotlin.e0.c.p;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;
import kotlin.q;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes3.dex */
public class c {

    /* compiled from: IntrinsicsJvm.kt */
    /* loaded from: classes3.dex */
    public static final class a extends i {

        /* renamed from: b  reason: collision with root package name */
        private int f17255b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.c0.d f17256c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p f17257d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f17258e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlin.c0.d dVar, kotlin.c0.d dVar2, p pVar, Object obj) {
            super(dVar2);
            this.f17256c = dVar;
            this.f17257d = pVar;
            this.f17258e = obj;
        }

        @Override // kotlin.c0.i.a.a
        protected Object h(Object obj) {
            int i2 = this.f17255b;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f17255b = 2;
                    q.b(obj);
                    return obj;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f17255b = 1;
            q.b(obj);
            p pVar = this.f17257d;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((p) i0.f(pVar, 2)).invoke(this.f17258e, this);
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* loaded from: classes3.dex */
    public static final class b extends kotlin.c0.i.a.c {

        /* renamed from: d  reason: collision with root package name */
        private int f17259d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.c0.d f17260e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f f17261f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ p f17262g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Object f17263h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.c0.d dVar, f fVar, kotlin.c0.d dVar2, f fVar2, p pVar, Object obj) {
            super(dVar2, fVar2);
            this.f17260e = dVar;
            this.f17261f = fVar;
            this.f17262g = pVar;
            this.f17263h = obj;
        }

        @Override // kotlin.c0.i.a.a
        protected Object h(Object obj) {
            int i2 = this.f17259d;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f17259d = 2;
                    q.b(obj);
                    return obj;
                }
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f17259d = 1;
            q.b(obj);
            p pVar = this.f17262g;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((p) i0.f(pVar, 2)).invoke(this.f17263h, this);
        }
    }

    public static <R, T> kotlin.c0.d<x> a(p<? super R, ? super kotlin.c0.d<? super T>, ? extends Object> createCoroutineUnintercepted, R r, kotlin.c0.d<? super T> completion) {
        kotlin.c0.d<x> bVar;
        m.g(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        m.g(completion, "completion");
        kotlin.c0.d<?> a2 = g.a(completion);
        if (createCoroutineUnintercepted instanceof kotlin.c0.i.a.a) {
            return ((kotlin.c0.i.a.a) createCoroutineUnintercepted).f(r, a2);
        }
        f e2 = a2.e();
        if (e2 == kotlin.c0.g.a) {
            bVar = new a(a2, a2, createCoroutineUnintercepted, r);
        } else {
            bVar = new b(a2, e2, a2, e2, createCoroutineUnintercepted, r);
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> kotlin.c0.d<T> b(kotlin.c0.d<? super T> intercepted) {
        kotlin.c0.d<T> dVar;
        m.g(intercepted, "$this$intercepted");
        kotlin.c0.i.a.c cVar = !(intercepted instanceof kotlin.c0.i.a.c) ? null : intercepted;
        return (cVar == null || (dVar = (kotlin.c0.d<T>) cVar.j()) == null) ? intercepted : dVar;
    }
}