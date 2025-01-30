package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.a;

/* compiled from: GuardedFrameCallback.java */
/* loaded from: classes2.dex */
public abstract class e extends a.AbstractC0115a {

    /* renamed from: b  reason: collision with root package name */
    private final ReactContext f5049b;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(ReactContext reactContext) {
        this.f5049b = reactContext;
    }

    @Override // com.facebook.react.modules.core.a.AbstractC0115a
    public final void a(long j2) {
        try {
            c(j2);
        } catch (RuntimeException e2) {
            this.f5049b.handleException(e2);
        }
    }

    protected abstract void c(long j2);
}