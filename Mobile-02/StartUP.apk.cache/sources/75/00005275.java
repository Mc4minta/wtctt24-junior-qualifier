package kotlin.k0;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public class n extends m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements h<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.k0.h
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.l<h<? extends T>, Iterator<? extends T>> {
        public static final b a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Iterator<T> invoke(h<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return (Iterator<? extends T>) it.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.l<T, T> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.l<T, T> {
        final /* synthetic */ kotlin.e0.c.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.e0.c.a aVar) {
            super(1);
            this.a = aVar;
        }

        @Override // kotlin.e0.c.l
        public final T invoke(T it) {
            kotlin.jvm.internal.m.g(it, "it");
            return (T) this.a.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class e<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.a<T> {
        final /* synthetic */ Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Object obj) {
            super(0);
            this.a = obj;
        }

        @Override // kotlin.e0.c.a
        public final T invoke() {
            return (T) this.a;
        }
    }

    public static <T> h<T> b(Iterator<? extends T> asSequence) {
        kotlin.jvm.internal.m.g(asSequence, "$this$asSequence");
        return c(new a(asSequence));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> h<T> c(h<? extends T> constrainOnce) {
        kotlin.jvm.internal.m.g(constrainOnce, "$this$constrainOnce");
        return constrainOnce instanceof kotlin.k0.a ? constrainOnce : new kotlin.k0.a(constrainOnce);
    }

    public static <T> h<T> d() {
        return kotlin.k0.d.a;
    }

    public static final <T> h<T> e(h<? extends h<? extends T>> flatten) {
        kotlin.jvm.internal.m.g(flatten, "$this$flatten");
        return f(flatten, b.a);
    }

    private static final <T, R> h<R> f(h<? extends T> hVar, kotlin.e0.c.l<? super T, ? extends Iterator<? extends R>> lVar) {
        if (hVar instanceof r) {
            return ((r) hVar).d(lVar);
        }
        return new f(hVar, c.a, lVar);
    }

    public static <T> h<T> g(T t, kotlin.e0.c.l<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.m.g(nextFunction, "nextFunction");
        if (t == null) {
            return kotlin.k0.d.a;
        }
        return new g(new e(t), nextFunction);
    }

    public static <T> h<T> h(kotlin.e0.c.a<? extends T> nextFunction) {
        kotlin.jvm.internal.m.g(nextFunction, "nextFunction");
        return c(new g(nextFunction, new d(nextFunction)));
    }

    public static final <T> h<T> i(T... elements) {
        h<T> s;
        h<T> d2;
        kotlin.jvm.internal.m.g(elements, "elements");
        if (elements.length == 0) {
            d2 = d();
            return d2;
        }
        s = kotlin.a0.n.s(elements);
        return s;
    }
}