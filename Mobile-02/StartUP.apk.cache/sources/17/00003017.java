package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactContentSizeChangedEvent.java */
/* loaded from: classes2.dex */
public class b extends com.facebook.react.uimanager.events.c<e> {

    /* renamed from: f  reason: collision with root package name */
    private float f5493f;

    /* renamed from: g  reason: collision with root package name */
    private float f5494g;

    public b(int i2, float f2, float f3) {
        super(i2);
        this.f5493f = f2;
        this.f5494g = f3;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("width", this.f5493f);
        createMap2.putDouble("height", this.f5494g);
        createMap.putMap("contentSize", createMap2);
        createMap.putInt("target", i());
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topContentSizeChange";
    }
}