package com.coinbase.wallet.blockchains.exceptions;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TxException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\u0007\b\t\n\u000bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/TxException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "InsufficientBalance", "MissingTxManaging", "UnableToHexEncode", "UnableToSaveTx", "UnknownTransactionType", "Lcom/coinbase/wallet/blockchains/exceptions/TxException$InsufficientBalance;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnknownTransactionType;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnableToSaveTx;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException$MissingTxManaging;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnableToHexEncode;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class TxException extends Exception {

    /* compiled from: TxException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/TxException$InsufficientBalance;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InsufficientBalance extends TxException {
        public static final InsufficientBalance INSTANCE = new InsufficientBalance();

        private InsufficientBalance() {
            super(null, 1, null);
        }
    }

    /* compiled from: TxException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/TxException$MissingTxManaging;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "copy", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/blockchains/exceptions/TxException$MissingTxManaging;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MissingTxManaging extends TxException {
        private final Blockchain blockchain;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTxManaging(Blockchain blockchain) {
            super(m.o("missing tx managing for #", blockchain), null);
            m.g(blockchain, "blockchain");
            this.blockchain = blockchain;
        }

        public static /* synthetic */ MissingTxManaging copy$default(MissingTxManaging missingTxManaging, Blockchain blockchain, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                blockchain = missingTxManaging.blockchain;
            }
            return missingTxManaging.copy(blockchain);
        }

        public final Blockchain component1() {
            return this.blockchain;
        }

        public final MissingTxManaging copy(Blockchain blockchain) {
            m.g(blockchain, "blockchain");
            return new MissingTxManaging(blockchain);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MissingTxManaging) && m.c(this.blockchain, ((MissingTxManaging) obj).blockchain);
        }

        public final Blockchain getBlockchain() {
            return this.blockchain;
        }

        public int hashCode() {
            return this.blockchain.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingTxManaging(blockchain=" + this.blockchain + ')';
        }
    }

    /* compiled from: TxException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnableToHexEncode;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToHexEncode extends TxException {
        public static final UnableToHexEncode INSTANCE = new UnableToHexEncode();

        private UnableToHexEncode() {
            super(null, 1, null);
        }
    }

    /* compiled from: TxException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnableToSaveTx;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "copy", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnableToSaveTx;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSaveTx extends TxException {
        private final Blockchain blockchain;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToSaveTx(Blockchain blockchain) {
            super("Unable to save " + blockchain + " tx", null);
            m.g(blockchain, "blockchain");
            this.blockchain = blockchain;
        }

        public static /* synthetic */ UnableToSaveTx copy$default(UnableToSaveTx unableToSaveTx, Blockchain blockchain, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                blockchain = unableToSaveTx.blockchain;
            }
            return unableToSaveTx.copy(blockchain);
        }

        public final Blockchain component1() {
            return this.blockchain;
        }

        public final UnableToSaveTx copy(Blockchain blockchain) {
            m.g(blockchain, "blockchain");
            return new UnableToSaveTx(blockchain);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnableToSaveTx) && m.c(this.blockchain, ((UnableToSaveTx) obj).blockchain);
        }

        public final Blockchain getBlockchain() {
            return this.blockchain;
        }

        public int hashCode() {
            return this.blockchain.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "UnableToSaveTx(blockchain=" + this.blockchain + ')';
        }
    }

    /* compiled from: TxException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/exceptions/TxException$UnknownTransactionType;", "Lcom/coinbase/wallet/blockchains/exceptions/TxException;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnknownTransactionType extends TxException {
        public static final UnknownTransactionType INSTANCE = new UnknownTransactionType();

        private UnknownTransactionType() {
            super("Unknown transaction type", null);
        }
    }

    private TxException(String str) {
        super(str);
    }

    public /* synthetic */ TxException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ TxException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, null);
    }
}