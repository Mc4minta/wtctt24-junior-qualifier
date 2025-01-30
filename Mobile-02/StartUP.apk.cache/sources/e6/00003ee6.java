package com.reactnativecommunity.webview.c;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TopHttpErrorEvent.kt */
/* loaded from: classes2.dex */
public final class a extends com.facebook.react.uimanager.events.c<a> {

    /* renamed from: f  reason: collision with root package name */
    public static final C0229a f10782f = new C0229a(null);

    /* renamed from: g  reason: collision with root package name */
    private final WritableMap f10783g;

    /* compiled from: TopHttpErrorEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0229a {
        private C0229a() {
        }

        public /* synthetic */ C0229a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i2, WritableMap mEventData) {
        super(i2);
        m.h(mEventData, "mEventData");
        this.f10783g = mEventData;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rctEventEmitter) {
        m.h(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(i(), f(), this.f10783g);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topHttpError";
    }
}