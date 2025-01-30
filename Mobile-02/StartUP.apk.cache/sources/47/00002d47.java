package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import e.f.l.a.a;

@a
/* loaded from: classes2.dex */
public class CxxCallbackImpl implements Callback {
    @a
    private final HybridData mHybridData;

    @a
    private CxxCallbackImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private native void nativeInvoke(NativeArray nativeArray);

    @Override // com.facebook.react.bridge.Callback
    public void invoke(Object... objArr) {
        nativeInvoke(Arguments.fromJavaArgs(objArr));
    }
}