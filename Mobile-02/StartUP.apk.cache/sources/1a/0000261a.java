package com.coinbase.wallet.stellar.exceptions;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StellarException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\t\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\t\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "BalanceNotYetUpdated", "InvalidMemoFieldFormat", "MultipleMemoFieldsProvided", "RequiresMinimumBalance", "UnableToCreateWallet", "UnableToFindWallet", "UnableToSaveTransaction", "UnableToSubmitUnsignedTransaction", "UnknownTransactionType", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToSaveTransaction;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToSubmitUnsignedTransaction;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnknownTransactionType;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$RequiresMinimumBalance;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToCreateWallet;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToFindWallet;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$MultipleMemoFieldsProvided;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$InvalidMemoFieldFormat;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException$BalanceNotYetUpdated;", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class StellarException extends Exception {

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$BalanceNotYetUpdated;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class BalanceNotYetUpdated extends StellarException {
        public static final BalanceNotYetUpdated INSTANCE = new BalanceNotYetUpdated();

        private BalanceNotYetUpdated() {
            super(null, 1, null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$InvalidMemoFieldFormat;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component1", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "metadataKey", "copy", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;)Lcom/coinbase/wallet/stellar/exceptions/StellarException$InvalidMemoFieldFormat;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "<init>", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class InvalidMemoFieldFormat extends StellarException {
        private final TxMetadataKey metadataKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidMemoFieldFormat(TxMetadataKey metadataKey) {
            super(null, 1, null);
            m.g(metadataKey, "metadataKey");
            this.metadataKey = metadataKey;
        }

        public static /* synthetic */ InvalidMemoFieldFormat copy$default(InvalidMemoFieldFormat invalidMemoFieldFormat, TxMetadataKey txMetadataKey, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                txMetadataKey = invalidMemoFieldFormat.metadataKey;
            }
            return invalidMemoFieldFormat.copy(txMetadataKey);
        }

        public final TxMetadataKey component1() {
            return this.metadataKey;
        }

        public final InvalidMemoFieldFormat copy(TxMetadataKey metadataKey) {
            m.g(metadataKey, "metadataKey");
            return new InvalidMemoFieldFormat(metadataKey);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidMemoFieldFormat) && m.c(this.metadataKey, ((InvalidMemoFieldFormat) obj).metadataKey);
        }

        public final TxMetadataKey getMetadataKey() {
            return this.metadataKey;
        }

        public int hashCode() {
            return this.metadataKey.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidMemoFieldFormat(metadataKey=" + this.metadataKey + ')';
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$MultipleMemoFieldsProvided;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class MultipleMemoFieldsProvided extends StellarException {
        public static final MultipleMemoFieldsProvided INSTANCE = new MultipleMemoFieldsProvided();

        private MultipleMemoFieldsProvided() {
            super(null, 1, null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$RequiresMinimumBalance;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class RequiresMinimumBalance extends StellarException {
        public static final RequiresMinimumBalance INSTANCE = new RequiresMinimumBalance();

        private RequiresMinimumBalance() {
            super("The address you are sending to is not yet active.", null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToCreateWallet;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToCreateWallet extends StellarException {
        public static final UnableToCreateWallet INSTANCE = new UnableToCreateWallet();

        private UnableToCreateWallet() {
            super(null, 1, null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToFindWallet;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToFindWallet extends StellarException {
        public static final UnableToFindWallet INSTANCE = new UnableToFindWallet();

        private UnableToFindWallet() {
            super(null, 1, null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToSaveTransaction;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToSaveTransaction extends StellarException {
        public static final UnableToSaveTransaction INSTANCE = new UnableToSaveTransaction();

        private UnableToSaveTransaction() {
            super(null, 1, null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnableToSubmitUnsignedTransaction;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToSubmitUnsignedTransaction extends StellarException {
        public static final UnableToSubmitUnsignedTransaction INSTANCE = new UnableToSubmitUnsignedTransaction();

        private UnableToSubmitUnsignedTransaction() {
            super(null, 1, null);
        }
    }

    /* compiled from: StellarException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/exceptions/StellarException$UnknownTransactionType;", "Lcom/coinbase/wallet/stellar/exceptions/StellarException;", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnknownTransactionType extends StellarException {
        public static final UnknownTransactionType INSTANCE = new UnknownTransactionType();

        private UnknownTransactionType() {
            super(null, 1, null);
        }
    }

    private StellarException(String str) {
        super(str);
    }

    public /* synthetic */ StellarException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ StellarException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}