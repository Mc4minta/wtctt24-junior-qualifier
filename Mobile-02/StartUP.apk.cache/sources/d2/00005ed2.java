package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: FacesDetectedEvent.java */
/* loaded from: classes3.dex */
public class g extends com.facebook.react.uimanager.events.c<g> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<g> f17680f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private WritableArray f17681g;

    private g() {
    }

    private void m(int i2, WritableArray writableArray) {
        super.j(i2);
        this.f17681g = writableArray;
    }

    public static g n(int i2, WritableArray writableArray) {
        g acquire = f17680f.acquire();
        if (acquire == null) {
            acquire = new g();
        }
        acquire.m(i2, writableArray);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "face");
        createMap.putArray("faces", this.f17681g);
        createMap.putInt("target", i());
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), o());
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        if (this.f17681g.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.f17681g.size();
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_FACES_DETECTED.toString();
    }
}