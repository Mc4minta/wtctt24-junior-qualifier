package kotlin.l0;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.l0.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class j implements i {
    private final h a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f17364b;

    /* renamed from: c  reason: collision with root package name */
    private final Matcher f17365c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f17366d;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.a0.d<String> {
        a() {
        }

        @Override // kotlin.a0.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return k((String) obj);
            }
            return false;
        }

        @Override // kotlin.a0.a
        public int i() {
            return j.this.f().groupCount() + 1;
        }

        @Override // kotlin.a0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return l((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean k(String str) {
            return super.contains(str);
        }

        public /* bridge */ int l(String str) {
            return super.indexOf(str);
        }

        @Override // kotlin.a0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return m((String) obj);
            }
            return -1;
        }

        public /* bridge */ int m(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.a0.d, java.util.List
        public String get(int i2) {
            String group = j.this.f().group(i2);
            return group != null ? group : "";
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class b extends kotlin.a0.a<g> implements h {

        /* compiled from: Regex.kt */
        /* loaded from: classes3.dex */
        static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Integer, g> {
            a() {
                super(1);
            }

            public final g a(int i2) {
                return b.this.get(i2);
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ g invoke(Integer num) {
                return a(num.intValue());
            }
        }

        b() {
        }

        @Override // kotlin.a0.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof g : true) {
                return k((g) obj);
            }
            return false;
        }

        @Override // kotlin.l0.h
        public g get(int i2) {
            kotlin.i0.c i3;
            i3 = l.i(j.this.f(), i2);
            if (i3.r().intValue() >= 0) {
                String group = j.this.f().group(i2);
                kotlin.jvm.internal.m.f(group, "matchResult.group(index)");
                return new g(group, i3);
            }
            return null;
        }

        @Override // kotlin.a0.a
        public int i() {
            return j.this.f().groupCount() + 1;
        }

        @Override // kotlin.a0.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<g> iterator() {
            kotlin.i0.c h2;
            kotlin.k0.h M;
            kotlin.k0.h v;
            h2 = kotlin.a0.r.h(this);
            M = kotlin.a0.z.M(h2);
            v = kotlin.k0.p.v(M, new a());
            return v.iterator();
        }

        public /* bridge */ boolean k(g gVar) {
            return super.contains(gVar);
        }
    }

    public j(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.m.g(matcher, "matcher");
        kotlin.jvm.internal.m.g(input, "input");
        this.f17365c = matcher;
        this.f17366d = input;
        this.a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult f() {
        return this.f17365c;
    }

    @Override // kotlin.l0.i
    public i.b a() {
        return i.a.a(this);
    }

    @Override // kotlin.l0.i
    public List<String> b() {
        if (this.f17364b == null) {
            this.f17364b = new a();
        }
        List<String> list = this.f17364b;
        kotlin.jvm.internal.m.e(list);
        return list;
    }

    @Override // kotlin.l0.i
    public h c() {
        return this.a;
    }

    @Override // kotlin.l0.i
    public kotlin.i0.c d() {
        kotlin.i0.c h2;
        h2 = l.h(f());
        return h2;
    }

    @Override // kotlin.l0.i
    public String getValue() {
        String group = f().group();
        kotlin.jvm.internal.m.f(group, "matchResult.group()");
        return group;
    }
}