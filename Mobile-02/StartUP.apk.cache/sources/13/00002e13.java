package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;

/* compiled from: PreAllocateViewMountItem.java */
/* loaded from: classes2.dex */
public class h implements g {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4822b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4823c;

    /* renamed from: d  reason: collision with root package name */
    private final ReadableMap f4824d;

    /* renamed from: e  reason: collision with root package name */
    private final h0 f4825e;

    /* renamed from: f  reason: collision with root package name */
    private final i0 f4826f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4827g;

    public h(i0 i0Var, int i2, int i3, String str, ReadableMap readableMap, h0 h0Var, boolean z) {
        this.f4826f = i0Var;
        this.a = str;
        this.f4822b = i2;
        this.f4824d = readableMap;
        this.f4825e = h0Var;
        this.f4823c = i3;
        this.f4827g = z;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        if (com.facebook.react.fabric.c.a) {
            e.f.d.d.a.b("FabricUIManager", "Executing pre-allocation of: " + toString());
        }
        throw null;
    }

    public String toString() {
        return "PreAllocateViewMountItem [" + this.f4823c + "] - component: " + this.a + " rootTag: " + this.f4822b + " isLayoutable: " + this.f4827g;
    }
}