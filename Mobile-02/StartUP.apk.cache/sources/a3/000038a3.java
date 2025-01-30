package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Joiner.java */
/* loaded from: classes2.dex */
public class g {
    private final String a;

    /* compiled from: Joiner.java */
    /* loaded from: classes2.dex */
    class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8433b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar, String str) {
            super(gVar, null);
            this.f8433b = str;
        }

        @Override // com.google.common.base.g
        CharSequence h(Object obj) {
            return obj == null ? this.f8433b : g.this.h(obj);
        }

        @Override // com.google.common.base.g
        public g i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* compiled from: Joiner.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private final g a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8435b;

        /* synthetic */ b(g gVar, String str, a aVar) {
            this(gVar, str);
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A a(A a, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            l.i(a);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a.append(this.a.h(next.getKey()));
                a.append(this.f8435b);
                a.append(this.a.h(next.getValue()));
                while (it.hasNext()) {
                    a.append(this.a.a);
                    Map.Entry<?, ?> next2 = it.next();
                    a.append(this.a.h(next2.getKey()));
                    a.append(this.f8435b);
                    a.append(this.a.h(next2.getValue()));
                }
            }
            return a;
        }

        @CanIgnoreReturnValue
        public StringBuilder b(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return c(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        public StringBuilder c(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        @CanIgnoreReturnValue
        public StringBuilder d(StringBuilder sb, Map<?, ?> map) {
            return b(sb, map.entrySet());
        }

        private b(g gVar, String str) {
            this.a = gVar;
            this.f8435b = (String) l.i(str);
        }
    }

    /* synthetic */ g(g gVar, a aVar) {
        this(gVar);
    }

    public static g f(char c2) {
        return new g(String.valueOf(c2));
    }

    public static g g(String str) {
        return new g(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A b(A a2, Iterator<?> it) throws IOException {
        l.i(a2);
        if (it.hasNext()) {
            a2.append(h(it.next()));
            while (it.hasNext()) {
                a2.append(this.a);
                a2.append(h(it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public final StringBuilder c(StringBuilder sb, Iterator<?> it) {
        try {
            b(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String d(Iterable<?> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<?> it) {
        return c(new StringBuilder(), it).toString();
    }

    CharSequence h(Object obj) {
        l.i(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public g i(String str) {
        l.i(str);
        return new a(this, str);
    }

    public b j(String str) {
        return new b(this, str, null);
    }

    private g(String str) {
        this.a = (String) l.i(str);
    }

    private g(g gVar) {
        this.a = gVar.a;
    }
}