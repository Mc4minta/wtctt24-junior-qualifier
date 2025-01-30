package com.coinbase.wallet.consumer.utils;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import e.f.m.p;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: NoopBugsnagPackage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/consumer/utils/NoopBugsnagPackage;", "Le/f/m/p;", "", "Ljava/lang/Class;", "Lcom/facebook/react/bridge/JavaScriptModule;", "createJSModules", "()Ljava/util/List;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "Lcom/facebook/react/uimanager/ViewManager;", "createViewManagers", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;", "Lcom/facebook/react/bridge/NativeModule;", "createNativeModules", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NoopBugsnagPackage implements p {
    public final List<Class<JavaScriptModule>> createJSModules() {
        List<Class<JavaScriptModule>> emptyList = Collections.emptyList();
        m.f(emptyList, "emptyList()");
        return emptyList;
    }

    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        m.g(reactContext, "reactContext");
        List<NativeModule> singletonList = Collections.singletonList(new NoopBugsnag(reactContext));
        m.f(singletonList, "singletonList(NoopBugsnag(reactContext))");
        return singletonList;
    }

    @Override // e.f.m.p
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        m.g(reactContext, "reactContext");
        List<ViewManager<?, ?>> emptyList = Collections.emptyList();
        m.f(emptyList, "emptyList()");
        return emptyList;
    }
}