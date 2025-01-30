package com.coinbase.wallet.lending.di;

import android.app.Application;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.lending.di.qualifier.ApiUrl;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.WalletEngine;
import h.c.s;
import kotlin.Metadata;

/* compiled from: LendComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coinbase/wallet/lending/di/LendComponent;", "Lcom/coinbase/wallet/lending/di/LendContainer;", "Factory", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface LendComponent extends LendContainer {

    /* compiled from: LendComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JQ\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/lending/di/LendComponent$Factory;", "", "Landroid/app/Application;", "application", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "walletAddressObservable", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "", "walletApiUrl", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/lending/di/LendComponent;", "create", "(Landroid/app/Application;Lcom/coinbase/walletengine/WalletEngine;Lh/c/s;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/lending/di/LendComponent;", "lending_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        LendComponent create(Application application, WalletEngine walletEngine, s<WalletAddress> sVar, Tracing tracing, @ApiUrl String str, StoreInterface storeInterface);
    }
}