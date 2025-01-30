package com.facebook.react.views.scroll;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.o;

/* compiled from: ScrollEvent.java */
/* loaded from: classes2.dex */
public class h extends com.facebook.react.uimanager.events.c<h> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<h> f5378f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private int f5379g;

    /* renamed from: h  reason: collision with root package name */
    private int f5380h;

    /* renamed from: i  reason: collision with root package name */
    private double f5381i;

    /* renamed from: j  reason: collision with root package name */
    private double f5382j;

    /* renamed from: k  reason: collision with root package name */
    private int f5383k;

    /* renamed from: l  reason: collision with root package name */
    private int f5384l;
    private int m;
    private int n;
    private i o;

    private h() {
    }

    private void m(int i2, i iVar, int i3, int i4, float f2, float f3, int i5, int i6, int i7, int i8) {
        super.j(i2);
        this.o = iVar;
        this.f5379g = i3;
        this.f5380h = i4;
        this.f5381i = f2;
        this.f5382j = f3;
        this.f5383k = i5;
        this.f5384l = i6;
        this.m = i7;
        this.n = i8;
    }

    public static h n(int i2, i iVar, int i3, int i4, float f2, float f3, int i5, int i6, int i7, int i8) {
        h acquire = f5378f.acquire();
        if (acquire == null) {
            acquire = new h();
        }
        acquire.m(i2, iVar, i3, i4, f2, f3, i5, i6, i7, i8);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("top", 0.0d);
        createMap.putDouble("bottom", 0.0d);
        createMap.putDouble("left", 0.0d);
        createMap.putDouble("right", 0.0d);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("x", o.a(this.f5379g));
        createMap2.putDouble("y", o.a(this.f5380h));
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("width", o.a(this.f5383k));
        createMap3.putDouble("height", o.a(this.f5384l));
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putDouble("width", o.a(this.m));
        createMap4.putDouble("height", o.a(this.n));
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putDouble("x", this.f5381i);
        createMap5.putDouble("y", this.f5382j);
        WritableMap createMap6 = Arguments.createMap();
        createMap6.putMap("contentInset", createMap);
        createMap6.putMap("contentOffset", createMap2);
        createMap6.putMap("contentSize", createMap3);
        createMap6.putMap("layoutMeasurement", createMap4);
        createMap6.putMap("velocity", createMap5);
        createMap6.putInt("target", i());
        createMap6.putBoolean("responderIgnoreScroll", true);
        return createMap6;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return this.o == i.SCROLL;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), o());
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return i.h((i) e.f.k.a.a.c(this.o));
    }

    @Override // com.facebook.react.uimanager.events.c
    public void l() {
        f5378f.release(this);
    }
}