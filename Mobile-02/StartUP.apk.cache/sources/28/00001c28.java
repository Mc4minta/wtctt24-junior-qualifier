package com.coinbase.wallet.ethereum.extensions;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: BigIntegers+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/ethereum/extensions/BigIntegers;", "Ljava/math/BigInteger;", "uint256MaxValue$delegate", "Lkotlin/h;", "getUint256MaxValue", "(Lcom/coinbase/wallet/ethereum/extensions/BigIntegers;)Ljava/math/BigInteger;", "uint256MaxValue", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigIntegers_EthereumKt {
    private static final h uint256MaxValue$delegate;

    static {
        h b2;
        b2 = k.b(BigIntegers_EthereumKt$uint256MaxValue$2.INSTANCE);
        uint256MaxValue$delegate = b2;
    }

    public static final BigInteger getUint256MaxValue(BigIntegers bigIntegers) {
        m.g(bigIntegers, "<this>");
        return (BigInteger) uint256MaxValue$delegate.getValue();
    }
}