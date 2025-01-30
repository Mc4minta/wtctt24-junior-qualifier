package com.facebook.react.bridge.queue;

import com.facebook.jni.HybridData;
import e.f.l.a.a;

@a
/* loaded from: classes2.dex */
public class NativeRunnable implements Runnable {
    private final HybridData mHybridData;

    @a
    private NativeRunnable(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @Override // java.lang.Runnable
    public native void run();
}