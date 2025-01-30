package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigInteger;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SendCompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001d\u0010\t\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/SendCompleteViewModel;", "Lcom/coinbase/wallet/features/send/viewmodels/CompleteViewModel;", "", "getMessage", "()Ljava/lang/String;", ApiConstants.MESSAGE, "recipient$delegate", "Lkotlin/h;", "getRecipient", "recipient", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet$delegate", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Ljava/math/BigInteger;", "amount$delegate", "getAmount", "()Ljava/math/BigInteger;", "amount", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendCompleteViewModel extends CompleteViewModel {
    private final kotlin.h amount$delegate;
    private final CurrencyFormatter currencyFormatter;
    private final kotlin.h recipient$delegate;
    private final kotlin.h wallet$delegate;

    public SendCompleteViewModel(CurrencyFormatter currencyFormatter) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        this.currencyFormatter = currencyFormatter;
        b2 = kotlin.k.b(new SendCompleteViewModel$wallet$2(this));
        this.wallet$delegate = b2;
        b3 = kotlin.k.b(new SendCompleteViewModel$amount$2(this));
        this.amount$delegate = b3;
        b4 = kotlin.k.b(new SendCompleteViewModel$recipient$2(this));
        this.recipient$delegate = b4;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendSuccessLanded(AnalyticsEvent.Companion));
    }

    private final BigInteger getAmount() {
        return (BigInteger) this.amount$delegate.getValue();
    }

    private final String getRecipient() {
        return (String) this.recipient$delegate.getValue();
    }

    private final Wallet getWallet() {
        return (Wallet) this.wallet$delegate.getValue();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.CompleteViewModel
    public String getMessage() {
        String formatToFiat;
        formatToFiat = this.currencyFormatter.formatToFiat(getWallet().getCurrencyCode(), getWallet().getContractAddress(), getWallet().getDecimals(), getAmount(), (r17 & 16) != 0 ? false : false, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        if (formatToFiat == null) {
            formatToFiat = CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, getWallet().getCurrencyCode(), getWallet().getDecimals(), getAmount(), false, 0, 0, 56, (Object) null);
        }
        return LocalizedStrings.INSTANCE.get(R.string.send_complete_message, formatToFiat, String_CommonKt.truncateMiddle$default(getRecipient(), 6, 4, null, 4, null));
    }
}