package com.coinbase.walletengine;

import android.webkit.JavascriptInterface;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.walletengine.extensions.TraceKey_WalletEngineKt;
import com.coinbase.walletengine.models.ResponseMessage;
import h.c.d0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WalletEngineJavaScriptInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/walletengine/WalletEngineJavaScriptInterface;", "", "", "json", "Lkotlin/x;", "postMessage", "(Ljava/lang/String;)V", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "getWalletEngine", "()Lcom/coinbase/walletengine/WalletEngine;", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletEngineJavaScriptInterface {
    private final Tracing tracer;
    private final WalletEngine walletEngine;

    public WalletEngineJavaScriptInterface(WalletEngine walletEngine, Tracing tracer) {
        m.g(walletEngine, "walletEngine");
        m.g(tracer, "tracer");
        this.walletEngine = walletEngine;
        this.tracer = tracer;
    }

    public final WalletEngine getWalletEngine() {
        return this.walletEngine;
    }

    @JavascriptInterface
    public final void postMessage(String json) {
        m.g(json, "json");
        try {
            ResponseMessage fromJson = ResponseMessage.Companion.getJsonAdapter$wallet_engine_release().fromJson(json);
            if (fromJson == null) {
                return;
            }
            this.tracer.stop(TraceKey_WalletEngineKt.callTrace$default(TraceKey.Companion, fromJson.getId(), null, 2, null));
            d0<String> remove = getWalletEngine().getCallMap$wallet_engine_release().remove(Integer.valueOf(fromJson.getId()));
            if (remove == null || remove.isDisposed()) {
                return;
            }
            if (fromJson.getError() != null) {
                remove.onError(new WalletEngineException(fromJson.getError()));
            } else {
                remove.onSuccess(fromJson.getValueJSON());
            }
        } catch (Throwable unused) {
        }
    }
}