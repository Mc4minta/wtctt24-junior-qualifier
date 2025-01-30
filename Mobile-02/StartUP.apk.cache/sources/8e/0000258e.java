package com.coinbase.wallet.ripple.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.ripple.models.XRPConfiguration;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: WalletConfiguration+Ripple.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/ripple/models/XRPConfiguration;", "<anonymous>", "()Lcom/coinbase/wallet/ripple/models/XRPConfiguration;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class WalletConfiguration_RippleKt$XRP$2 extends o implements kotlin.e0.c.a<XRPConfiguration> {
    public static final WalletConfiguration_RippleKt$XRP$2 INSTANCE = new WalletConfiguration_RippleKt$XRP$2();

    WalletConfiguration_RippleKt$XRP$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final XRPConfiguration invoke() {
        URL url = new URL("https://wallet-api-production.s3.amazonaws.com/uploads/tokens/xrp_288.png");
        return new XRPConfiguration(Blockchain_RippleKt.getXRP(Blockchain.Companion), NetworkSetting_RippleKt.getXRP(NetworkSetting.Companion), 120L, CurrencyCode_RippleKt.getXRP(CurrencyCode.Companion), CurrencyDecimal_RippleKt.getXRP(CurrencyDecimal.INSTANCE), url, AddressKind_RippleKt.getXRP(AddressType.Companion), false);
    }
}