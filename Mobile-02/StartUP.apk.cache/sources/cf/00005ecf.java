package org.reactnative.camera.f;

import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: CameraMountErrorEvent.java */
/* loaded from: classes3.dex */
public class d extends com.facebook.react.uimanager.events.c<d> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<d> f17675f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private String f17676g;

    private d() {
    }

    private void m(int i2, String str) {
        super.j(i2);
        this.f17676g = str;
    }

    public static d n(int i2, String str) {
        d acquire = f17675f.acquire();
        if (acquire == null) {
            acquire = new d();
        }
        acquire.m(i2, str);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ApiConstants.MESSAGE, this.f17676g);
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
        return CameraViewManager.a.EVENT_ON_MOUNT_ERROR.toString();
    }
}