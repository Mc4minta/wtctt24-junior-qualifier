package com.facebook.react.views.swiperefresh;

import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.c;

/* compiled from: RefreshEvent.java */
/* loaded from: classes2.dex */
public class b extends c<b> {
    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i2) {
        super(i2);
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), null);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topRefresh";
    }
}