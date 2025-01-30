package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: FaceDetectionErrorEvent.java */
/* loaded from: classes3.dex */
public class f extends com.facebook.react.uimanager.events.c<f> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<f> f17678f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private org.reactnative.facedetector.b f17679g;

    private f() {
    }

    private void m(int i2, org.reactnative.facedetector.b bVar) {
        super.j(i2);
        this.f17679g = bVar;
    }

    public static f n(int i2, org.reactnative.facedetector.b bVar) {
        f acquire = f17678f.acquire();
        if (acquire == null) {
            acquire = new f();
        }
        acquire.m(i2, bVar);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        org.reactnative.facedetector.b bVar = this.f17679g;
        createMap.putBoolean("isOperational", bVar != null && bVar.c());
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), o());
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_FACE_DETECTION_ERROR.toString();
    }
}