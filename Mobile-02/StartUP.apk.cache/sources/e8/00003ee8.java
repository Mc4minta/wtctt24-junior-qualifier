package com.reactnativecommunity.webview.c;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TopLoadingErrorEvent.kt */
/* loaded from: classes2.dex */
public final class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f10784f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final WritableMap f10785g;

    /* compiled from: TopLoadingErrorEvent.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i2, WritableMap mEventData) {
        super(i2);
        m.h(mEventData, "mEventData");
        this.f10785g = mEventData;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rctEventEmitter) {
        m.h(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(i(), f(), this.f10785g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topLoadingError";
    }
}