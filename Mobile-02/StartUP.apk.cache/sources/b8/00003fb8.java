package com.swmansion.gesturehandler.react;

import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RNGestureHandlerEvent.java */
/* loaded from: classes2.dex */
public class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<b> f10905f = new androidx.core.util.g<>(7);

    /* renamed from: g  reason: collision with root package name */
    private WritableMap f10906g;

    /* renamed from: h  reason: collision with root package name */
    private short f10907h;

    private b() {
    }

    private void m(e.i.a.b bVar, c cVar) {
        super.j(bVar.r().getId());
        WritableMap createMap = Arguments.createMap();
        this.f10906g = createMap;
        if (cVar != null) {
            cVar.a(bVar, createMap);
        }
        this.f10906g.putInt("handlerTag", bVar.q());
        this.f10906g.putInt(ApiConstants.STATE, bVar.p());
        this.f10907h = bVar.j();
    }

    public static b n(e.i.a.b bVar, c cVar) {
        b acquire = f10905f.acquire();
        if (acquire == null) {
            acquire = new b();
        }
        acquire.m(bVar, cVar);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return true;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), "onGestureHandlerEvent", this.f10906g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return this.f10907h;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.c
    public void l() {
        this.f10906g = null;
        f10905f.release(this);
    }
}