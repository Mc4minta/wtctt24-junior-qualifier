package com.reactnativecommunity.webview.c;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TopLoadingFinishEvent.kt */
/* loaded from: classes2.dex */
public final class c extends com.facebook.react.uimanager.events.c<c> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f10786f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final WritableMap f10787g;

    /* compiled from: TopLoadingFinishEvent.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, WritableMap mEventData) {
        super(i2);
        m.h(mEventData, "mEventData");
        this.f10787g = mEventData;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rctEventEmitter) {
        m.h(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(i(), f(), this.f10787g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topLoadingFinish";
    }
}