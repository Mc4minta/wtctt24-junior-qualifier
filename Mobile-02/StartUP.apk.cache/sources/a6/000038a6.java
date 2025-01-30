package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

/* compiled from: MoreObjects.java */
/* loaded from: classes2.dex */
public final class h {

    /* compiled from: MoreObjects.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final a f8436b;

        /* renamed from: c  reason: collision with root package name */
        private a f8437c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8438d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MoreObjects.java */
        /* loaded from: classes2.dex */
        public static final class a {
            String a;

            /* renamed from: b  reason: collision with root package name */
            Object f8439b;

            /* renamed from: c  reason: collision with root package name */
            a f8440c;

            private a() {
            }
        }

        private a c() {
            a aVar = new a();
            this.f8437c.f8440c = aVar;
            this.f8437c = aVar;
            return aVar;
        }

        private b d(Object obj) {
            c().f8439b = obj;
            return this;
        }

        private b e(String str, Object obj) {
            a c2 = c();
            c2.f8439b = obj;
            c2.a = (String) l.i(str);
            return this;
        }

        @CanIgnoreReturnValue
        public b a(String str, int i2) {
            return e(str, String.valueOf(i2));
        }

        @CanIgnoreReturnValue
        public b b(String str, Object obj) {
            return e(str, obj);
        }

        @CanIgnoreReturnValue
        public b f(Object obj) {
            return d(obj);
        }

        public String toString() {
            boolean z = this.f8438d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f8436b.f8440c; aVar != null; aVar = aVar.f8440c) {
                Object obj = aVar.f8439b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f8436b = aVar;
            this.f8437c = aVar;
            this.f8438d = false;
            this.a = (String) l.i(str);
        }
    }

    public static <T> T a(T t, T t2) {
        return t != null ? t : (T) l.i(t2);
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}