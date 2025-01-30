package org.reactnative.camera.f;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: RecordingStartEvent.java */
/* loaded from: classes3.dex */
public class k extends com.facebook.react.uimanager.events.c<k> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<k> f17686f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private WritableMap f17687g;

    private k() {
    }

    private void m(int i2, WritableMap writableMap) {
        super.j(i2);
        this.f17687g = writableMap;
    }

    public static k n(int i2, WritableMap writableMap) {
        k acquire = f17686f.acquire();
        if (acquire == null) {
            acquire = new k();
        }
        acquire.m(i2, writableMap);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), this.f17687g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_RECORDING_START.toString();
    }
}