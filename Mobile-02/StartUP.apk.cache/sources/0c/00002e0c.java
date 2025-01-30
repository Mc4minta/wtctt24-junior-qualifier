package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;

/* compiled from: CreateMountItem.java */
/* loaded from: classes2.dex */
public class a implements g {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4808b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4809c;

    /* renamed from: d  reason: collision with root package name */
    private final i0 f4810d;

    /* renamed from: e  reason: collision with root package name */
    private final ReadableMap f4811e;

    /* renamed from: f  reason: collision with root package name */
    private final h0 f4812f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4813g;

    public a(i0 i0Var, int i2, int i3, String str, ReadableMap readableMap, h0 h0Var, boolean z) {
        this.f4810d = i0Var;
        this.a = str;
        this.f4808b = i2;
        this.f4809c = i3;
        this.f4811e = readableMap;
        this.f4812f = h0Var;
        this.f4813g = z;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        throw null;
    }

    public String toString() {
        return "CreateMountItem [" + this.f4809c + "] - component: " + this.a + " - rootTag: " + this.f4808b + " - isLayoutable: " + this.f4813g;
    }
}