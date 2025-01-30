package com.coinbase.wallet.features.swap.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SwapConfirmationError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\b\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\u0082\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "getDescription", ApiConstants.DESCRIPTION, "<init>", "(Ljava/lang/String;)V", "Error", "FeeCalculationFailed", "HighPriceImpactWarning", "InsufficientBalance", "InsufficientFee", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$InsufficientBalance;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$InsufficientFee;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$FeeCalculationFailed;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$HighPriceImpactWarning;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$Error;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SwapConfirmationError {
    private final String message;

    /* compiled from: SwapConfirmationError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$Error;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends SwapConfirmationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message) {
            super(message, null);
            m.g(message, "message");
        }
    }

    /* compiled from: SwapConfirmationError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$FeeCalculationFailed;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class FeeCalculationFailed extends SwapConfirmationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeeCalculationFailed(String message) {
            super(message, null);
            m.g(message, "message");
        }
    }

    /* compiled from: SwapConfirmationError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$HighPriceImpactWarning;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class HighPriceImpactWarning extends SwapConfirmationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HighPriceImpactWarning(String message) {
            super(message, null);
            m.g(message, "message");
        }
    }

    /* compiled from: SwapConfirmationError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$InsufficientBalance;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InsufficientBalance extends SwapConfirmationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsufficientBalance(String message) {
            super(message, null);
            m.g(message, "message");
        }
    }

    /* compiled from: SwapConfirmationError.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError$InsufficientFee;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationError;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InsufficientFee extends SwapConfirmationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsufficientFee(String message) {
            super(message, null);
            m.g(message, "message");
        }
    }

    private SwapConfirmationError(String str) {
        this.message = str;
    }

    public /* synthetic */ SwapConfirmationError(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getDescription() {
        if (this instanceof InsufficientBalance) {
            return "Cannot confirm swap because of insufficient balance";
        }
        if (this instanceof InsufficientFee) {
            return "Cannot confirm swap because of insufficient fee";
        }
        if (this instanceof FeeCalculationFailed) {
            return "Cannot confirm swap because of fee calculation failure";
        }
        if (this instanceof HighPriceImpactWarning) {
            return "Price is significantly worse than market rate.";
        }
        if (this instanceof Error) {
            return this.message;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getMessage() {
        return this.message;
    }
}