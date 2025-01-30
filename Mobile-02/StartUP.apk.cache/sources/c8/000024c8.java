package com.coinbase.wallet.litecoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: BIP44Configuration+Litecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "LTC$delegate", "Lkotlin/h;", "getLTC", "(Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;)Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "LTC", "Ljava/net/URL;", "ltcImageURL", "Ljava/net/URL;", "litecoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class BIP44Configuration_LitecoinKt {
    private static final h LTC$delegate;
    private static final URL ltcImageURL = new URL("https://wallet-api-production.s3.amazonaws.com/uploads/tokens/ltc_288.png");

    static {
        h b2;
        b2 = k.b(BIP44Configuration_LitecoinKt$LTC$2.INSTANCE);
        LTC$delegate = b2;
    }

    public static final BIP44Configuration getLTC(BIP44Configuration.Companion companion) {
        m.g(companion, "<this>");
        return (BIP44Configuration) LTC$delegate.getValue();
    }
}