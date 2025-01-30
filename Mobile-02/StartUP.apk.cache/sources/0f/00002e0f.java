package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;

/* compiled from: DispatchIntCommandMountItem.java */
/* loaded from: classes2.dex */
public class d extends c {

    /* renamed from: b  reason: collision with root package name */
    private final int f4814b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4815c;

    /* renamed from: d  reason: collision with root package name */
    private final ReadableArray f4816d;

    public d(int i2, int i3, ReadableArray readableArray) {
        this.f4814b = i2;
        this.f4815c = i3;
        this.f4816d = readableArray;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        throw null;
    }

    public String toString() {
        return "DispatchIntCommandMountItem [" + this.f4814b + "] " + this.f4815c;
    }
}