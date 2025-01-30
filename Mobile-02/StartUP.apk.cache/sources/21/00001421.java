package com.coinbase.wallet.blockchains.models;

import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TxUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "", "<init>", "()V", "Submitted", "Update", "Lcom/coinbase/wallet/blockchains/models/TxUpdate$Submitted;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate$Update;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class TxUpdate {

    /* compiled from: TxUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxUpdate$Submitted;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Transaction;", "tx", "copy", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)Lcom/coinbase/wallet/blockchains/models/TxUpdate$Submitted;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "getTx", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Submitted extends TxUpdate {
        private final Transaction tx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Submitted(Transaction tx) {
            super(null);
            m.g(tx, "tx");
            this.tx = tx;
        }

        public static /* synthetic */ Submitted copy$default(Submitted submitted, Transaction transaction, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                transaction = submitted.tx;
            }
            return submitted.copy(transaction);
        }

        public final Transaction component1() {
            return this.tx;
        }

        public final Submitted copy(Transaction tx) {
            m.g(tx, "tx");
            return new Submitted(tx);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Submitted) && m.c(this.tx, ((Submitted) obj).tx);
        }

        public final Transaction getTx() {
            return this.tx;
        }

        public int hashCode() {
            return this.tx.hashCode();
        }

        public String toString() {
            return "Submitted(tx=" + this.tx + ')';
        }
    }

    /* compiled from: TxUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxUpdate$Update;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "component1", "()Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "tx", "copy", "(Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;)Lcom/coinbase/wallet/blockchains/models/TxUpdate$Update;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "getTx", "<init>", "(Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Update extends TxUpdate {
        private final SignedTx tx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(SignedTx tx) {
            super(null);
            m.g(tx, "tx");
            this.tx = tx;
        }

        public static /* synthetic */ Update copy$default(Update update, SignedTx signedTx, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                signedTx = update.tx;
            }
            return update.copy(signedTx);
        }

        public final SignedTx component1() {
            return this.tx;
        }

        public final Update copy(SignedTx tx) {
            m.g(tx, "tx");
            return new Update(tx);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Update) && m.c(this.tx, ((Update) obj).tx);
        }

        public final SignedTx getTx() {
            return this.tx;
        }

        public int hashCode() {
            return this.tx.hashCode();
        }

        public String toString() {
            return "Update(tx=" + this.tx + ')';
        }
    }

    private TxUpdate() {
    }

    public /* synthetic */ TxUpdate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}