package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.o;

/* compiled from: ContentSizeChangeEvent.java */
/* loaded from: classes2.dex */
public class b extends c<b> {

    /* renamed from: f  reason: collision with root package name */
    private final int f5050f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5051g;

    public b(int i2, int i3, int i4) {
        super(i2);
        this.f5050f = i3;
        this.f5051g = i4;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("width", o.a(this.f5050f));
        createMap.putDouble("height", o.a(this.f5051g));
        rCTEventEmitter.receiveEvent(i(), "topContentSizeChange", createMap);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topContentSizeChange";
    }
}