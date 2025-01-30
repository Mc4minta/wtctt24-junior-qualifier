package com.facebook.react.views.view;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ViewGroupClickEvent.java */
/* loaded from: classes2.dex */
public class g extends com.facebook.react.uimanager.events.c<g> {
    public g(int i2) {
        super(i2);
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), Arguments.createMap());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topClick";
    }
}