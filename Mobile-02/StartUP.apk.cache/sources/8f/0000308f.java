package com.facebook.yoga;

/* compiled from: YogaNodeJNIFinalizer.java */
/* loaded from: classes2.dex */
public class r extends YogaNodeJNIBase {
    public r() {
    }

    protected void finalize() throws Throwable {
        try {
            v0();
        } finally {
            super.finalize();
        }
    }

    public void v0() {
        long j2 = this.f5662e;
        if (j2 != 0) {
            this.f5662e = 0L;
            YogaNative.jni_YGNodeFreeJNI(j2);
        }
    }

    public r(c cVar) {
        super(cVar);
    }
}