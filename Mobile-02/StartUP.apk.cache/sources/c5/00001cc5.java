package com.coinbase.wallet.ethereum.models;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: GasEstimationStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "getGas", "()Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "gas", "<init>", "()V", "Error", "Success", "Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus$Success;", "Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus$Error;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class GasEstimationStatus {

    /* compiled from: GasEstimationStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus$Error;", "Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus;", "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "component1", "()Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "ethereumGas", "copy", "(Lcom/coinbase/wallet/ethereum/models/EthereumGas;)Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "getEthereumGas", "<init>", "(Lcom/coinbase/wallet/ethereum/models/EthereumGas;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends GasEstimationStatus {
        private final EthereumGas ethereumGas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(EthereumGas ethereumGas) {
            super(null);
            m.g(ethereumGas, "ethereumGas");
            this.ethereumGas = ethereumGas;
        }

        public static /* synthetic */ Error copy$default(Error error, EthereumGas ethereumGas, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                ethereumGas = error.ethereumGas;
            }
            return error.copy(ethereumGas);
        }

        public final EthereumGas component1() {
            return this.ethereumGas;
        }

        public final Error copy(EthereumGas ethereumGas) {
            m.g(ethereumGas, "ethereumGas");
            return new Error(ethereumGas);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && m.c(this.ethereumGas, ((Error) obj).ethereumGas);
        }

        public final EthereumGas getEthereumGas() {
            return this.ethereumGas;
        }

        public int hashCode() {
            return this.ethereumGas.hashCode();
        }

        public String toString() {
            return "Error(ethereumGas=" + this.ethereumGas + ')';
        }
    }

    /* compiled from: GasEstimationStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus$Success;", "Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus;", "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "component1", "()Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "ethereumGas", "copy", "(Lcom/coinbase/wallet/ethereum/models/EthereumGas;)Lcom/coinbase/wallet/ethereum/models/GasEstimationStatus$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/models/EthereumGas;", "getEthereumGas", "<init>", "(Lcom/coinbase/wallet/ethereum/models/EthereumGas;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Success extends GasEstimationStatus {
        private final EthereumGas ethereumGas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(EthereumGas ethereumGas) {
            super(null);
            m.g(ethereumGas, "ethereumGas");
            this.ethereumGas = ethereumGas;
        }

        public static /* synthetic */ Success copy$default(Success success, EthereumGas ethereumGas, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                ethereumGas = success.ethereumGas;
            }
            return success.copy(ethereumGas);
        }

        public final EthereumGas component1() {
            return this.ethereumGas;
        }

        public final Success copy(EthereumGas ethereumGas) {
            m.g(ethereumGas, "ethereumGas");
            return new Success(ethereumGas);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && m.c(this.ethereumGas, ((Success) obj).ethereumGas);
        }

        public final EthereumGas getEthereumGas() {
            return this.ethereumGas;
        }

        public int hashCode() {
            return this.ethereumGas.hashCode();
        }

        public String toString() {
            return "Success(ethereumGas=" + this.ethereumGas + ')';
        }
    }

    private GasEstimationStatus() {
    }

    public /* synthetic */ GasEstimationStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final EthereumGas getGas() {
        if (this instanceof Success) {
            return ((Success) this).getEthereumGas();
        }
        if (this instanceof Error) {
            return ((Error) this).getEthereumGas();
        }
        throw new NoWhenBranchMatchedException();
    }
}