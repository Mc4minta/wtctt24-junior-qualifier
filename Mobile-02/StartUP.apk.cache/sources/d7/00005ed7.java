package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: TextRecognizedEvent.java */
/* loaded from: classes3.dex */
public class l extends com.facebook.react.uimanager.events.c<l> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<l> f17688f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private WritableArray f17689g;

    private l() {
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "textBlock");
        createMap.putArray("textBlocks", this.f17689g);
        createMap.putInt("target", i());
        return createMap;
    }

    private void n(int i2, WritableArray writableArray) {
        super.j(i2);
        this.f17689g = writableArray;
    }

    public static l o(int i2, WritableArray writableArray) {
        l acquire = f17688f.acquire();
        if (acquire == null) {
            acquire = new l();
        }
        acquire.n(i2, writableArray);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_TEXT_RECOGNIZED.toString();
    }
}