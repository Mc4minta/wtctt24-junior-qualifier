package com.coinbase.wallet.consumer.viewmodels;

import android.os.Bundle;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
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
import com.coinbase.wallet.consumer.models.ConsumerTransferConfirmationArgs;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.models.ReceivableWallet;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailableTransferContainer;", "kotlin.jvm.PlatformType", "Ljava/math/BigDecimal;", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel$nextAction$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends ConsumerAvailableTransferContainer, ? extends BigDecimal>, kotlin.x> {
    final /* synthetic */ TransferValue.Amount $amount;
    final /* synthetic */ UUID $uuid;
    final /* synthetic */ ConsumerAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerViewModel$nextAction$2(ConsumerAmountPickerViewModel consumerAmountPickerViewModel, TransferValue.Amount amount, UUID uuid) {
        super(1);
        this.this$0 = consumerAmountPickerViewModel;
        this.$amount = amount;
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
        IFiatCurrencyRepository iFiatCurrencyRepository;
        AmountViewModel amountViewModel;
        ReceivableWallet receivableWallet2;
        boolean onrampEnabled;
        boolean z;
        ConsumerAmountPickerViewState consumerAmountPickerViewState;
        ConsumerAmountPickerViewState copy;
        boolean onrampEnabled2;
        PromptDialogHelper.Properties generateWblPrompt;
        ConsumerAccount consumerAccount;
        h.c.v0.b bVar;
        h.c.v0.b bVar2;
        ConsumerAccount consumerAccount2;
        AmountViewModel amountViewModel2;
        h.c.v0.b bVar3;
        boolean onrampEnabled3;
        ConsumerAccount consumerAccount3;
        AmountViewModel amountViewModel3;
        ConsumerAvailableTransferContainer a = oVar.a();
        BigDecimal exchangeRate = oVar.b();
        ConsumerAccount account = a.getAccount();
        receivableWallet = this.this$0.wallet;
        if (receivableWallet != null) {
            int decimals = receivableWallet.getDecimals();
            List<AvailableTransfer> availableTransfers = a.getAvailableTransfers();
            iFiatCurrencyRepository = this.this$0.currencyRepository;
            String rawValue = iFiatCurrencyRepository.getActiveCurrency().getCode().getRawValue();
            amountViewModel = this.this$0.amountViewModel;
            boolean isFiatSelected = amountViewModel.isFiatSelected();
            boolean z2 = true;
            boolean z3 = a.getAccount().getDestinationTagName() != null;
            receivableWallet2 = this.this$0.wallet;
            if (receivableWallet2 != null) {
                onrampEnabled = this.this$0.getOnrampEnabled();
                TransferValue.Amount amount = this.$amount;
                kotlin.jvm.internal.m.f(exchangeRate, "exchangeRate");
                TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest(account, decimals, amount, availableTransfers, exchangeRate, rawValue, isFiatSelected, z3, receivableWallet2, onrampEnabled);
                List<AvailableTransfer> availableTransfers2 = a.getAvailableTransfers();
                if (!(availableTransfers2 instanceof Collection) || !availableTransfers2.isEmpty()) {
                    for (AvailableTransfer availableTransfer : availableTransfers2) {
                        if (availableTransfer.getTransferAmount().compareTo(BigInteger.ZERO) > 0) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    Bundle createArguments = ConsumerTransferConfirmationArgs.INSTANCE.createArguments(transferMoneyRequest);
                    createArguments.putAll(ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment));
                    ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_consumerAmountPickerFragment_to_consumerTransferConfirmationFragment, createArguments, null, 4, null);
                    bVar3 = this.this$0.navigateSubject;
                    bVar3.onNext(viewModelNavRoute);
                    Analytics analytics = Analytics.INSTANCE;
                    AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
                    onrampEnabled3 = this.this$0.getOnrampEnabled();
                    consumerAccount3 = this.this$0.getConsumerAccount();
                    CurrencyCode currencyCode = consumerAccount3.getCurrencyCode();
                    amountViewModel3 = this.this$0.amountViewModel;
                    boolean isFiatSelected2 = amountViewModel3.isFiatSelected();
                    UUID uuid = this.$uuid;
                    kotlin.jvm.internal.m.f(uuid, "uuid");
                    analytics.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerToConfirmationNavigated(companion, onrampEnabled3, currencyCode, isFiatSelected2, uuid));
                    return;
                }
                ConsumerAmountPickerViewModel consumerAmountPickerViewModel = this.this$0;
                consumerAmountPickerViewState = consumerAmountPickerViewModel.state;
                copy = consumerAmountPickerViewState.copy((r32 & 1) != 0 ? consumerAmountPickerViewState.maxAmount : null, (r32 & 2) != 0 ? consumerAmountPickerViewState.isMaxButtonLoading : false, (r32 & 4) != 0 ? consumerAmountPickerViewState.isNextButtonVisible : false, (r32 & 8) != 0 ? consumerAmountPickerViewState.isNextButtonLoading : false, (r32 & 16) != 0 ? consumerAmountPickerViewState.isFiatSelected : false, (r32 & 32) != 0 ? consumerAmountPickerViewState.primaryText : null, (r32 & 64) != 0 ? consumerAmountPickerViewState.secondaryText : null, (r32 & 128) != 0 ? consumerAmountPickerViewState.swapButtonEnabled : false, (r32 & 256) != 0 ? consumerAmountPickerViewState.currencyCode : null, (r32 & 512) != 0 ? consumerAmountPickerViewState.keyboardLocale : null, (r32 & 1024) != 0 ? consumerAmountPickerViewState.isOnrampEnabled : false, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? consumerAmountPickerViewState.cryptoBalance : null, (r32 & 4096) != 0 ? consumerAmountPickerViewState.fiatBalance : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? consumerAmountPickerViewState.isInsufficientBalance : false, (r32 & 16384) != 0 ? consumerAmountPickerViewState.wallet : null);
                consumerAmountPickerViewModel.setState(copy);
                onrampEnabled2 = this.this$0.getOnrampEnabled();
                if (onrampEnabled2) {
                    this.this$0.cachedTransferForTransferMethods = transferMoneyRequest;
                    Bundle createArgs$default = ConsumerTransferMethodsArgs.createArgs$default(ConsumerTransferMethodsArgs.INSTANCE, transferMoneyRequest, null, 2, null);
                    createArgs$default.putAll(ForwardArgs.INSTANCE.create(R.id.consumerAmountPickerFragment));
                    ViewModelNavRoute viewModelNavRoute2 = new ViewModelNavRoute(R.id.consumerTransferMethodsFragment, createArgs$default, null, 4, null);
                    bVar2 = this.this$0.navigateSubject;
                    bVar2.onNext(viewModelNavRoute2);
                    Analytics analytics2 = Analytics.INSTANCE;
                    AnalyticsEvent.Companion companion2 = AnalyticsEvent.Companion;
                    consumerAccount2 = this.this$0.getConsumerAccount();
                    CurrencyCode currencyCode2 = consumerAccount2.getCurrencyCode();
                    amountViewModel2 = this.this$0.amountViewModel;
                    boolean isFiatSelected3 = amountViewModel2.isFiatSelected();
                    UUID uuid2 = this.$uuid;
                    kotlin.jvm.internal.m.f(uuid2, "uuid");
                    analytics2.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerToTransferMethodsNavigated(companion2, currencyCode2, isFiatSelected3, uuid2));
                    return;
                }
                generateWblPrompt = this.this$0.generateWblPrompt((AvailableSendTransfer) kotlin.a0.p.Y(a.getAvailableTransfers()));
                Analytics analytics3 = Analytics.INSTANCE;
                AnalyticsEvent.Companion companion3 = AnalyticsEvent.Companion;
                consumerAccount = this.this$0.getConsumerAccount();
                CurrencyCode currencyCode3 = consumerAccount.getCurrencyCode();
                UUID uuid3 = this.$uuid;
                kotlin.jvm.internal.m.f(uuid3, "uuid");
                analytics3.log(AnalyticsEvent_ConsumerKt.consumerAmountPickerWBLViewed(companion3, currencyCode3, uuid3));
                bVar = this.this$0.eventSubject;
                bVar.onNext(new ConsumerAmountPickerEvent.ConsumerAmountPickerPrompt(generateWblPrompt));
                return;
            }
            kotlin.jvm.internal.m.w("wallet");
            throw null;
        }
        kotlin.jvm.internal.m.w("wallet");
        throw null;
    }
}