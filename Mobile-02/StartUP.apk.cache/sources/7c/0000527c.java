package kotlin.k0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.a0.z;

/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
public class p extends o {

    /* compiled from: Iterables.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterable<T>, kotlin.jvm.internal.n0.a {
        final /* synthetic */ h a;

        public a(h hVar) {
            this.a = hVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    /* compiled from: _Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.l<T, Boolean> {
        public static final b a = new b();

        b() {
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2((b<T>) obj));
        }

        /* renamed from: invoke */
        public final boolean invoke2(T t) {
            return t == null;
        }
    }

    /* compiled from: _Sequences.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class c<R> extends kotlin.jvm.internal.k implements kotlin.e0.c.l<h<? extends R>, Iterator<? extends R>> {
        public static final c a = new c();

        c() {
            super(1, h.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Iterator<R> invoke(h<? extends R> p1) {
            kotlin.jvm.internal.m.g(p1, "p1");
            return (Iterator<? extends R>) p1.iterator();
        }
    }

    public static final <T, C extends Collection<? super T>> C A(h<? extends T> toCollection, C destination) {
        kotlin.jvm.internal.m.g(toCollection, "$this$toCollection");
        kotlin.jvm.internal.m.g(destination, "destination");
        for (T t : toCollection) {
            destination.add(t);
        }
        return destination;
    }

    public static <T> List<T> B(h<? extends T> toList) {
        List C;
        List<T> n;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        C = C(toList);
        n = kotlin.a0.r.n(C);
        return n;
    }

    public static <T> List<T> C(h<? extends T> toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        return (List) A(toMutableList, new ArrayList());
    }

    public static <T> Iterable<T> j(h<? extends T> asIterable) {
        kotlin.jvm.internal.m.g(asIterable, "$this$asIterable");
        return new a(asIterable);
    }

    public static <T> int k(h<? extends T> count) {
        kotlin.jvm.internal.m.g(count, "$this$count");
        Iterator<? extends T> it = count.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                kotlin.a0.r.p();
            }
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> h<T> l(h<? extends T> drop, int i2) {
        kotlin.jvm.internal.m.g(drop, "$this$drop");
        if (i2 >= 0) {
            return i2 == 0 ? drop : drop instanceof kotlin.k0.c ? ((kotlin.k0.c) drop).a(i2) : new kotlin.k0.b(drop, i2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static <T> h<T> m(h<? extends T> filter, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(filter, "$this$filter");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        return new e(filter, true, predicate);
    }

    public static <T> h<T> n(h<? extends T> filterNot, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(filterNot, "$this$filterNot");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        return new e(filterNot, false, predicate);
    }

    public static <T> h<T> o(h<? extends T> filterNotNull) {
        h<T> n;
        kotlin.jvm.internal.m.g(filterNotNull, "$this$filterNotNull");
        n = n(filterNotNull, b.a);
        Objects.requireNonNull(n, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return n;
    }

    public static <T> T p(h<? extends T> firstOrNull) {
        kotlin.jvm.internal.m.g(firstOrNull, "$this$firstOrNull");
        Iterator<? extends T> it = firstOrNull.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T, R> h<R> q(h<? extends T> flatMap, kotlin.e0.c.l<? super T, ? extends h<? extends R>> transform) {
        kotlin.jvm.internal.m.g(flatMap, "$this$flatMap");
        kotlin.jvm.internal.m.g(transform, "transform");
        return new f(flatMap, transform, c.a);
    }

    public static final <T, A extends Appendable> A r(h<? extends T> joinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinTo, "$this$joinTo");
        kotlin.jvm.internal.m.g(buffer, "buffer");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t : joinTo) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.l0.p.a(buffer, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String s(h<? extends T> joinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinToString, "$this$joinToString");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        String sb = ((StringBuilder) r(joinToString, new StringBuilder(), separator, prefix, postfix, i2, truncated, lVar)).toString();
        kotlin.jvm.internal.m.f(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String t(h hVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.e0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i3 & 2) != 0 ? "" : charSequence2;
        String str2 = (i3 & 4) == 0 ? charSequence3 : "";
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return s(hVar, charSequence, str, str2, i4, charSequence5, lVar);
    }

    public static <T> T u(h<? extends T> last) {
        kotlin.jvm.internal.m.g(last, "$this$last");
        Iterator<? extends T> it = last.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T, R> h<R> v(h<? extends T> map, kotlin.e0.c.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.m.g(map, "$this$map");
        kotlin.jvm.internal.m.g(transform, "transform");
        return new r(map, transform);
    }

    public static <T, R> h<R> w(h<? extends T> mapNotNull, kotlin.e0.c.l<? super T, ? extends R> transform) {
        h<R> o;
        kotlin.jvm.internal.m.g(mapNotNull, "$this$mapNotNull");
        kotlin.jvm.internal.m.g(transform, "transform");
        o = o(new r(mapNotNull, transform));
        return o;
    }

    public static <T> h<T> x(h<? extends T> plus, Iterable<? extends T> elements) {
        h M;
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        kotlin.jvm.internal.m.g(elements, "elements");
        M = z.M(elements);
        return n.e(n.i(plus, M));
    }

    public static <T> h<T> y(h<? extends T> plus, T t) {
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        return n.e(n.i(plus, n.i(t)));
    }

    public static <T> h<T> z(h<? extends T> takeWhile, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(takeWhile, "$this$takeWhile");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        return new q(takeWhile, predicate);
    }
}