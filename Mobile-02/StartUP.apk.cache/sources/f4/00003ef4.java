package com.reactnativecommunity.webview.c;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TopShouldStartLoadWithRequestEvent.kt */
/* loaded from: classes2.dex */
public final class h extends com.facebook.react.uimanager.events.c<h> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f10796f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final WritableMap f10797g;

    /* compiled from: TopShouldStartLoadWithRequestEvent.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(int i2, WritableMap mData) {
        super(i2);
        m.h(mData, "mData");
        this.f10797g = mData;
        mData.putString("navigationType", "other");
        mData.putBoolean("isTopFrame", true);
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rctEventEmitter) {
        m.h(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(i(), "topShouldStartLoadWithRequest", this.f10797g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topShouldStartLoadWithRequest";
    }
}