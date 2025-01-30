package com.coinbase.wallet.litecoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44UTXO;
import com.coinbase.walletengine.services.litecoin.UTXO;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.jvm.internal.m;

/* compiled from: UTXO+Litecoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/walletengine/services/litecoin/UTXO;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "asBIP44UTXO", "(Lcom/coinbase/walletengine/services/litecoin/UTXO;)Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "", "asBIP44TXOs", "(Ljava/util/List;)Ljava/util/List;", "litecoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UTXO_LitecoinKt {
    public static final List<BIP44UTXO> asBIP44TXOs(List<UTXO> list) {
        int r;
        m.g(list, "<this>");
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UTXO utxo : list) {
            arrayList.add(asBIP44UTXO(utxo));
        }
        return arrayList;
    }

    public static final BIP44UTXO asBIP44UTXO(UTXO utxo) {
        m.g(utxo, "<this>");
        return new BIP44UTXO(utxo.getAddress(), utxo.getHash(), utxo.m2070getIndexpVg5ArA(), utxo.getValue(), utxo.getScript(), null);
    }
}