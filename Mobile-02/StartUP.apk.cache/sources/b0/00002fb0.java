package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RequestCloseEvent.java */
/* loaded from: classes2.dex */
class e extends com.facebook.react.uimanager.events.c<e> {
    /* JADX INFO: Access modifiers changed from: protected */
    public e(int i2) {
        super(i2);
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), null);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topRequestClose";
    }
}