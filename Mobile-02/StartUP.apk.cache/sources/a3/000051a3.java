package kotlin.c0;

import java.io.Serializable;
import java.util.Objects;
import kotlin.c0.f;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class c implements f, Serializable {
    private final f a;

    /* renamed from: b  reason: collision with root package name */
    private final f.b f17251b;

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes3.dex */
    static final class a extends o implements p<String, f.b, String> {
        public static final a a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        /* renamed from: a */
        public final String invoke(String acc, f.b element) {
            m.g(acc, "acc");
            m.g(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(f left, f.b element) {
        m.g(left, "left");
        m.g(element, "element");
        this.a = left;
        this.f17251b = element;
    }

    private final boolean d(f.b bVar) {
        return m.c(get(bVar.getKey()), bVar);
    }

    private final boolean h(c cVar) {
        while (d(cVar.f17251b)) {
            f fVar = cVar.a;
            if (fVar instanceof c) {
                cVar = (c) fVar;
            } else {
                Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((f.b) fVar);
            }
        }
        return false;
    }

    private final int i() {
        int i2 = 2;
        c cVar = this;
        while (true) {
            f fVar = cVar.a;
            if (!(fVar instanceof c)) {
                fVar = null;
            }
            cVar = (c) fVar;
            if (cVar == null) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.i() != i() || !cVar.h(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.c0.f
    public <R> R fold(R r, p<? super R, ? super f.b, ? extends R> operation) {
        m.g(operation, "operation");
        return operation.invoke((Object) this.a.fold(r, operation), this.f17251b);
    }

    @Override // kotlin.c0.f
    public <E extends f.b> E get(f.c<E> key) {
        m.g(key, "key");
        c cVar = this;
        while (true) {
            E e2 = (E) cVar.f17251b.get(key);
            if (e2 != null) {
                return e2;
            }
            f fVar = cVar.a;
            if (fVar instanceof c) {
                cVar = (c) fVar;
            } else {
                return (E) fVar.get(key);
            }
        }
    }

    public int hashCode() {
        return this.a.hashCode() + this.f17251b.hashCode();
    }

    @Override // kotlin.c0.f
    public f minusKey(f.c<?> key) {
        m.g(key, "key");
        if (this.f17251b.get(key) != null) {
            return this.a;
        }
        f minusKey = this.a.minusKey(key);
        return minusKey == this.a ? this : minusKey == g.a ? this.f17251b : new c(minusKey, this.f17251b);
    }

    public String toString() {
        return "[" + ((String) fold("", a.a)) + "]";
    }
}