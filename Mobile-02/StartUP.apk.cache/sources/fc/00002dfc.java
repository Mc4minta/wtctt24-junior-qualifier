package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.fabric.events.EventBeatManager;

@e.f.l.a.a
@SuppressLint({"MissingNativeLoadLibrary"})
/* loaded from: classes2.dex */
public class Binding {
    @e.f.l.a.a
    private final HybridData mHybridData = initHybrid();

    static {
        b.a();
    }

    private static native HybridData initHybrid();

    private native void installFabricUIManager(long j2, Object obj, EventBeatManager eventBeatManager, MessageQueueThread messageQueueThread, ComponentFactoryDelegate componentFactoryDelegate, Object obj2);

    private native void uninstallFabricUIManager();

    public native void renderTemplateToSurface(int i2, String str);

    public native void setConstraints(int i2, float f2, float f3, float f4, float f5, boolean z, boolean z2);

    public native void setPixelDensity(float f2);

    public native void startSurface(int i2, String str, NativeMap nativeMap);

    public native void startSurfaceWithConstraints(int i2, String str, NativeMap nativeMap, float f2, float f3, float f4, float f5, boolean z, boolean z2);

    public native void stopSurface(int i2);
}