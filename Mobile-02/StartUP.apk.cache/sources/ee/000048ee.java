package e.g.b.a.d;

/* compiled from: Objects.java */
/* loaded from: classes2.dex */
public final class x {

    /* compiled from: Objects.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private a f13463b;

        /* renamed from: c  reason: collision with root package name */
        private a f13464c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13465d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Objects.java */
        /* loaded from: classes2.dex */
        public static final class a {
            String a;

            /* renamed from: b  reason: collision with root package name */
            Object f13466b;

            /* renamed from: c  reason: collision with root package name */
            a f13467c;

            private a() {
            }
        }

        b(String str) {
            a aVar = new a();
            this.f13463b = aVar;
            this.f13464c = aVar;
            this.a = str;
        }

        private a b() {
            a aVar = new a();
            this.f13464c.f13467c = aVar;
            this.f13464c = aVar;
            return aVar;
        }

        private b c(String str, Object obj) {
            a b2 = b();
            b2.f13466b = obj;
            b2.a = (String) y.d(str);
            return this;
        }

        public b a(String str, Object obj) {
            return c(str, obj);
        }

        public String toString() {
            boolean z = this.f13465d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f13463b.f13467c; aVar != null; aVar = aVar.f13467c) {
                if (!z || aVar.f13466b != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    sb.append(aVar.f13466b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return com.google.common.base.i.a(obj, obj2);
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}