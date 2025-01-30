package com.coinbase.wallet.dogecoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: BIP44Configuration+Dogecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "<anonymous>", "()Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BIP44Configuration_DogecoinKt$DOGE$2 extends o implements a<BIP44Configuration> {
    public static final BIP44Configuration_DogecoinKt$DOGE$2 INSTANCE = new BIP44Configuration_DogecoinKt$DOGE$2();

    BIP44Configuration_DogecoinKt$DOGE$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final BIP44Configuration invoke() {
        List b2;
        URL url;
        AddressType.Companion companion = AddressType.Companion;
        b2 = q.b(AddressKind_DogecoinKt.getDogecoin(companion));
        Blockchain dogecoin = Blockchain_DogecoinKt.getDOGECOIN(Blockchain.Companion);
        CurrencyCode doge = CurrencyCode_DogecoinKt.getDOGE(CurrencyCode.Companion);
        int doge2 = CurrencyDecimal_DogecoinKt.getDOGE(CurrencyDecimal.INSTANCE);
        url = BIP44Configuration_DogecoinKt.dogeImageURL;
        return new BIP44Configuration(b2, dogecoin, "Dogecoin", doge, doge2, url, AddressKind_DogecoinKt.getDogecoin(companion), 30L, 5, "dogecoin", "dogecoin", NetworkSetting_DogecoinKt.getDOGE(NetworkSetting.Companion), 120L);
    }
}