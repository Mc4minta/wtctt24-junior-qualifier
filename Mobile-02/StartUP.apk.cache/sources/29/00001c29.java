package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.core.extensions.Strings;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: BigIntegers+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/math/BigInteger;", "<anonymous>", "()Ljava/math/BigInteger;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BigIntegers_EthereumKt$uint256MaxValue$2 extends o implements kotlin.e0.c.a<BigInteger> {
    public static final BigIntegers_EthereumKt$uint256MaxValue$2 INSTANCE = new BigIntegers_EthereumKt$uint256MaxValue$2();

    BigIntegers_EthereumKt$uint256MaxValue$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final BigInteger invoke() {
        return new BigInteger(Strings_EthereumKt.getUint256MaxHex(Strings.INSTANCE), 16);
    }
}