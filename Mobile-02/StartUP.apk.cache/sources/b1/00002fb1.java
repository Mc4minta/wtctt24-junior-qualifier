package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ShowEvent.java */
/* loaded from: classes2.dex */
class f extends com.facebook.react.uimanager.events.c<f> {
    /* JADX INFO: Access modifiers changed from: protected */
    public f(int i2) {
        super(i2);
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), null);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topShow";
    }
}