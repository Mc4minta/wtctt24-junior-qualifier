package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: ValueAnimatedNode.java */
/* loaded from: classes2.dex */
class s extends b {

    /* renamed from: e  reason: collision with root package name */
    Object f4778e;

    /* renamed from: f  reason: collision with root package name */
    double f4779f;

    /* renamed from: g  reason: collision with root package name */
    double f4780g;

    /* renamed from: h  reason: collision with root package name */
    private c f4781h;

    public s() {
        this.f4778e = null;
        this.f4779f = Double.NaN;
        this.f4780g = 0.0d;
    }

    public void f() {
        this.f4780g += this.f4779f;
        this.f4779f = 0.0d;
    }

    public void g() {
        this.f4779f += this.f4780g;
        this.f4780g = 0.0d;
    }

    public Object h() {
        return this.f4778e;
    }

    public double i() {
        if (Double.isNaN(this.f4780g + this.f4779f)) {
            e();
        }
        return this.f4780g + this.f4779f;
    }

    public void j() {
        c cVar = this.f4781h;
        if (cVar == null) {
            return;
        }
        cVar.a(i());
    }

    public void k(c cVar) {
        this.f4781h = cVar;
    }

    public s(ReadableMap readableMap) {
        this.f4778e = null;
        this.f4779f = Double.NaN;
        this.f4780g = 0.0d;
        this.f4779f = readableMap.getDouble("value");
        this.f4780g = readableMap.getDouble("offset");
    }
}