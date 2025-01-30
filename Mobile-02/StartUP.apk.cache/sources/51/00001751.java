package com.coinbase.wallet.consumer.viewmodels;

import android.os.Bundle;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AvailableSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerEvent;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerViewState;
import com.coinbase.wallet.consumer.models.ConsumerAvailableTransferContainer;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.models.ReceivableWallet;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailableTransferContainer;", "kotlin.jvm.PlatformType", "Ljava/math/BigDecimal;", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel$fetchMaxTransferableAmount$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends ConsumerAvailableTransferContainer, ? extends BigDecimal>, kotlin.x> {
    final /* synthetic */ UUID $uuid;
    final /* synthetic */ ConsumerAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerViewModel$fetchMaxTransferableAmount$2(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, UUID uuid) {
        super(1);
        this.this$0 = consumerAmountPickerViewModel;
        this.$uuid = uuid;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends ConsumerAvailableTransferContainer, ? extends BigDecimal> oVar) {
        invoke2((kotlin.o<ConsumerAvailableTransferContainer, ? extends BigDecimal>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<ConsumerAvailableTransferContainer, ? extends BigDecimal> oVar) {
        ReceivableWallet receivableWallet;
        ConsumerAmountPickerViewState consumerAmountPickerViewState;
        ConsumerAmountPickerViewState copy;
        ReceivableWallet receivableWallet2;
        IFiatCurrencyRepository iFiatCurrencyRepository;
        AmountViewModel amountViewModel;
        ReceivableWallet receivableWallet3;
        boolean onrampEnabled;
        boolean onrampEnabled2;
        h.c.v0.b bVar;
        PromptDialogHelper.Properties generateWblPrompt;
        h.c.v0.b bVar2;
        ConsumerAccount consumerAccount;
        h.c.v0.b bVar3;
        ConsumerAccount consumerAccount2;
        AmountViewModel amountViewModel2;
        ConsumerAvailableTransferContainer a = oVar.a();
        BigDecimal exchangeRate = oVar.b();
        BigInteger transferAmount = a.getTransferAmount();
        receivableWallet = this.this$0.wallet;
        if (receivableWallet != null) {
            BigDecimal stripTrailingZeros = BigInteger_CommonKt.asBigDecimal(transferAmount, receivableWallet.getDecimals()).setScale(a.getAccount().getTransferDecimals(), RoundingMode.DOWN).stripTrailingZeros();
            ConsumerAmountPickerViewModel consumerAmountPickerViewModel = this.this$0;
            consumerAmountPickerViewState = consumerAmountPickerViewModel.state;
            copy = consumerAmountPickerViewState.copy((r32 & 1) != 0 ? consumerAmountPickerViewState.maxAmount : stripTrailingZeros, (r32 & 2) != 0 ? consumerAmountPickerViewState.isMaxButtonLoading : false, (r32 & 4) != 0 ? consumerAmountPickerViewState.isNextButtonVisible : false, (r32 & 8) != 0 ? consumerAmountPickerViewState.isNextButtonLoading : false, (r32 & 16) != 0 ? consumerAmountPickerViewState.isFiatSelected : false, (r32 & 32) != 0 ? consumerAmountPickerViewState.primaryText : null, (r32 & 64) != 0 ? consumerAmountPickerViewState.secondaryText : null, (r32 & 128) != 0 ? consumerAmountPickerViewState.swapButtonEnabled : false, (r32 & 256) != 0 ? consumerAmountPickerViewState.currencyCode : null, (r32 & 512) != 0 ? consumerAmountPickerViewState.keyboardLocale : null, (r32 & 1024) != 0 ? consumerAmountPickerViewState.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? consumerAmountPickerViewState.cryptoBalance : null, (r32 & 4096) != 0 ? consumerAmountPickerViewState.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? consumerAmountPickerViewState.isInsufficientBalance : false, (r32 & 16384) != 0 ? consumerAmountPickerViewState.wallet : null);
            consumerAmountPickerViewModel.setState(copy);
            ConsumerAmountPickerViewModel consumerAmountPickerViewModel2 = this.this$0;
            String plainString = stripTrailingZeros.toPlainString();
            kotlin.jvm.internal.m.f(plainString, "maxAmount.toPlainString()");
            consumerAmountPickerViewModel2.updateCryptoAmount(plainString, this.$uuid);
            List<AvailableTransfer> availableTransfers = a.getAvailableTransfers();
            ConsumerAccount account = a.getAccount();
            receivableWallet2 = this.this$0.wallet;
            if (receivableWallet2 != null) {
                int decimals = receivableWallet2.getDecimals();
                TransferValue.EntireBalance entireBalance = TransferValue.EntireBalance.INSTANCE;
                kotlin.jvm.internal.m.f(exchangeRate, "exchangeRate");
                iFiatCurrencyRepository = this.this$0.currencyRepository;
                String rawValue = iFiatCurrencyRepository.getActiveCurrency().getCode().getRawValue();
                amountViewModel = this.this$0.amountViewModel;
                boolean isFiatSelected = amountViewModel.isFiatSelected();
                boolean z = account.getDestinationTagName() != null;
                receivableWallet3 = this.this$0.wallet;
                if (receivableWallet3 != null) {
                    onrampEnabled = this.this$0.getOnrampEnabled();
                    TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest(account, decimals, entireBalance, availableTransfers, exchangeRate, rawValue, isFiatSelected, z, receivableWallet3, onrampEnabled);
                    this.this$0.cachedTransfer = transferMoneyRequest;
                    if (stripTrailingZeros.compareTo(BigDecimal.ZERO) == 0) {
                        onrampEnabled2 = this.this$0.getOnrampEnabled();
                        if (onrampEnabled2) {
                            this.this$0.cachedTransferForTransferMethods = transferMoneyRequest;
                            Bundle createArgs$default = ConsumerTransferMethodsArgs.createArgs$default(ConsumerTransferMethodsArgs.INSTANCE, transferMoneyRequest, null, 2, null);
                            createArgs$default.putAll(ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment));
                            ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.consumerTransferMethodsFragment, createArgs$default, null, 4, null);
                            bVar3 = this.this$0.navigateSubject;
                            bVar3.onNext(viewModelNavRoute);
                            Analytics analytics = Analytics.INSTANCE;
                            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
                            consumerAccount2 = this.this$0.getConsumerAccount();
                            CurrencyCode currencyCode = consumerAccount2.getCurrencyCode();
                            amountViewModel2 = this.this$0.amountViewModel;
                            analytics.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerToTransferMethodsNavigated(companion, currencyCode, amountViewModel2.isFiatSelected(), this.$uuid));
                            return;
                        }
                        AvailableSendTransfer availableSendTransfer = (AvailableSendTransfer) kotlin.a0.p.Y(availableTransfers);
                        if (availableSendTransfer.isWblLimited()) {
                            generateWblPrompt = this.this$0.generateWblPrompt(availableSendTransfer);
                            bVar2 = this.this$0.eventSubject;
                            bVar2.onNext(new ConsumerAmountPickerEvent.ConsumerAmountPickerPrompt(generateWblPrompt));
                            Analytics analytics2 = Analytics.INSTANCE;
                            AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
                            consumerAccount = this.this$0.getConsumerAccount();
                            analytics2.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerWBLViewed(companion2, consumerAccount.getCurrencyCode(), this.$uuid));
                            return;
                        }
                        bVar = this.this$0.eventSubject;
                        bVar.onNext(new ConsumerAmountPickerEvent.FetchMaxAmountError(LocalizedStrings.INSTANCE.get(R.string.balance_not_enough_to_cover_fee)));
                        return;
                    }
                    return;
                }
                kotlin.jvm.internal.m.w("wallet");
                throw null;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }
}