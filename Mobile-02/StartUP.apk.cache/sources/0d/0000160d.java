package com.coinbase.wallet.consumer.exceptions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\n\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0019\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\t\u0082\u0001\n\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/String;)V", "ApiParseException", "BuyCanceled", "BuyOverLimit", "CardVerifyException", "KnownConsumerException", "RetryGettingBuyState", "SendNeedsTwoFactor", "SendQuoteFailed", "UnableToSaveConsumerAccount", "WalletAddressNotFound", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$KnownConsumerException;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$UnableToSaveConsumerAccount;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$SendNeedsTwoFactor;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$WalletAddressNotFound;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$BuyOverLimit;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$RetryGettingBuyState;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$BuyCanceled;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$SendQuoteFailed;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$CardVerifyException;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$ApiParseException;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerException extends Exception {

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$ApiParseException;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "", "component1", "()Ljava/lang/String;", "errorMessage", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$ApiParseException;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getErrorMessage", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ApiParseException extends ConsumerException {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiParseException(String errorMessage) {
            super(errorMessage, (DefaultConstructorMarker) null);
            m.g(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public static /* synthetic */ ApiParseException copy$default(ApiParseException apiParseException, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = apiParseException.errorMessage;
            }
            return apiParseException.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final ApiParseException copy(String errorMessage) {
            m.g(errorMessage, "errorMessage");
            return new ApiParseException(errorMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApiParseException) && m.c(this.errorMessage, ((ApiParseException) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ApiParseException(errorMessage=" + this.errorMessage + ')';
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$BuyCanceled;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BuyCanceled extends ConsumerException {
        public static final BuyCanceled INSTANCE = new BuyCanceled();

        private BuyCanceled() {
            super("The buy was canceled", (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$BuyOverLimit;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BuyOverLimit extends ConsumerException {
        public static final BuyOverLimit INSTANCE = new BuyOverLimit();

        private BuyOverLimit() {
            super("Tried to buy or quote over the payment method limit", (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$CardVerifyException;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "", "component1", "()Ljava/lang/String;", "errorMessage", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$CardVerifyException;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getErrorMessage", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class CardVerifyException extends ConsumerException {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardVerifyException(String errorMessage) {
            super(errorMessage, (DefaultConstructorMarker) null);
            m.g(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public static /* synthetic */ CardVerifyException copy$default(CardVerifyException cardVerifyException, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cardVerifyException.errorMessage;
            }
            return cardVerifyException.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final CardVerifyException copy(String errorMessage) {
            m.g(errorMessage, "errorMessage");
            return new CardVerifyException(errorMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardVerifyException) && m.c(this.errorMessage, ((CardVerifyException) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "CardVerifyException(errorMessage=" + this.errorMessage + ')';
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$KnownConsumerException;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "", ApiConstants.MESSAGE, "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class KnownConsumerException extends ConsumerException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KnownConsumerException(String message, Throwable cause) {
            super(message, cause, null);
            m.g(message, "message");
            m.g(cause, "cause");
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$RetryGettingBuyState;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RetryGettingBuyState extends ConsumerException {
        public static final RetryGettingBuyState INSTANCE = new RetryGettingBuyState();

        private RetryGettingBuyState() {
            super("Retrying getting buy state", (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$SendNeedsTwoFactor;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SendNeedsTwoFactor extends ConsumerException {
        public static final SendNeedsTwoFactor INSTANCE = new SendNeedsTwoFactor();

        private SendNeedsTwoFactor() {
            super("Must provide 2fa code for send", (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$SendQuoteFailed;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SendQuoteFailed extends ConsumerException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendQuoteFailed(String message) {
            super(message, (DefaultConstructorMarker) null);
            m.g(message, "message");
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$UnableToSaveConsumerAccount;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSaveConsumerAccount extends ConsumerException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToSaveConsumerAccount(String message) {
            super(message, (DefaultConstructorMarker) null);
            m.g(message, "message");
        }
    }

    /* compiled from: ConsumerException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/exceptions/ConsumerException$WalletAddressNotFound;", "Lcom/coinbase/wallet/consumer/exceptions/ConsumerException;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class WalletAddressNotFound extends ConsumerException {
        public static final WalletAddressNotFound INSTANCE = new WalletAddressNotFound();

        private WalletAddressNotFound() {
            super("Wallet address not found", (DefaultConstructorMarker) null);
        }
    }

    private ConsumerException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ ConsumerException(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    public /* synthetic */ ConsumerException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private ConsumerException(String str) {
        super(str);
    }
}