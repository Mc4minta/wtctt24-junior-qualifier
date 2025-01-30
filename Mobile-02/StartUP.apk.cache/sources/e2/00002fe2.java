package com.facebook.react.views.switchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.c;

/* compiled from: ReactSwitchEvent.java */
/* loaded from: classes2.dex */
class b extends c<b> {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5403f;

    public b(int i2, boolean z) {
        super(i2);
        this.f5403f = z;
    }

    private WritableMap n() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", i());
        createMap.putBoolean("value", m());
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
        return "topChange";
    }

    public boolean m() {
        return this.f5403f;
    }
}