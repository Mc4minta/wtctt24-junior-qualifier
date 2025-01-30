package com.coinbase.wallet.consumer.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AddCardRedirectResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "", "<init>", "()V", "Cancel", "Failure", "ParseError", "Success", "SuccessWithCdv", "UnsupportedVerification", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$ParseError;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Failure;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Cancel;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Success;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$SuccessWithCdv;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$UnsupportedVerification;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AddCardRedirectResult {

    /* compiled from: AddCardRedirectResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Cancel;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Cancel extends AddCardRedirectResult {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
            super(null);
        }
    }

    /* compiled from: AddCardRedirectResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Failure;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Failure extends AddCardRedirectResult {
        public static final Failure INSTANCE = new Failure();

        private Failure() {
            super(null);
        }
    }

    /* compiled from: AddCardRedirectResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$ParseError;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ParseError extends AddCardRedirectResult {
        public static final ParseError INSTANCE = new ParseError();

        private ParseError() {
            super(null);
        }
    }

    /* compiled from: AddCardRedirectResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Success;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "", "component1", "()Ljava/lang/String;", "paymentMethodId", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$Success;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPaymentMethodId", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Success extends AddCardRedirectResult {
        private final String paymentMethodId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String paymentMethodId) {
            super(null);
            m.g(paymentMethodId, "paymentMethodId");
            this.paymentMethodId = paymentMethodId;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = success.paymentMethodId;
            }
            return success.copy(str);
        }

        public final String component1() {
            return this.paymentMethodId;
        }

        public final Success copy(String paymentMethodId) {
            m.g(paymentMethodId, "paymentMethodId");
            return new Success(paymentMethodId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && m.c(this.paymentMethodId, ((Success) obj).paymentMethodId);
        }

        public final String getPaymentMethodId() {
            return this.paymentMethodId;
        }

        public int hashCode() {
            return this.paymentMethodId.hashCode();
        }

        public String toString() {
            return "Success(paymentMethodId=" + this.paymentMethodId + ')';
        }
    }

    /* compiled from: AddCardRedirectResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$SuccessWithCdv;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "", "component1", "()Ljava/lang/String;", "paymentMethodId", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$SuccessWithCdv;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPaymentMethodId", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SuccessWithCdv extends AddCardRedirectResult {
        private final String paymentMethodId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SuccessWithCdv(String paymentMethodId) {
            super(null);
            m.g(paymentMethodId, "paymentMethodId");
            this.paymentMethodId = paymentMethodId;
        }

        public static /* synthetic */ SuccessWithCdv copy$default(SuccessWithCdv successWithCdv, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = successWithCdv.paymentMethodId;
            }
            return successWithCdv.copy(str);
        }

        public final String component1() {
            return this.paymentMethodId;
        }

        public final SuccessWithCdv copy(String paymentMethodId) {
            m.g(paymentMethodId, "paymentMethodId");
            return new SuccessWithCdv(paymentMethodId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessWithCdv) && m.c(this.paymentMethodId, ((SuccessWithCdv) obj).paymentMethodId);
        }

        public final String getPaymentMethodId() {
            return this.paymentMethodId;
        }

        public int hashCode() {
            return this.paymentMethodId.hashCode();
        }

        public String toString() {
            return "SuccessWithCdv(paymentMethodId=" + this.paymentMethodId + ')';
        }
    }

    /* compiled from: AddCardRedirectResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult$UnsupportedVerification;", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnsupportedVerification extends AddCardRedirectResult {
        public static final UnsupportedVerification INSTANCE = new UnsupportedVerification();

        private UnsupportedVerification() {
            super(null);
        }
    }

    private AddCardRedirectResult() {
    }

    public /* synthetic */ AddCardRedirectResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}