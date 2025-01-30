package com.coinbase.wallet.wallets.di;

import android.app.Application;
import android.content.Context;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.wallets.di.qualifier.WalletApiUrl;
import kotlin.Metadata;

/* compiled from: CryptoComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/wallets/di/CryptoComponent;", "", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "Landroid/app/Application;", "application", "()Landroid/app/Application;", "Landroid/content/Context;", "context", "()Landroid/content/Context;", "Factory", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface CryptoComponent {

    /* compiled from: CryptoComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/wallets/di/CryptoComponent$Factory;", "", "Landroid/app/Application;", "application", "Landroid/content/Context;", "context", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "", "walletApiUrl", "Lcom/coinbase/wallet/wallets/di/CryptoComponent;", "create", "(Landroid/app/Application;Landroid/content/Context;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;)Lcom/coinbase/wallet/wallets/di/CryptoComponent;", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface Factory {
        CryptoComponent create(Application application, Context context, Tracing tracing, @WalletApiUrl String str);
    }

    Application application();

    CipherCoreInterface cipherCore();

    Context context();
}