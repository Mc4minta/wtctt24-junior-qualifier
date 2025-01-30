package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.core.extensions.Strings;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Strings+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/core/extensions/Strings;", "", "getUint256MaxHex", "(Lcom/coinbase/wallet/core/extensions/Strings;)Ljava/lang/String;", "uint256MaxHex", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Strings_EthereumKt {
    public static final String getUint256MaxHex(Strings strings) {
        m.g(strings, "<this>");
        return "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
    }
}