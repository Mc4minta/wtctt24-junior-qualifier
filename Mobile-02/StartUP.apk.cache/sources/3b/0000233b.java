package com.coinbase.wallet.features.walletlink.viewmodels;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkCompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkCompleteViewModel$message$2 extends o implements kotlin.e0.c.a<String> {
    final /* synthetic */ WalletLinkCompleteViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkCompleteViewModel$message$2(WalletLinkCompleteViewModel walletLinkCompleteViewModel) {
        super(0);
        this.this$0 = walletLinkCompleteViewModel;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        String dappName;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        dappName = this.this$0.getDappName();
        return localizedStrings.get(R.string.walletlink_dapp_connection_completed, dappName);
    }
}