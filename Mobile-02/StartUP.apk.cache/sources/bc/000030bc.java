package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.f;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class l {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract a a(long j2);

        public abstract a b(o oVar);

        public abstract a c(Integer num);

        abstract a d(String str);

        abstract a e(byte[] bArr);

        public abstract l f();

        public abstract a g(long j2);

        public abstract a h(long j2);
    }

    public static a a(String str) {
        return new f.b().d(str);
    }

    public static a b(byte[] bArr) {
        return new f.b().e(bArr);
    }

    public abstract Integer c();

    public abstract long d();

    public abstract long e();

    public abstract o f();

    public abstract byte[] g();

    public abstract String h();

    public abstract long i();
}