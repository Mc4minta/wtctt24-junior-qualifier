package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactTextInputKeyPressEvent.java */
/* loaded from: classes2.dex */
public class j extends com.facebook.react.uimanager.events.c<h> {

    /* renamed from: f  reason: collision with root package name */
    private String f5514f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i2, String str) {
        super(i2);
        this.f5514f = str;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("key", this.f5514f);
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
        return "topKeyPress";
    }
}