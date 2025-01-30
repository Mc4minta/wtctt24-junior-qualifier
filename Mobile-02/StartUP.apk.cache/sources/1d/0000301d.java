package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ReactTextChangedEvent.java */
/* loaded from: classes2.dex */
public class e extends com.facebook.react.uimanager.events.c<e> {

    /* renamed from: f  reason: collision with root package name */
    private String f5507f;

    /* renamed from: g  reason: collision with root package name */
    private int f5508g;

    public e(int i2, String str, int i3) {
        super(i2);
        this.f5507f = str;
        this.f5508g = i3;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(TextBundle.TEXT_ENTRY, this.f5507f);
        createMap.putInt("eventCount", this.f5508g);
        createMap.putInt("target", i());
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topChange";
    }
}