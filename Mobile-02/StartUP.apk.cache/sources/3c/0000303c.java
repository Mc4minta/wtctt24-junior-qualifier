package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: PageScrollStateChangedEvent.java */
/* loaded from: classes2.dex */
class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    private final String f5560f;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i2, String str) {
        super(i2);
        this.f5560f = str;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("pageScrollState", this.f5560f);
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topPageScrollStateChanged";
    }
}