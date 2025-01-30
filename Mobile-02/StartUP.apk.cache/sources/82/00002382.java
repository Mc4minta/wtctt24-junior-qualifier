package com.coinbase.wallet.features.wallets.views;

import android.os.Bundle;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.send.models.SendCoinPickerArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: SendCoinPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "<anonymous>", "()Lcom/coinbase/wallet/blockchains/models/Wallet;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendCoinPickerFragment$initialSelection$2 extends o implements kotlin.e0.c.a<Wallet> {
    final /* synthetic */ SendCoinPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendCoinPickerFragment$initialSelection$2(SendCoinPickerFragment sendCoinPickerFragment) {
        super(0);
        this.this$0 = sendCoinPickerFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final Wallet invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            return null;
        }
        return (Wallet) arguments.getParcelable(SendCoinPickerArgs.INSTANCE.getEXTRA_INITIAL_SELECTION());
    }
}