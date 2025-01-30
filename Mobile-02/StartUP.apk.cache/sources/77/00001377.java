package com.coinbase.wallet.bitcoincash.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: BIP44Configuration+BitcoinCash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"!\u0010\t\u001a\u00020\u0004*\u00020\u00038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Ljava/net/URL;", "bchImageURL", "Ljava/net/URL;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "BCH$delegate", "Lkotlin/h;", "getBCH", "(Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;)Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "BCH", "bitcoincash_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44Configuration_BitcoinCashKt {
    private static final h BCH$delegate;
    private static final URL bchImageURL = new URL("https://wallet-api-production.s3.amazonaws.com/uploads/tokens/bch_288.png");

    static {
        h b2;
        b2 = k.b(BIP44Configuration_BitcoinCashKt$BCH$2.INSTANCE);
        BCH$delegate = b2;
    }

    public static final BIP44Configuration getBCH(BIP44Configuration.Companion companion) {
        m.g(companion, "<this>");
        return (BIP44Configuration) BCH$delegate.getValue();
    }
}