package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedTx;
import java.math.BigInteger;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/math/BigInteger;", "<anonymous>", "()Ljava/math/BigInteger;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel$txGasLimit$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<BigInteger> {
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$txGasLimit$2(SendConfirmationViewModel sendConfirmationViewModel) {
        super(0);
        this.this$0 = sendConfirmationViewModel;
    }

    @Override // kotlin.e0.c.a
    public final BigInteger invoke() {
        UnsignedTx unsignedTx;
        unsignedTx = this.this$0.tx;
        EthereumUnsignedTx ethereumUnsignedTx = unsignedTx instanceof EthereumUnsignedTx ? (EthereumUnsignedTx) unsignedTx : null;
        if (ethereumUnsignedTx == null) {
            return null;
        }
        return ethereumUnsignedTx.getGasLimit();
    }
}