package com.coinbase.wallet.ethereum.models;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EthereumGas.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0013\u0010\u0016\u001a\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "value", "copy", "(Ljava/math/BigInteger;)Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getValue", "getOverEstimated", "()Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "overEstimated", "<init>", "(Ljava/math/BigInteger;)V", "Companion", "OptimismTxGasLimitExceeded", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumGas {
    public static final Companion Companion = new Companion(null);
    private static final EthereumGas minimumGasLimit;
    private static final BigInteger optimismTxGasLimit;
    private final BigInteger value;

    /* compiled from: EthereumGas.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumGas$Companion;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "defaultGasLimit", "(I)Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "minimumGasLimit", "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "getMinimumGasLimit", "()Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "Ljava/math/BigInteger;", "optimismTxGasLimit", "Ljava/math/BigInteger;", "getOptimismTxGasLimit", "()Ljava/math/BigInteger;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EthereumGas defaultGasLimit(int i2) {
            if (i2 == EthereumChain.ETHEREUM_CLASSIC_MAINNET.getChainId()) {
                BigInteger valueOf = BigInteger.valueOf(1000000);
                m.f(valueOf, "BigInteger.valueOf(this.toLong())");
                return new EthereumGas(valueOf);
            }
            BigInteger valueOf2 = BigInteger.valueOf(5000000);
            m.f(valueOf2, "BigInteger.valueOf(this.toLong())");
            return new EthereumGas(valueOf2);
        }

        public final EthereumGas getMinimumGasLimit() {
            return EthereumGas.minimumGasLimit;
        }

        public final BigInteger getOptimismTxGasLimit() {
            return EthereumGas.optimismTxGasLimit;
        }
    }

    /* compiled from: EthereumGas.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumGas$OptimismTxGasLimitExceeded;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class OptimismTxGasLimitExceeded extends Exception {
    }

    static {
        BigInteger valueOf = BigInteger.valueOf(21000);
        m.f(valueOf, "BigInteger.valueOf(this.toLong())");
        minimumGasLimit = new EthereumGas(valueOf);
        BigInteger valueOf2 = BigInteger.valueOf(9000000);
        m.f(valueOf2, "BigInteger.valueOf(this.toLong())");
        optimismTxGasLimit = valueOf2;
    }

    public EthereumGas(BigInteger value) {
        m.g(value, "value");
        this.value = value;
    }

    public static /* synthetic */ EthereumGas copy$default(EthereumGas ethereumGas, BigInteger bigInteger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = ethereumGas.value;
        }
        return ethereumGas.copy(bigInteger);
    }

    public final BigInteger component1() {
        return this.value;
    }

    public final EthereumGas copy(BigInteger value) {
        m.g(value, "value");
        return new EthereumGas(value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EthereumGas) && m.c(this.value, ((EthereumGas) obj).value);
    }

    public final EthereumGas getOverEstimated() {
        if (this.value.compareTo(minimumGasLimit.value) > 0) {
            BigInteger bigInteger = this.value;
            BigInteger valueOf = BigInteger.valueOf(15);
            m.f(valueOf, "BigInteger.valueOf(this.toLong())");
            BigInteger multiply = bigInteger.multiply(valueOf);
            m.f(multiply, "this.multiply(other)");
            BigInteger valueOf2 = BigInteger.valueOf(10);
            m.f(valueOf2, "BigInteger.valueOf(this.toLong())");
            BigInteger divide = multiply.divide(valueOf2);
            m.f(divide, "this.divide(other)");
            return new EthereumGas(divide);
        }
        return this;
    }

    public final BigInteger getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "EthereumGas(value=" + this.value + ')';
    }
}