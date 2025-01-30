package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: RecordingEndEvent.java */
/* loaded from: classes3.dex */
public class j extends com.facebook.react.uimanager.events.c<j> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<j> f17685f = new androidx.core.util.g<>(3);

    private j() {
    }

    public static j m(int i2) {
        j acquire = f17685f.acquire();
        if (acquire == null) {
            acquire = new j();
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
        return CameraViewManager.a.EVENT_ON_RECORDING_END.toString();
    }
}