package com.swmansion.gesturehandler.react;

import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RNGestureHandlerStateChangeEvent.java */
/* loaded from: classes2.dex */
public class i extends com.facebook.react.uimanager.events.c<i> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<i> f10917f = new androidx.core.util.g<>(7);

    /* renamed from: g  reason: collision with root package name */
    private WritableMap f10918g;

    private i() {
    }

    private void m(e.i.a.b bVar, int i2, int i3, c cVar) {
        super.j(bVar.r().getId());
        WritableMap createMap = Arguments.createMap();
        this.f10918g = createMap;
        if (cVar != null) {
            cVar.a(bVar, createMap);
        }
        this.f10918g.putInt("handlerTag", bVar.q());
        this.f10918g.putInt(ApiConstants.STATE, i2);
        this.f10918g.putInt("oldState", i3);
    }

    public static i n(e.i.a.b bVar, int i2, int i3, c cVar) {
        i acquire = f10917f.acquire();
        if (acquire == null) {
            acquire = new i();
        }
        acquire.m(bVar, i2, i3, cVar);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), "onGestureHandlerStateChange", this.f10918g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "onGestureHandlerStateChange";
    }

    @Override // com.facebook.react.uimanager.events.c
    public void l() {
        this.f10918g = null;
        f10917f.release(this);
    }
}