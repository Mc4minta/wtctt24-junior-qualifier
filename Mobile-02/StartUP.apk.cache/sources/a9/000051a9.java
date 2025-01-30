package kotlin.c0;

import kotlin.c0.e;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.c0.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0414a extends o implements p<f, b, f> {
            public static final C0414a a = new C0414a();

            C0414a() {
                super(2);
            }

            @Override // kotlin.e0.c.p
            /* renamed from: a */
            public final f invoke(f acc, b element) {
                kotlin.c0.c cVar;
                m.g(acc, "acc");
                m.g(element, "element");
                f minusKey = acc.minusKey(element.getKey());
                g gVar = g.a;
                if (minusKey == gVar) {
                    return element;
                }
                e.b bVar = e.o;
                e eVar = (e) minusKey.get(bVar);
                if (eVar == null) {
                    cVar = new kotlin.c0.c(minusKey, element);
                } else {
                    f minusKey2 = minusKey.minusKey(bVar);
                    if (minusKey2 == gVar) {
                        return new kotlin.c0.c(element, eVar);
                    }
                    cVar = new kotlin.c0.c(new kotlin.c0.c(minusKey2, element), eVar);
                }
                return cVar;
            }
        }

        public static f a(f fVar, f context) {
            m.g(context, "context");
            return context == g.a ? fVar : (f) context.fold(fVar, C0414a.a);
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface b extends f {

        /* compiled from: CoroutineContext.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            public static <R> R a(b bVar, R r, p<? super R, ? super b, ? extends R> operation) {
                m.g(operation, "operation");
                return operation.invoke(r, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                m.g(key, "key");
                if (m.c(bVar.getKey(), key)) {
                    return bVar;
                }
                return null;
            }

            public static f c(b bVar, c<?> key) {
                m.g(key, "key");
                return m.c(bVar.getKey(), key) ? g.a : bVar;
            }

            public static f d(b bVar, f context) {
                m.g(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // kotlin.c0.f
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);
}