package e.f.e;

import e.f.d.c.l;

/* compiled from: DataSources.java */
/* loaded from: classes2.dex */
public class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: DataSources.java */
    /* loaded from: classes2.dex */
    static class a<T> implements l<c<T>> {
        final /* synthetic */ Throwable a;

        a(Throwable th) {
            this.a = th;
        }

        @Override // e.f.d.c.l
        /* renamed from: a */
        public c<T> get() {
            return d.b(this.a);
        }
    }

    public static <T> l<c<T>> a(Throwable th) {
        return new a(th);
    }

    public static <T> c<T> b(Throwable th) {
        h u = h.u();
        u.n(th);
        return u;
    }
}