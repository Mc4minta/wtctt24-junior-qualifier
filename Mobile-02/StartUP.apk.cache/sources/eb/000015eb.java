package com.coinbase.wallet.consumer.dtos;

import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerPaymentMethodTypeDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerPaymentMethodTypeDTO;", "", "", "toString", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "ACH_BANK_ACCOUNT", "DEBIT_CARD", "CREDIT_CARD", "SECURE3D_CARD", "FEDWIRE", "FIAT_ACCOUNT", "IDEAL_BANK_ACCOUNT", "PAYPAL_ACCOUNT", "SEPA_BANK_ACCOUNT", "SOFORT", "UK_BANK_ACCOUNT", "WORLDPAY_CARD", "XFERS_ACCOUNT", "UNKNOWN", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum ConsumerPaymentMethodTypeDTO {
    ACH_BANK_ACCOUNT,
    DEBIT_CARD,
    CREDIT_CARD,
    SECURE3D_CARD,
    FEDWIRE,
    FIAT_ACCOUNT,
    IDEAL_BANK_ACCOUNT,
    PAYPAL_ACCOUNT,
    SEPA_BANK_ACCOUNT,
    SOFORT,
    UK_BANK_ACCOUNT,
    WORLDPAY_CARD,
    XFERS_ACCOUNT,
    UNKNOWN;

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