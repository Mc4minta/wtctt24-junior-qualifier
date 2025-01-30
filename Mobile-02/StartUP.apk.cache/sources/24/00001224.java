package com.coinbase.wallet.application.service;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.StoreKeys_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import java.math.BigInteger;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApplicationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "wallets", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ApplicationService$observeBalanceUpdates$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Wallet>, x> {
    final /* synthetic */ ApplicationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationService$observeBalanceUpdates$4(ApplicationService applicationService) {
        super(1);
        this.this$0 = applicationService;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(List<? extends Wallet> list) {
        invoke2((List<Wallet>) list);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Wallet> wallets) {
        Provider provider;
        Provider provider2;
        kotlin.jvm.internal.m.f(wallets, "wallets");
        ApplicationService applicationService = this.this$0;
        for (Wallet wallet : wallets) {
            SharedPrefsStoreKey<BigInteger> balance = StoreKeys_ApplicationKt.balance(StoreKeys.INSTANCE, wallet.getBlockchain(), wallet.getCurrencyCode());
            provider = applicationService.store;
            BigInteger bigInteger = (BigInteger) ((StoreInterface) provider.get()).get(balance);
            if (!kotlin.jvm.internal.m.c(wallet.getBalance(), bigInteger)) {
                provider2 = applicationService.store;
                ((StoreInterface) provider2.get()).set(balance, wallet.getBalance());
                if (bigInteger != null) {
                    Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.balanceUpdate(AnalyticsEvent.Companion, wallet.getBlockchain(), wallet.getCurrencyCode()));
                }
            }
        }
    }
}