package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import kotlin.Metadata;

/* compiled from: ConsumerSendTwoFactorViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSendTwoFactorViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "sendRequest", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "selectedTransfer", "", "twoFactor", "Lh/c/b0;", "Lkotlin/x;", "transfer", "(Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;Lcom/coinbase/wallet/consumer/models/AvailableTransfer;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendTwoFactorViewModel extends androidx.lifecycle.b0 {
    private final ConsumerTransferRepository consumerTransferRepository;

    public ConsumerSendTwoFactorViewModel(ConsumerTransferRepository consumerTransferRepository) {
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        this.consumerTransferRepository = consumerTransferRepository;
    }

    public final h.c.b0<kotlin.x> transfer(TransferMoneyRequest sendRequest, AvailableTransfer selectedTransfer, String twoFactor) {
        kotlin.jvm.internal.m.g(sendRequest, "sendRequest");
        kotlin.jvm.internal.m.g(selectedTransfer, "selectedTransfer");
        kotlin.jvm.internal.m.g(twoFactor, "twoFactor");
        h.c.b0<kotlin.x> send = this.consumerTransferRepository.send(sendRequest.getAccount(), sendRequest.getWallet(), selectedTransfer.getTransferAmount(), selectedTransfer.getSendFee(), sendRequest.getAccount().getCurrencyCode(), sendRequest.getWallet().getBlockchain(), sendRequest.getSupportsDestinationTag() ? Boolean.TRUE : null, twoFactor);
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        h.c.b0 onSubscribeTrack = Single_AnalyticsKt.onSubscribeTrack(send, AnalyticsEvent_ConsumerKt.consumerTransferTwoFaSubmitted(companion));
        kotlin.jvm.internal.m.f(onSubscribeTrack, "consumerTransferRepository\n            .send(\n                account = sendRequest.account,\n                receiveWallet = sendRequest.wallet,\n                amount = selectedTransfer.transferAmount,\n                estimatedFee = selectedTransfer.sendFee,\n                currencyCode = sendRequest.account.currencyCode,\n                blockchain = sendRequest.wallet.blockchain,\n                noDestinationTag = if (sendRequest.supportsDestinationTag) true else null,\n                twoFactor = twoFactor\n            )\n            .onSubscribeTrack(AnalyticsEvent.consumerTransferTwoFaSubmitted())");
        h.c.b0 onSuccessTrack = Single_AnalyticsKt.onSuccessTrack(onSubscribeTrack, AnalyticsEvent_ConsumerKt.consumerTransferTwoFaSuccess(companion));
        kotlin.jvm.internal.m.f(onSuccessTrack, "consumerTransferRepository\n            .send(\n                account = sendRequest.account,\n                receiveWallet = sendRequest.wallet,\n                amount = selectedTransfer.transferAmount,\n                estimatedFee = selectedTransfer.sendFee,\n                currencyCode = sendRequest.account.currencyCode,\n                blockchain = sendRequest.wallet.blockchain,\n                noDestinationTag = if (sendRequest.supportsDestinationTag) true else null,\n                twoFactor = twoFactor\n            )\n            .onSubscribeTrack(AnalyticsEvent.consumerTransferTwoFaSubmitted())\n            .onSuccessTrack(AnalyticsEvent.consumerTransferTwoFaSuccess())");
        h.c.b0<kotlin.x> onErrorTrack = Single_AnalyticsKt.onErrorTrack(onSuccessTrack, AnalyticsEvent_ConsumerKt.consumerTransferTwoFaError(companion));
        kotlin.jvm.internal.m.f(onErrorTrack, "consumerTransferRepository\n            .send(\n                account = sendRequest.account,\n                receiveWallet = sendRequest.wallet,\n                amount = selectedTransfer.transferAmount,\n                estimatedFee = selectedTransfer.sendFee,\n                currencyCode = sendRequest.account.currencyCode,\n                blockchain = sendRequest.wallet.blockchain,\n                noDestinationTag = if (sendRequest.supportsDestinationTag) true else null,\n                twoFactor = twoFactor\n            )\n            .onSubscribeTrack(AnalyticsEvent.consumerTransferTwoFaSubmitted())\n            .onSuccessTrack(AnalyticsEvent.consumerTransferTwoFaSuccess())\n            .onErrorTrack(AnalyticsEvent.consumerTransferTwoFaError())");
        return onErrorTrack;
    }
}