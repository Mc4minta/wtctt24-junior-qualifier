package com.toshi.view.fragment.coin;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import java.util.Set;
import kotlin.a0.s0;

/* compiled from: WalletDetailViewModel.kt */
/* loaded from: classes2.dex */
public final class n {
    private static final Set<TxMetadataKey> a;

    static {
        Set<TxMetadataKey> e2;
        TxMetadataKey.Companion companion = TxMetadataKey.Companion;
        e2 = s0.e(TxMetadataKey_StellarKt.getMemoId(companion), TxMetadataKey_StellarKt.getMemoHash(companion), TxMetadataKey_StellarKt.getMemoText(companion), TxMetadataKey_StellarKt.getMemoReturn(companion));
        a = e2;
    }
}