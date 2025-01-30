package com.coinbase.wallet.blockchains.models;

import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: UnsignedTxResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0015\u0010\t\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "getTransaction", "()Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "transaction", "", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "()V", "Error", "Success", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Success;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Error;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class UnsignedTxResult {

    /* compiled from: UnsignedTxResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Error;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "component1", "()Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "", "component2", "()Ljava/lang/Throwable;", "tx", "err", "copy", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/Throwable;)Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "getTx", "Ljava/lang/Throwable;", "getErr", "<init>", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/Throwable;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends UnsignedTxResult {
        private final Throwable err;
        private final UnsignedTx tx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(UnsignedTx unsignedTx, Throwable err) {
            super(null);
            m.g(err, "err");
            this.tx = unsignedTx;
            this.err = err;
        }

        public static /* synthetic */ Error copy$default(Error error, UnsignedTx unsignedTx, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                unsignedTx = error.tx;
            }
            if ((i2 & 2) != 0) {
                th = error.err;
            }
            return error.copy(unsignedTx, th);
        }

        public final UnsignedTx component1() {
            return this.tx;
        }

        public final Throwable component2() {
            return this.err;
        }

        public final Error copy(UnsignedTx unsignedTx, Throwable err) {
            m.g(err, "err");
            return new Error(unsignedTx, err);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return m.c(this.tx, error.tx) && m.c(this.err, error.err);
            }
            return false;
        }

        public final Throwable getErr() {
            return this.err;
        }

        public final UnsignedTx getTx() {
            return this.tx;
        }

        public int hashCode() {
            UnsignedTx unsignedTx = this.tx;
            return ((unsignedTx == null ? 0 : unsignedTx.hashCode()) * 31) + this.err.hashCode();
        }

        public String toString() {
            return "Error(tx=" + this.tx + ", err=" + this.err + ')';
        }
    }

    /* compiled from: UnsignedTxResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Success;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "component1", "()Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "tx", "copy", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;)Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "getTx", "<init>", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Success extends UnsignedTxResult {
        private final UnsignedTx tx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(UnsignedTx tx) {
            super(null);
            m.g(tx, "tx");
            this.tx = tx;
        }

        public static /* synthetic */ Success copy$default(Success success, UnsignedTx unsignedTx, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                unsignedTx = success.tx;
            }
            return success.copy(unsignedTx);
        }

        public final UnsignedTx component1() {
            return this.tx;
        }

        public final Success copy(UnsignedTx tx) {
            m.g(tx, "tx");
            return new Success(tx);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && m.c(this.tx, ((Success) obj).tx);
        }

        public final UnsignedTx getTx() {
            return this.tx;
        }

        public int hashCode() {
            return this.tx.hashCode();
        }

        public String toString() {
            return "Success(tx=" + this.tx + ')';
        }
    }

    private UnsignedTxResult() {
    }

    public /* synthetic */ UnsignedTxResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Throwable getError() {
        if (this instanceof Success) {
            return null;
        }
        if (this instanceof Error) {
            return ((Error) this).getErr();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final UnsignedTx getTransaction() {
        if (this instanceof Success) {
            return ((Success) this).getTx();
        }
        if (this instanceof Error) {
            return ((Error) this).getTx();
        }
        throw new NoWhenBranchMatchedException();
    }
}