package com.reactnativecommunity.webview;

import com.facebook.react.bridge.ReactApplicationContext;
import e.f.m.p;
import java.util.List;
import kotlin.a0.q;
import kotlin.jvm.internal.m;

/* compiled from: RNCWebViewPackage.kt */
/* loaded from: classes2.dex */
public final class a implements p {
    @Override // e.f.m.p
    public List<RNCWebViewModule> createNativeModules(ReactApplicationContext reactContext) {
        List<RNCWebViewModule> b2;
        m.h(reactContext, "reactContext");
        b2 = q.b(new RNCWebViewModule(reactContext));
        return b2;
    }

    @Override // e.f.m.p
    public List<RNCWebViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<RNCWebViewManager> b2;
        m.h(reactContext, "reactContext");
        b2 = q.b(new RNCWebViewManager());
        return b2;
    }
}