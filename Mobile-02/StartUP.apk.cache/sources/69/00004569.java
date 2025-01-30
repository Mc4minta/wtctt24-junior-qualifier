package e.f.d.c;

/* compiled from: Suppliers.java */
/* loaded from: classes2.dex */
public class m {
    public static final l<Boolean> a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final l<Boolean> f12073b = new c();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Suppliers.java */
    /* loaded from: classes2.dex */
    static class a<T> implements l<T> {
        final /* synthetic */ Object a;

        a(Object obj) {
            this.a = obj;
        }

        @Override // e.f.d.c.l
        public T get() {
            return (T) this.a;
        }
    }

    /* compiled from: Suppliers.java */
    /* loaded from: classes2.dex */
    static class b implements l<Boolean> {
        b() {
        }

        @Override // e.f.d.c.l
        /* renamed from: a */
        public Boolean get() {
            return Boolean.TRUE;
        }
    }

    /* compiled from: Suppliers.java */
    /* loaded from: classes2.dex */
    static class c implements l<Boolean> {
        c() {
        }

        @Override // e.f.d.c.l
        /* renamed from: a */
        public Boolean get() {
            return Boolean.FALSE;
        }
    }

    public static <T> l<T> a(T t) {
        return new a(t);
    }
}