package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.g;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class m {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public a a(int i2) {
            return e(Integer.valueOf(i2));
        }

        public abstract a b(long j2);

        public abstract a c(k kVar);

        public abstract a d(p pVar);

        abstract a e(Integer num);

        abstract a f(String str);

        public abstract a g(List<l> list);

        public abstract m h();

        public abstract a i(long j2);

        public a j(String str) {
            return f(str);
        }
    }

    public static a a() {
        return new g.b();
    }

    public abstract k b();

    public abstract List<l> c();

    public abstract Integer d();

    public abstract String e();

    public abstract p f();

    public abstract long g();

    public abstract long h();
}