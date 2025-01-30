package com.coinbase.wallet.wallets.di;

import android.app.Application;
import android.content.Context;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.wallets.di.qualifier.WalletApiUrl;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: CryptoContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/wallets/di/CryptoContainer;", "", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "Landroid/app/Application;", "application", "()Landroid/app/Application;", "Landroid/content/Context;", "context", "()Landroid/content/Context;", "Lcom/coinbase/wallet/wallets/di/CryptoComponent;", "component$delegate", "Lkotlin/h;", "getComponent$wallets_release", "()Lcom/coinbase/wallet/wallets/di/CryptoComponent;", "component", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "", "walletApiUrl", "<init>", "(Landroid/app/Application;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CryptoContainer {
    private final h component$delegate;

    public CryptoContainer(Application application, Tracing tracer, @WalletApiUrl String walletApiUrl) {
        h b2;
        m.g(application, "application");
        m.g(tracer, "tracer");
        m.g(walletApiUrl, "walletApiUrl");
        b2 = k.b(new CryptoContainer$component$2(application, tracer, walletApiUrl));
        this.component$delegate = b2;
    }

    public final Application application() {
        return getComponent$wallets_release().application();
    }

    public final CipherCoreInterface cipherCore() {
        return getComponent$wallets_release().cipherCore();
    }

    public final Context context() {
        return getComponent$wallets_release().context();
    }

    public final CryptoComponent getComponent$wallets_release() {
        return (CryptoComponent) this.component$delegate.getValue();
    }
}