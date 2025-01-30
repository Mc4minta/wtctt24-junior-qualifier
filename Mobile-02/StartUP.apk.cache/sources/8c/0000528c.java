package kotlin.l0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class e implements kotlin.k0.h<kotlin.i0.c> {
    private final CharSequence a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17355b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17356c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.e0.c.p<CharSequence, Integer, kotlin.o<Integer, Integer>> f17357d;

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<kotlin.i0.c>, kotlin.jvm.internal.n0.a {
        private int a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f17358b;

        /* renamed from: c  reason: collision with root package name */
        private int f17359c;

        /* renamed from: d  reason: collision with root package name */
        private kotlin.i0.c f17360d;

        /* renamed from: e  reason: collision with root package name */
        private int f17361e;

        a() {
            int f2;
            f2 = kotlin.i0.f.f(e.this.f17355b, 0, e.this.a.length());
            this.f17358b = f2;
            this.f17359c = f2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f17362f.f17356c) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.f17359c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.f17360d = r0
                goto L9e
            Lc:
                kotlin.l0.e r0 = kotlin.l0.e.this
                int r0 = kotlin.l0.e.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f17361e
                int r0 = r0 + r3
                r6.f17361e = r0
                kotlin.l0.e r4 = kotlin.l0.e.this
                int r4 = kotlin.l0.e.d(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f17359c
                kotlin.l0.e r4 = kotlin.l0.e.this
                java.lang.CharSequence r4 = kotlin.l0.e.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.f17358b
                kotlin.i0.c r1 = new kotlin.i0.c
                kotlin.l0.e r4 = kotlin.l0.e.this
                java.lang.CharSequence r4 = kotlin.l0.e.c(r4)
                int r4 = kotlin.l0.o.c0(r4)
                r1.<init>(r0, r4)
                r6.f17360d = r1
                r6.f17359c = r2
                goto L9c
            L47:
                kotlin.l0.e r0 = kotlin.l0.e.this
                kotlin.e0.c.p r0 = kotlin.l0.e.b(r0)
                kotlin.l0.e r4 = kotlin.l0.e.this
                java.lang.CharSequence r4 = kotlin.l0.e.c(r4)
                int r5 = r6.f17359c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.o r0 = (kotlin.o) r0
                if (r0 != 0) goto L77
                int r0 = r6.f17358b
                kotlin.i0.c r1 = new kotlin.i0.c
                kotlin.l0.e r4 = kotlin.l0.e.this
                java.lang.CharSequence r4 = kotlin.l0.e.c(r4)
                int r4 = kotlin.l0.o.c0(r4)
                r1.<init>(r0, r4)
                r6.f17360d = r1
                r6.f17359c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f17358b
                kotlin.i0.c r4 = kotlin.i0.d.j(r4, r2)
                r6.f17360d = r4
                int r2 = r2 + r0
                r6.f17358b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f17359c = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l0.e.a.b():void");
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public kotlin.i0.c next() {
            if (this.a == -1) {
                b();
            }
            if (this.a != 0) {
                kotlin.i0.c cVar = this.f17360d;
                Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f17360d = null;
                this.a = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                b();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence input, int i2, int i3, kotlin.e0.c.p<? super CharSequence, ? super Integer, kotlin.o<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.m.g(input, "input");
        kotlin.jvm.internal.m.g(getNextMatch, "getNextMatch");
        this.a = input;
        this.f17355b = i2;
        this.f17356c = i3;
        this.f17357d = getNextMatch;
    }

    @Override // kotlin.k0.h
    public Iterator<kotlin.i0.c> iterator() {
        return new a();
    }
}