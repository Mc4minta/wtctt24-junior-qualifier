package com.coinbase.wallet.features.send.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SendConfirmationState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\t\n\u000b\f\r\u000eB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Error", "FeeCalculationFailed", "InsufficientBalance", "InsufficientFee", "None", "SufficientBalance", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState$None;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState$InsufficientBalance;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState$InsufficientFee;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState$FeeCalculationFailed;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState$Error;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState$SufficientBalance;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SendConfirmationState {
    private final String message;

    /* compiled from: SendConfirmationState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState$Error;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends SendConfirmationState {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message) {
            super(message, null);
            m.g(message, "message");
            this.message = message;
        }

        @Override // com.coinbase.wallet.features.send.models.SendConfirmationState
        public String getMessage() {
            return this.message;
        }
    }

    /* compiled from: SendConfirmationState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState$FeeCalculationFailed;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class FeeCalculationFailed extends SendConfirmationState {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeeCalculationFailed(String message) {
            super(message, null);
            m.g(message, "message");
            this.message = message;
        }

        @Override // com.coinbase.wallet.features.send.models.SendConfirmationState
        public String getMessage() {
            return this.message;
        }
    }

    /* compiled from: SendConfirmationState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState$InsufficientBalance;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InsufficientBalance extends SendConfirmationState {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsufficientBalance(String message) {
            super(message, null);
            m.g(message, "message");
            this.message = message;
        }

        @Override // com.coinbase.wallet.features.send.models.SendConfirmationState
        public String getMessage() {
            return this.message;
        }
    }

    /* compiled from: SendConfirmationState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState$InsufficientFee;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InsufficientFee extends SendConfirmationState {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsufficientFee(String message) {
            super(message, null);
            m.g(message, "message");
            this.message = message;
        }

        @Override // com.coinbase.wallet.features.send.models.SendConfirmationState
        public String getMessage() {
            return this.message;
        }
    }

    /* compiled from: SendConfirmationState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState$None;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class None extends SendConfirmationState {
        public static final None INSTANCE = new None();

        private None() {
            super(Strings_CoreKt.getEmpty(Strings.INSTANCE), null);
        }
    }

    /* compiled from: SendConfirmationState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationState$SufficientBalance;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationState;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SufficientBalance extends SendConfirmationState {
        public static final SufficientBalance INSTANCE = new SufficientBalance();

        private SufficientBalance() {
            super(Strings_CoreKt.getEmpty(Strings.INSTANCE), null);
        }
    }

    private SendConfirmationState(String str) {
        this.message = str;
    }

    public /* synthetic */ SendConfirmationState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String getMessage() {
        return this.message;
    }
}