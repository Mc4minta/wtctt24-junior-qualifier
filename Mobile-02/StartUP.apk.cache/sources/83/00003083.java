package com.facebook.yoga;

/* compiled from: YogaConfigJNIFinalizer.java */
/* loaded from: classes2.dex */
public class f extends e {
    public void c() {
        long j2 = this.a;
        if (j2 != 0) {
            this.a = 0L;
            YogaNative.jni_YGConfigFreeJNI(j2);
        }
    }

    protected void finalize() throws Throwable {
        try {
            c();
        } finally {
            super.finalize();
        }
    }
}