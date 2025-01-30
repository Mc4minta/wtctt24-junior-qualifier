package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactSlidingCompleteEvent.java */
/* loaded from: classes2.dex */
public class c extends com.facebook.react.uimanager.events.c<c> {

    /* renamed from: f  reason: collision with root package name */
    private final double f5400f;

    public c(int i2, double d2) {
        super(i2);
        this.f5400f = d2;
    }

    private WritableMap n() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", i());
        createMap.putDouble("value", m());
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
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
        return "topSlidingComplete";
    }

    public double m() {
        return this.f5400f;
    }
}