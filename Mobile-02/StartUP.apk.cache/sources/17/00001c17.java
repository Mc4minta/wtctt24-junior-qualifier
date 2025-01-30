package com.coinbase.wallet.ethereum.exceptions;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EthereumException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0013\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u000b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "IncorrectNonceProvided", "InvalidConfiguration", "InvalidERC20", "TransactionSignatureMissing", "UnableToCalculateBalance", "UnableToEstimateGas", "UnableToFindGasPrice", "UnableToFindSignedTx", "UnableToFindWallet", "UnableToGetERC20Details", "UnsupportedAccessToEstimatedFeeOn1559Tx", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToFindGasPrice;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToEstimateGas;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToCalculateBalance;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToFindWallet;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToFindSignedTx;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$InvalidERC20;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$IncorrectNonceProvided;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$TransactionSignatureMissing;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToGetERC20Details;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$InvalidConfiguration;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnsupportedAccessToEstimatedFeeOn1559Tx;", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class EthereumException extends Exception {

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$IncorrectNonceProvided;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class IncorrectNonceProvided extends EthereumException {
        public static final IncorrectNonceProvided INSTANCE = new IncorrectNonceProvided();

        private IncorrectNonceProvided() {
            super("Unable to determine nonce or incorrect nonce provided", null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$InvalidConfiguration;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidConfiguration extends EthereumException {
        public static final InvalidConfiguration INSTANCE = new InvalidConfiguration();

        private InvalidConfiguration() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$InvalidERC20;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidERC20 extends EthereumException {
        public static final InvalidERC20 INSTANCE = new InvalidERC20();

        private InvalidERC20() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$TransactionSignatureMissing;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class TransactionSignatureMissing extends EthereumException {
        public static final TransactionSignatureMissing INSTANCE = new TransactionSignatureMissing();

        private TransactionSignatureMissing() {
            super("Tx signature missing", null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToCalculateBalance;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToCalculateBalance extends EthereumException {
        public static final UnableToCalculateBalance INSTANCE = new UnableToCalculateBalance();

        private UnableToCalculateBalance() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToEstimateGas;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToEstimateGas extends EthereumException {
        public static final UnableToEstimateGas INSTANCE = new UnableToEstimateGas();

        private UnableToEstimateGas() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToFindGasPrice;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToFindGasPrice extends EthereumException {
        public static final UnableToFindGasPrice INSTANCE = new UnableToFindGasPrice();

        private UnableToFindGasPrice() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToFindSignedTx;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToFindSignedTx extends EthereumException {
        public static final UnableToFindSignedTx INSTANCE = new UnableToFindSignedTx();

        private UnableToFindSignedTx() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToFindWallet;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToFindWallet extends EthereumException {
        public static final UnableToFindWallet INSTANCE = new UnableToFindWallet();

        private UnableToFindWallet() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnableToGetERC20Details;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToGetERC20Details extends EthereumException {
        public static final UnableToGetERC20Details INSTANCE = new UnableToGetERC20Details();

        private UnableToGetERC20Details() {
            super(null, 1, null);
        }
    }

    /* compiled from: EthereumException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/exceptions/EthereumException$UnsupportedAccessToEstimatedFeeOn1559Tx;", "Lcom/coinbase/wallet/ethereum/exceptions/EthereumException;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnsupportedAccessToEstimatedFeeOn1559Tx extends EthereumException {
        public static final UnsupportedAccessToEstimatedFeeOn1559Tx INSTANCE = new UnsupportedAccessToEstimatedFeeOn1559Tx();

        private UnsupportedAccessToEstimatedFeeOn1559Tx() {
            super("1559 tx estimated fee should be represented as a range", null);
        }
    }

    private EthereumException(String str) {
        super(str);
    }

    public /* synthetic */ EthereumException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ EthereumException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}