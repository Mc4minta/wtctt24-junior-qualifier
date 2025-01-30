package com.coinbase.wallet.txhistory.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TxHistoryException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "ApiError", "InvalidEthereumNetwork", "MissingPagingToken", "Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException$MissingPagingToken;", "Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException$InvalidEthereumNetwork;", "Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException$ApiError;", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class TxHistoryException extends Exception {

    /* compiled from: TxHistoryException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException$ApiError;", "Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException;", "", "msg", "<init>", "(Ljava/lang/String;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ApiError extends TxHistoryException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiError(String msg) {
            super(msg, null);
            m.g(msg, "msg");
        }
    }

    /* compiled from: TxHistoryException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException$InvalidEthereumNetwork;", "Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class InvalidEthereumNetwork extends TxHistoryException {
        public static final InvalidEthereumNetwork INSTANCE = new InvalidEthereumNetwork();

        private InvalidEthereumNetwork() {
            super("Invalid Ethereum Network", null);
        }
    }

    /* compiled from: TxHistoryException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException$MissingPagingToken;", "Lcom/coinbase/wallet/txhistory/exceptions/TxHistoryException;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class MissingPagingToken extends TxHistoryException {
        public static final MissingPagingToken INSTANCE = new MissingPagingToken();

        private MissingPagingToken() {
            super("Missing paging token", null);
        }
    }

    private TxHistoryException(String str) {
        super(str);
    }

    public /* synthetic */ TxHistoryException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}