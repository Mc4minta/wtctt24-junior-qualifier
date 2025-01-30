package e.f.d.c;

import java.util.Arrays;

/* compiled from: Objects.java */
/* loaded from: classes2.dex */
public final class h {

    /* compiled from: Objects.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private a f12068b;

        /* renamed from: c  reason: collision with root package name */
        private a f12069c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f12070d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Objects.java */
        /* loaded from: classes2.dex */
        public static final class a {
            String a;

            /* renamed from: b  reason: collision with root package name */
            Object f12071b;

            /* renamed from: c  reason: collision with root package name */
            a f12072c;

            private a() {
            }
        }

        private a d() {
            a aVar = new a();
            this.f12069c.f12072c = aVar;
            this.f12069c = aVar;
            return aVar;
        }

        private b e(String str, Object obj) {
            a d2 = d();
            d2.f12071b = obj;
            d2.a = (String) i.g(str);
            return this;
        }

        public b a(String str, int i2) {
            return e(str, String.valueOf(i2));
        }

        public b b(String str, Object obj) {
            return e(str, obj);
        }

        public b c(String str, boolean z) {
            return e(str, String.valueOf(z));
        }

        public String toString() {
            boolean z = this.f12070d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f12068b.f12072c; aVar != null; aVar = aVar.f12072c) {
                if (!z || aVar.f12071b != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    sb.append(aVar.f12071b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f12068b = aVar;
            this.f12069c = aVar;
            this.f12070d = false;
            this.a = (String) i.g(str);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    private static String c(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    public static b d(Object obj) {
        return new b(c(obj.getClass()));
    }
}