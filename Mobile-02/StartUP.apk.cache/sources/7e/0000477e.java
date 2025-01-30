package e.g.a.c.i;

import e.g.a.c.i.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class k {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract k a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a b(e.g.a.c.b bVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a c(e.g.a.c.c<?> cVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a d(e.g.a.c.e<?, byte[]> eVar);

        public abstract a e(l lVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new b.C0295b();
    }

    public abstract e.g.a.c.b b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.g.a.c.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.g.a.c.e<?, byte[]> e();

    public abstract l f();

    public abstract String g();
}