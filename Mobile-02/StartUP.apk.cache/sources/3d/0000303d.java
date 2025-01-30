package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: PageSelectedEvent.java */
/* loaded from: classes2.dex */
class c extends com.facebook.react.uimanager.events.c<c> {

    /* renamed from: f  reason: collision with root package name */
    private final int f5561f;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i2, int i3) {
        super(i2);
        this.f5561f = i3;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.f5561f);
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topPageSelected";
    }
}