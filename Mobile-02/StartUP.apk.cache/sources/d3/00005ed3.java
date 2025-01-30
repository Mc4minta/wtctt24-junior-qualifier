package org.reactnative.camera.f;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: PictureSavedEvent.java */
/* loaded from: classes3.dex */
public class h extends com.facebook.react.uimanager.events.c<h> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<h> f17682f = new androidx.core.util.g<>(5);

    /* renamed from: g  reason: collision with root package name */
    private WritableMap f17683g;

    private h() {
    }

    private void m(int i2, WritableMap writableMap) {
        super.j(i2);
        this.f17683g = writableMap;
    }

    public static h n(int i2, WritableMap writableMap) {
        h acquire = f17682f.acquire();
        if (acquire == null) {
            acquire = new h();
        }
        acquire.m(i2, writableMap);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), this.f17683g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) (this.f17683g.getMap("data").getString("uri").hashCode() % 32767);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_PICTURE_SAVED.toString();
    }
}