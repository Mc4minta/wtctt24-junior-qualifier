package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: CurrencyCode+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "<anonymous>", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class CurrencyCode_EthereumKt$WETH$2 extends o implements kotlin.e0.c.a<CurrencyCode> {
    public static final CurrencyCode_EthereumKt$WETH$2 INSTANCE = new CurrencyCode_EthereumKt$WETH$2();

    CurrencyCode_EthereumKt$WETH$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final CurrencyCode invoke() {
        return new CurrencyCode("WETH");
    }
}