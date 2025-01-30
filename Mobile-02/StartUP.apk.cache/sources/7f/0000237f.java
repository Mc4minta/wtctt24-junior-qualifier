package com.coinbase.wallet.features.wallets.views;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.wallets.models.ListItem;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendCoinPickerFragment$initAdapter$1 extends o implements l<ListItem.WalletListItem, x> {
    final /* synthetic */ SendCoinPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendCoinPickerFragment$initAdapter$1(SendCoinPickerFragment sendCoinPickerFragment) {
        super(1);
        this.this$0 = sendCoinPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(ListItem.WalletListItem walletListItem) {
        invoke2(walletListItem);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ListItem.WalletListItem it) {
        Wallet initialSelection;
        m.g(it, "it");
        Wallet wallet = it.getWallet();
        initialSelection = this.this$0.getInitialSelection();
        if (m.c(wallet, initialSelection)) {
            return;
        }
        this.this$0.handleNavigation(it.getWallet());
    }
}