package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;

/* compiled from: DispatchStringCommandMountItem.java */
/* loaded from: classes2.dex */
public class e extends c {

    /* renamed from: b  reason: collision with root package name */
    private final int f4817b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4818c;

    /* renamed from: d  reason: collision with root package name */
    private final ReadableArray f4819d;

    public e(int i2, String str, ReadableArray readableArray) {
        this.f4817b = i2;
        this.f4818c = str;
        this.f4819d = readableArray;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        throw null;
    }

    public String toString() {
        return "DispatchStringCommandMountItem [" + this.f4817b + "] " + this.f4818c;
    }
}