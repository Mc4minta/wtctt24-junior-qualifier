package com.facebook.react.views.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactSliderEvent.java */
/* loaded from: classes2.dex */
public class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    private final double f5398f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5399g;

    public b(int i2, double d2, boolean z) {
        super(i2);
        this.f5398f = d2;
        this.f5399g = z;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", i());
        createMap.putDouble("value", m());
        createMap.putBoolean("fromUser", n());
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
        return "topChange";
    }

    public double m() {
        return this.f5398f;
    }

    public boolean n() {
        return this.f5399g;
    }
}