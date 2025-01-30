package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrackingAnimatedNode.java */
/* loaded from: classes2.dex */
public class q extends b {

    /* renamed from: e  reason: collision with root package name */
    private final l f4766e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4767f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4768g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4769h;

    /* renamed from: i  reason: collision with root package name */
    private final JavaOnlyMap f4770i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ReadableMap readableMap, l lVar) {
        this.f4766e = lVar;
        this.f4767f = readableMap.getInt("animationId");
        this.f4768g = readableMap.getInt("toValue");
        this.f4769h = readableMap.getInt("value");
        this.f4770i = JavaOnlyMap.deepClone(readableMap.getMap("animationConfig"));
    }

    @Override // com.facebook.react.animated.b
    public void e() {
        this.f4770i.putDouble("toValue", ((s) this.f4766e.l(this.f4768g)).i());
        this.f4766e.t(this.f4767f, this.f4769h, this.f4770i, null);
    }
}