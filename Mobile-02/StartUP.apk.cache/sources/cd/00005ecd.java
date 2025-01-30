package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: BarcodeDetectionErrorEvent.java */
/* loaded from: classes3.dex */
public class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<b> f17670f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private k.b.a.b f17671g;

    private b() {
    }

    private void m(int i2, k.b.a.b bVar) {
        super.j(i2);
        this.f17671g = bVar;
    }

    public static b n(int i2, k.b.a.b bVar) {
        b acquire = f17670f.acquire();
        if (acquire == null) {
            acquire = new b();
        }
        acquire.m(i2, bVar);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        k.b.a.b bVar = this.f17671g;
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
        return CameraViewManager.a.EVENT_ON_BARCODE_DETECTION_ERROR.toString();
    }
}