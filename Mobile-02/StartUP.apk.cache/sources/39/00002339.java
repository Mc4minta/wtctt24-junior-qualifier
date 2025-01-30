package com.coinbase.wallet.features.walletlink.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.viewmodels.CompleteViewModel;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import kotlin.Metadata;
import kotlin.h;
import kotlin.k;

/* compiled from: WalletLinkCompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\n\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/viewmodels/WalletLinkCompleteViewModel;", "Lcom/coinbase/wallet/features/send/viewmodels/CompleteViewModel;", "", "message$delegate", "Lkotlin/h;", "getMessage", "()Ljava/lang/String;", ApiConstants.MESSAGE, "dappName$delegate", "getDappName", WalletLinkCompleteArgs.DAPP_NAME, "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkCompleteViewModel extends CompleteViewModel {
    private final h dappName$delegate;
    private final h message$delegate;

    public WalletLinkCompleteViewModel() {
        h b2;
        h b3;
        b2 = k.b(new WalletLinkCompleteViewModel$dappName$2(this));
        this.dappName$delegate = b2;
        b3 = k.b(new WalletLinkCompleteViewModel$message$2(this));
        this.message$delegate = b3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDappName() {
        return (String) this.dappName$delegate.getValue();
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.CompleteViewModel
    public String getMessage() {
        return (String) this.message$delegate.getValue();
    }
}