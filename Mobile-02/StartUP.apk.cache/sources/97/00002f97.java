package com.facebook.react.views.drawer.b;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: DrawerSlideEvent.java */
/* loaded from: classes2.dex */
public class c extends com.facebook.react.uimanager.events.c<c> {

    /* renamed from: f  reason: collision with root package name */
    private final float f5298f;

    public c(int i2, float f2) {
        super(i2);
        this.f5298f = f2;
    }

    private WritableMap n() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("offset", m());
        return createMap;
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
        return "topDrawerSlide";
    }

    public float m() {
        return this.f5298f;
    }
}