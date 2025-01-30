package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: InsetsChangeEvent.java */
/* loaded from: classes2.dex */
class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    private a f11054f;

    /* renamed from: g  reason: collision with root package name */
    private c f11055g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i2, a aVar, c cVar) {
        super(i2);
        this.f11054f = aVar;
        this.f11055g = cVar;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("insets", l.b(this.f11054f));
        createMap.putMap("frame", l.d(this.f11055g));
        rCTEventEmitter.receiveEvent(i(), f(), createMap);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topInsetsChange";
    }
}