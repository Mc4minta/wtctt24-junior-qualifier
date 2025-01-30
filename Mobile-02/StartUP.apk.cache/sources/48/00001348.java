package com.coinbase.wallet.bitcoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: BIP44Configuration+Bitcoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"!\u0010\t\u001a\u00020\u0004*\u00020\u00038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Ljava/net/URL;", "btcImageURL", "Ljava/net/URL;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "BTC$delegate", "Lkotlin/h;", "getBTC", "(Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;)Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "BTC", "bitcoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44Configuration_BitcoinKt {
    private static final h BTC$delegate;
    private static final URL btcImageURL = new URL("https://wallet-api-production.s3.amazonaws.com/uploads/tokens/btc_288.png");

    static {
        h b2;
        b2 = k.b(BIP44Configuration_BitcoinKt$BTC$2.INSTANCE);
        BTC$delegate = b2;
    }

    public static final BIP44Configuration getBTC(BIP44Configuration.Companion companion) {
        m.g(companion, "<this>");
        return (BIP44Configuration) BTC$delegate.getValue();
    }
}