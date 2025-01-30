package com.coinbase.wallet.bitcoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44Output;
import com.coinbase.walletengine.services.bitcoin.Output;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.jvm.internal.m;

/* compiled from: Output+Bitcoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/walletengine/services/bitcoin/Output;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Output;", "asBIP44Output", "(Lcom/coinbase/walletengine/services/bitcoin/Output;)Lcom/coinbase/wallet/bip44wallets/models/BIP44Output;", "", "asBIP44Outputs", "(Ljava/util/List;)Ljava/util/List;", "bitcoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Output_BitcoinKt {
    public static final BIP44Output asBIP44Output(Output output) {
        m.g(output, "<this>");
        return new BIP44Output(output.getAddress(), output.getValue());
    }

    public static final List<BIP44Output> asBIP44Outputs(List<Output> list) {
        int r;
        m.g(list, "<this>");
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Output output : list) {
            arrayList.add(asBIP44Output(output));
        }
        return arrayList;
    }
}