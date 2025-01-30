package org.reactnative.camera.f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: TouchEvent.java */
/* loaded from: classes3.dex */
public class m extends com.facebook.react.uimanager.events.c<m> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<m> f17690f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private int f17691g;

    /* renamed from: h  reason: collision with root package name */
    private int f17692h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17693i;

    private m() {
    }

    private void m(int i2, boolean z, int i3, int i4) {
        super.j(i2);
        this.f17691g = i3;
        this.f17692h = i4;
        this.f17693i = z;
    }

    public static m n(int i2, boolean z, int i3, int i4) {
        m acquire = f17690f.acquire();
        if (acquire == null) {
            acquire = new m();
        }
        acquire.m(i2, z, i3, i4);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", i());
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("x", this.f17691g);
        createMap2.putInt("y", this.f17692h);
        createMap.putBoolean("isDoubleTap", this.f17693i);
        createMap.putMap("touchOrigin", createMap2);
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
        return CameraViewManager.a.EVENT_ON_TOUCH.toString();
    }
}