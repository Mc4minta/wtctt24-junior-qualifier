package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactTextInputSelectionEvent.java */
/* loaded from: classes2.dex */
class l extends com.facebook.react.uimanager.events.c<l> {

    /* renamed from: f  reason: collision with root package name */
    private int f5521f;

    /* renamed from: g  reason: collision with root package name */
    private int f5522g;

    public l(int i2, int i3, int i4) {
        super(i2);
        this.f5521f = i3;
        this.f5522g = i4;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("end", this.f5522g);
        createMap2.putInt("start", this.f5521f);
        createMap.putMap("selection", createMap2);
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topSelectionChange";
    }
}