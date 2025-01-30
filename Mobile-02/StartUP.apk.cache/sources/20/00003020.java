package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ReactTextInputEvent.java */
/* loaded from: classes2.dex */
public class h extends com.facebook.react.uimanager.events.c<h> {

    /* renamed from: f  reason: collision with root package name */
    private String f5510f;

    /* renamed from: g  reason: collision with root package name */
    private String f5511g;

    /* renamed from: h  reason: collision with root package name */
    private int f5512h;

    /* renamed from: i  reason: collision with root package name */
    private int f5513i;

    public h(int i2, String str, String str2, int i3, int i4) {
        super(i2);
        this.f5510f = str;
        this.f5511g = str2;
        this.f5512h = i3;
        this.f5513i = i4;
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("start", this.f5512h);
        createMap2.putDouble("end", this.f5513i);
        createMap.putString(TextBundle.TEXT_ENTRY, this.f5510f);
        createMap.putString("previousText", this.f5511g);
        createMap.putMap("range", createMap2);
        createMap.putInt("target", i());
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
        return "topTextInput";
    }
}