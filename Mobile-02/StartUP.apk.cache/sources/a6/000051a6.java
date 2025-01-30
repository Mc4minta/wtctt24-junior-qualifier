package kotlin.c0;

import java.util.Objects;
import kotlin.c0.f;
import kotlin.jvm.internal.m;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes3.dex */
public interface e extends f.b {
    public static final b o = b.a;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <E extends f.b> E a(e eVar, f.c<E> key) {
            m.g(key, "key");
            if (key instanceof kotlin.c0.b) {
                kotlin.c0.b bVar = (kotlin.c0.b) key;
                if (bVar.a(eVar.getKey())) {
                    E e2 = (E) bVar.b(eVar);
                    if (e2 instanceof f.b) {
                        return e2;
                    }
                    return null;
                }
                return null;
            } else if (e.o == key) {
                Objects.requireNonNull(eVar, "null cannot be cast to non-null type E");
                return eVar;
            } else {
                return null;
            }
        }

        public static f b(e eVar, f.c<?> key) {
            m.g(key, "key");
            if (!(key instanceof kotlin.c0.b)) {
                return e.o == key ? g.a : eVar;
            }
            kotlin.c0.b bVar = (kotlin.c0.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : g.a;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class b implements f.c<e> {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    void b(d<?> dVar);

    <T> d<T> c(d<? super T> dVar);
}