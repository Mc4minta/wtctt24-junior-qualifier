package com.facebook.react.views.drawer.b;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: DrawerStateChangedEvent.java */
/* loaded from: classes2.dex */
public class d extends com.facebook.react.uimanager.events.c<d> {

    /* renamed from: f  reason: collision with root package name */
    private final int f5299f;

    public d(int i2, int i3) {
        super(i2);
        this.f5299f = i3;
    }

    private WritableMap n() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("drawerState", m());
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
        return "topDrawerStateChanged";
    }

    public int m() {
        return this.f5299f;
    }
}