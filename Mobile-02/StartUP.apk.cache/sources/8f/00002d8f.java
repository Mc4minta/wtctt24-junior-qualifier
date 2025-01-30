package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import e.f.l.a.a;

@a
/* loaded from: classes2.dex */
public abstract class NativeArray implements NativeArrayInterface {
    @a
    private HybridData mHybridData;

    static {
        ReactBridge.staticInit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NativeArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @Override // com.facebook.react.bridge.NativeArrayInterface
    public native String toString();
}