package com.google.firebase.installations.r;

import com.google.firebase.installations.r.b;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
public abstract class e {

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract e a();

        public abstract a b(b bVar);

        public abstract a c(String str);

        public abstract a d(long j2);
    }

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static a a() {
        return new b.C0191b().d(0L);
    }

    public abstract b b();

    public abstract String c();

    public abstract long d();
}