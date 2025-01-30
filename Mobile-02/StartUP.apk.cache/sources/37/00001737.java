package com.coinbase.wallet.consumer.utils;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import e.f.m.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: RNLaunchMailAppPackage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/consumer/utils/RNLaunchMailAppPackage;", "Le/f/m/p;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "", "Lcom/facebook/react/uimanager/ViewManager;", "createViewManagers", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;", "Lcom/facebook/react/bridge/NativeModule;", "createNativeModules", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RNLaunchMailAppPackage implements p {
    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> b2;
        m.g(reactContext, "reactContext");
        b2 = q.b(new RNLaunchMailAppModule(reactContext));
        return b2;
    }

    @Override // e.f.m.p
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager<?, ?>> g2;
        m.g(reactContext, "reactContext");
        g2 = r.g();
        return g2;
    }
}