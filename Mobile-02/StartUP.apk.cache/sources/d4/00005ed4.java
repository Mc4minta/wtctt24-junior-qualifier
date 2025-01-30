package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: PictureTakenEvent.java */
/* loaded from: classes3.dex */
public class i extends com.facebook.react.uimanager.events.c<i> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<i> f17684f = new androidx.core.util.g<>(3);

    private i() {
    }

    public static i m(int i2) {
        i acquire = f17684f.acquire();
        if (acquire == null) {
            acquire = new i();
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
        return CameraViewManager.a.EVENT_ON_PICTURE_TAKEN.toString();
    }
}