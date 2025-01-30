package com.coinbase.wallet.swap.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SwapMinerFeeException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0005B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapMinerFeeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "NotEnoughFunds", "Lcom/coinbase/wallet/swap/models/SwapMinerFeeException$NotEnoughFunds;", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class SwapMinerFeeException extends Exception {

    /* compiled from: SwapMinerFeeException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapMinerFeeException$NotEnoughFunds;", "Lcom/coinbase/wallet/swap/models/SwapMinerFeeException;", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class NotEnoughFunds extends SwapMinerFeeException {
        public static final NotEnoughFunds INSTANCE = new NotEnoughFunds();

        private NotEnoughFunds() {
            super(null);
        }
    }

    private SwapMinerFeeException() {
    }

    public /* synthetic */ SwapMinerFeeException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}