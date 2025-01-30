package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: CameraReadyEvent.java */
/* loaded from: classes3.dex */
public class e extends com.facebook.react.uimanager.events.c<e> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<e> f17677f = new androidx.core.util.g<>(3);

    private e() {
    }

    public static e m(int i2) {
        e acquire = f17677f.acquire();
        if (acquire == null) {
            acquire = new e();
        }
        acquire.j(i2);
        return acquire;
    }

    private WritableMap n() {
        return Arguments.createMap();
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), n());
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_CAMERA_READY.toString();
    }
}