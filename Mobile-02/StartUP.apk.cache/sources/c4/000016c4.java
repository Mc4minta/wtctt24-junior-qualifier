package com.coinbase.wallet.consumer.repositories;

import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.core.util.Optional;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAccountsRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062>\u0010\u0005\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/core/util/Optional;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsRepository$observeConsumerAccessToken$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Optional<? extends String>, ? extends Optional<? extends ConsumerUser>>, kotlin.x> {
    final /* synthetic */ h.c.s<kotlin.x> $walletAddressesObservable;
    final /* synthetic */ ConsumerAccountsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAccountsRepository$observeConsumerAccessToken$2(ConsumerAccountsRepository consumerAccountsRepository, h.c.s<kotlin.x> sVar) {
        super(1);
        this.this$0 = consumerAccountsRepository;
        this.$walletAddressesObservable = sVar;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends Optional<? extends String>, ? extends Optional<? extends ConsumerUser>> oVar) {
        invoke2((kotlin.o<Optional<String>, Optional<ConsumerUser>>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<Optional<String>, Optional<ConsumerUser>> oVar) {
        h.c.k0.a aVar;
        h.c.k0.a aVar2;
        if (oVar.a().toNullable() == null) {
            aVar2 = this.this$0.coinsDisposeBag;
            aVar2.d();
            return;
        }
        h.c.s<kotlin.x> walletAddressesObservable = this.$walletAddressesObservable;
        kotlin.jvm.internal.m.f(walletAddressesObservable, "walletAddressesObservable");
        h.c.k0.b subscribe = Observable_AnalyticsKt.logError$default(walletAddressesObservable, "Error uploading addresses to consumer", null, 2, null).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "walletAddressesObservable\n                            .logError(\"Error uploading addresses to consumer\")\n                            .subscribe()");
        aVar = this.this$0.coinsDisposeBag;
        h.c.t0.a.a(subscribe, aVar);
    }
}