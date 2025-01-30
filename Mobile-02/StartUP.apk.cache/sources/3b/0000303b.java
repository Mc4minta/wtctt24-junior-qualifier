package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: PageScrollEvent.java */
/* loaded from: classes2.dex */
class a extends com.facebook.react.uimanager.events.c<a> {

    /* renamed from: f  reason: collision with root package name */
    private final int f5558f;

    /* renamed from: g  reason: collision with root package name */
    private final float f5559g;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i2, int i3, float f2) {
        super(i2);
        this.f5558f = i3;
        this.f5559g = (Float.isInfinite(f2) || Float.isNaN(f2)) ? 0.0f : 0.0f;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.f5558f);
        createMap.putDouble("offset", this.f5559g);
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topPageScroll";
    }
}