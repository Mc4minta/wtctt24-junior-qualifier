package com.coinbase.wallet.dogecoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44UTXO;
import com.coinbase.walletengine.services.dogecoin.UTXO;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.jvm.internal.m;

/* compiled from: BIP44UTXO+Dogecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "Lcom/coinbase/walletengine/services/dogecoin/UTXO;", "asUTXO", "(Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;)Lcom/coinbase/walletengine/services/dogecoin/UTXO;", "", "asUTXOs", "(Ljava/util/List;)Ljava/util/List;", "dogecoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44UTXO_DogecoinKt {
    public static final UTXO asUTXO(BIP44UTXO bip44utxo) {
        m.g(bip44utxo, "<this>");
        return new UTXO(bip44utxo.getAddress(), bip44utxo.getHash(), bip44utxo.m764getIndexpVg5ArA(), bip44utxo.getValue(), bip44utxo.getScript(), null);
    }

    public static final List<UTXO> asUTXOs(List<BIP44UTXO> list) {
        int r;
        m.g(list, "<this>");
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (BIP44UTXO bip44utxo : list) {
            arrayList.add(asUTXO(bip44utxo));
        }
        return arrayList;
    }
}