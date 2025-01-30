package com.coinbase.wallet.consumer.utils;

import com.coinbase.wallet.consumer.utils.UMOEventHandler;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import e.f.m.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: UMOPackage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/utils/UMOPackage;", "Le/f/m/p;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactApplicationContext", "", "Lcom/facebook/react/bridge/NativeModule;", "createNativeModules", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;", "Lcom/facebook/react/uimanager/ViewManager;", "createViewManagers", "Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;", "refreshToken", "Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;", "getRefreshToken", "()Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;", "Ljava/lang/Runnable;", "onSuccess", "Ljava/lang/Runnable;", "onSignOut", "<init>", "(Ljava/lang/Runnable;Ljava/lang/Runnable;Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UMOPackage implements p {
    private final Runnable onSignOut;
    private final Runnable onSuccess;
    private final UMOEventHandler.RefreshTokenCallback refreshToken;

    public UMOPackage(Runnable onSuccess, Runnable onSignOut, UMOEventHandler.RefreshTokenCallback refreshToken) {
        m.g(onSuccess, "onSuccess");
        m.g(onSignOut, "onSignOut");
        m.g(refreshToken, "refreshToken");
        this.onSuccess = onSuccess;
        this.onSignOut = onSignOut;
        this.refreshToken = refreshToken;
    }

    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> b2;
        m.g(reactApplicationContext, "reactApplicationContext");
        b2 = q.b(new UMOEventHandler(reactApplicationContext, this.onSuccess, this.onSignOut, this.refreshToken));
        return b2;
    }

    @Override // e.f.m.p
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ViewManager<?, ?>> g2;
        m.g(reactApplicationContext, "reactApplicationContext");
        g2 = r.g();
        return g2;
    }

    public final UMOEventHandler.RefreshTokenCallback getRefreshToken() {
        return this.refreshToken;
    }
}