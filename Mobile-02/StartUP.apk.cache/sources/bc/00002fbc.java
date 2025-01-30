package com.facebook.react.views.picker.d;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.c;

/* compiled from: PickerItemSelectEvent.java */
/* loaded from: classes2.dex */
public class a extends c<a> {

    /* renamed from: f  reason: collision with root package name */
    private final int f5345f;

    public a(int i2, int i3) {
        super(i2);
        this.f5345f = i3;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.f5345f);
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topSelect";
    }
}