package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.consumer.R;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum ACH_BANK_ACCOUNT uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: ConsumerPaymentMethodType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0015\b\u0002\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;", "", "", "toString", "()Ljava/lang/String;", "", "iconRes", "Ljava/lang/Integer;", "getIconRes", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "Companion", "ACH_BANK_ACCOUNT", "DEBIT_CARD", "CREDIT_CARD", "SECURE3D_CARD", "FEDWIRE", "FIAT_ACCOUNT", "IDEAL_BANK_ACCOUNT", "PAYPAL_ACCOUNT", "SEPA_BANK_ACCOUNT", "SOFORT", "UK_BANK_ACCOUNT", "WORLDPAY_CARD", "XFERS_ACCOUNT", "UNKNOWN", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerPaymentMethodType {
    private static final /* synthetic */ ConsumerPaymentMethodType[] $VALUES;
    public static final ConsumerPaymentMethodType ACH_BANK_ACCOUNT;
    public static final ConsumerPaymentMethodType CREDIT_CARD;
    public static final Companion Companion;
    public static final ConsumerPaymentMethodType DEBIT_CARD;
    public static final ConsumerPaymentMethodType FEDWIRE;
    public static final ConsumerPaymentMethodType FIAT_ACCOUNT;
    public static final ConsumerPaymentMethodType IDEAL_BANK_ACCOUNT;
    public static final ConsumerPaymentMethodType PAYPAL_ACCOUNT;
    public static final ConsumerPaymentMethodType SECURE3D_CARD;
    public static final ConsumerPaymentMethodType SEPA_BANK_ACCOUNT;
    public static final ConsumerPaymentMethodType SOFORT;
    public static final ConsumerPaymentMethodType UK_BANK_ACCOUNT;
    public static final ConsumerPaymentMethodType UNKNOWN;
    public static final ConsumerPaymentMethodType WORLDPAY_CARD;
    public static final ConsumerPaymentMethodType XFERS_ACCOUNT;
    private final Integer iconRes;

    /* compiled from: ConsumerPaymentMethodType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType$Companion;", "", "", "value", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;", "fromValue", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;", "fromValueNullable", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConsumerPaymentMethodType fromValue(String value) {
            ConsumerPaymentMethodType[] values;
            m.g(value, "value");
            for (ConsumerPaymentMethodType consumerPaymentMethodType : ConsumerPaymentMethodType.values()) {
                if (m.c(consumerPaymentMethodType.name(), value)) {
                    return consumerPaymentMethodType;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public final ConsumerPaymentMethodType fromValueNullable(String value) {
            ConsumerPaymentMethodType[] values;
            m.g(value, "value");
            for (ConsumerPaymentMethodType consumerPaymentMethodType : ConsumerPaymentMethodType.values()) {
                if (m.c(consumerPaymentMethodType.toString(), value)) {
                    return consumerPaymentMethodType;
                }
            }
            return null;
        }
    }

    private static final /* synthetic */ ConsumerPaymentMethodType[] $values() {
        return new ConsumerPaymentMethodType[]{ACH_BANK_ACCOUNT, DEBIT_CARD, CREDIT_CARD, SECURE3D_CARD, FEDWIRE, FIAT_ACCOUNT, IDEAL_BANK_ACCOUNT, PAYPAL_ACCOUNT, SEPA_BANK_ACCOUNT, SOFORT, UK_BANK_ACCOUNT, WORLDPAY_CARD, XFERS_ACCOUNT, UNKNOWN};
    }

    static {
        int i2 = R.drawable.ic_bank_payment_method;
        ACH_BANK_ACCOUNT = new ConsumerPaymentMethodType("ACH_BANK_ACCOUNT", 0, Integer.valueOf(i2));
        int i3 = R.drawable.ic_card_payment_method;
        DEBIT_CARD = new ConsumerPaymentMethodType("DEBIT_CARD", 1, Integer.valueOf(i3));
        CREDIT_CARD = new ConsumerPaymentMethodType("CREDIT_CARD", 2, Integer.valueOf(i3));
        SECURE3D_CARD = new ConsumerPaymentMethodType("SECURE3D_CARD", 3, Integer.valueOf(i3));
        FEDWIRE = new ConsumerPaymentMethodType("FEDWIRE", 4, Integer.valueOf(R.drawable.ic_fedwire_payment_method));
        FIAT_ACCOUNT = new ConsumerPaymentMethodType("FIAT_ACCOUNT", 5, null);
        IDEAL_BANK_ACCOUNT = new ConsumerPaymentMethodType("IDEAL_BANK_ACCOUNT", 6, Integer.valueOf(R.drawable.ic_ideal_payment_method));
        PAYPAL_ACCOUNT = new ConsumerPaymentMethodType("PAYPAL_ACCOUNT", 7, Integer.valueOf(R.drawable.ic_paypal_payment_method));
        SEPA_BANK_ACCOUNT = new ConsumerPaymentMethodType("SEPA_BANK_ACCOUNT", 8, Integer.valueOf(i2));
        SOFORT = new ConsumerPaymentMethodType("SOFORT", 9, Integer.valueOf(R.drawable.ic_sofort_payment_method));
        UK_BANK_ACCOUNT = new ConsumerPaymentMethodType("UK_BANK_ACCOUNT", 10, Integer.valueOf(i2));
        WORLDPAY_CARD = new ConsumerPaymentMethodType("WORLDPAY_CARD", 11, Integer.valueOf(i3));
        XFERS_ACCOUNT = new ConsumerPaymentMethodType("XFERS_ACCOUNT", 12, null);
        UNKNOWN = new ConsumerPaymentMethodType("UNKNOWN", 13, null);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private ConsumerPaymentMethodType(String str, int i2, Integer num) {
        this.iconRes = num;
    }

    public static ConsumerPaymentMethodType valueOf(String str) {
        return (ConsumerPaymentMethodType) Enum.valueOf(ConsumerPaymentMethodType.class, str);
    }

    public static ConsumerPaymentMethodType[] values() {
        return (ConsumerPaymentMethodType[]) $VALUES.clone();
    }

    public final Integer getIconRes() {
        return this.iconRes;
    }

    @Override // java.lang.Enum
    public String toString() {
        String name = name();
        Locale US = Locale.US;
        m.f(US, "US");
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase(US);
        m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}