package com.facebook.yoga;

/* compiled from: YogaConfigJNIBase.java */
/* loaded from: classes2.dex */
public abstract class e extends c {
    long a;

    private e(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    @Override // com.facebook.yoga.c
    public void a(float f2) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.a, f2);
    }

    @Override // com.facebook.yoga.c
    public void b(boolean z) {
        YogaNative.jni_YGConfigSetUseLegacyStretchBehaviourJNI(this.a, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this(YogaNative.jni_YGConfigNewJNI());
    }
}