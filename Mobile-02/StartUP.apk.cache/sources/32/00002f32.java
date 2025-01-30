package com.facebook.react.uimanager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: OnLayoutEvent.java */
/* loaded from: classes2.dex */
public class n extends com.facebook.react.uimanager.events.c<n> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<n> f5170f = new androidx.core.util.g<>(20);

    /* renamed from: g  reason: collision with root package name */
    private int f5171g;

    /* renamed from: h  reason: collision with root package name */
    private int f5172h;

    /* renamed from: i  reason: collision with root package name */
    private int f5173i;

    /* renamed from: j  reason: collision with root package name */
    private int f5174j;

    private n() {
    }

    public static n n(int i2, int i3, int i4, int i5, int i6) {
        n acquire = f5170f.acquire();
        if (acquire == null) {
            acquire = new n();
        }
        acquire.m(i2, i3, i4, i5, i6);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", o.a(this.f5171g));
        createMap.putDouble("y", o.a(this.f5172h));
        createMap.putDouble("width", o.a(this.f5173i));
        createMap.putDouble("height", o.a(this.f5174j));
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("layout", createMap);
        createMap2.putInt("target", i());
        rCTEventEmitter.receiveEvent(i(), f(), createMap2);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topLayout";
    }

    @Override // com.facebook.react.uimanager.events.c
    public void l() {
        f5170f.release(this);
    }

    protected void m(int i2, int i3, int i4, int i5, int i6) {
        super.j(i2);
        this.f5171g = i3;
        this.f5172h = i4;
        this.f5173i = i5;
        this.f5174j = i6;
    }
}