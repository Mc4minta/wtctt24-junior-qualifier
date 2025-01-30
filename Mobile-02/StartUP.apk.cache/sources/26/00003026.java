package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ReactTextInputSubmitEditingEvent.java */
/* loaded from: classes2.dex */
class n extends com.facebook.react.uimanager.events.c<n> {

    /* renamed from: f  reason: collision with root package name */
    private String f5523f;

    public n(int i2, String str) {
        super(i2);
        this.f5523f = str;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", i());
        createMap.putString(TextBundle.TEXT_ENTRY, this.f5523f);
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topSubmitEditing";
    }
}