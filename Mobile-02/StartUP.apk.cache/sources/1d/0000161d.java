package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.analytics.models.EventProperty;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: EventProperty+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"!\u0010\u000f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"!\u0010\u0012\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"!\u0010\u0015\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0005\"!\u0010\u0018\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0005\"!\u0010\u001b\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0005\"!\u0010\u001e\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0005\"!\u0010!\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u0005¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;", "Lcom/coinbase/wallet/analytics/models/EventProperty;", "AttemptNumber$delegate", "Lkotlin/h;", "getAttemptNumber", "(Lcom/coinbase/wallet/analytics/models/EventProperty$Companion;)Lcom/coinbase/wallet/analytics/models/EventProperty;", "AttemptNumber", "BalanceIncreased$delegate", "getBalanceIncreased", "BalanceIncreased", "OnrampEnabled$delegate", "getOnrampEnabled", "OnrampEnabled", "SendSelected$delegate", "getSendSelected", "SendSelected", "RequiresCompletionStep$delegate", "getRequiresCompletionStep", "RequiresCompletionStep", "OAuthType$delegate", "getOAuthType", "OAuthType", "PaymentMethodType$delegate", "getPaymentMethodType", "PaymentMethodType", "FiatSelected$delegate", "getFiatSelected", "FiatSelected", "MaxTransfer$delegate", "getMaxTransfer", "MaxTransfer", "BuyStatus$delegate", "getBuyStatus", "BuyStatus", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EventProperty_ConsumerKt {
    private static final h AttemptNumber$delegate;
    private static final h BalanceIncreased$delegate;
    private static final h BuyStatus$delegate;
    private static final h FiatSelected$delegate;
    private static final h MaxTransfer$delegate;
    private static final h OAuthType$delegate;
    private static final h OnrampEnabled$delegate;
    private static final h PaymentMethodType$delegate;
    private static final h RequiresCompletionStep$delegate;
    private static final h SendSelected$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        h b7;
        h b8;
        h b9;
        h b10;
        h b11;
        b2 = k.b(EventProperty_ConsumerKt$OAuthType$2.INSTANCE);
        OAuthType$delegate = b2;
        b3 = k.b(EventProperty_ConsumerKt$PaymentMethodType$2.INSTANCE);
        PaymentMethodType$delegate = b3;
        b4 = k.b(EventProperty_ConsumerKt$OnrampEnabled$2.INSTANCE);
        OnrampEnabled$delegate = b4;
        b5 = k.b(EventProperty_ConsumerKt$FiatSelected$2.INSTANCE);
        FiatSelected$delegate = b5;
        b6 = k.b(EventProperty_ConsumerKt$SendSelected$2.INSTANCE);
        SendSelected$delegate = b6;
        b7 = k.b(EventProperty_ConsumerKt$MaxTransfer$2.INSTANCE);
        MaxTransfer$delegate = b7;
        b8 = k.b(EventProperty_ConsumerKt$BuyStatus$2.INSTANCE);
        BuyStatus$delegate = b8;
        b9 = k.b(EventProperty_ConsumerKt$RequiresCompletionStep$2.INSTANCE);
        RequiresCompletionStep$delegate = b9;
        b10 = k.b(EventProperty_ConsumerKt$BalanceIncreased$2.INSTANCE);
        BalanceIncreased$delegate = b10;
        b11 = k.b(EventProperty_ConsumerKt$AttemptNumber$2.INSTANCE);
        AttemptNumber$delegate = b11;
    }

    public static final EventProperty getAttemptNumber(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) AttemptNumber$delegate.getValue();
    }

    public static final EventProperty getBalanceIncreased(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) BalanceIncreased$delegate.getValue();
    }

    public static final EventProperty getBuyStatus(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) BuyStatus$delegate.getValue();
    }

    public static final EventProperty getFiatSelected(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) FiatSelected$delegate.getValue();
    }

    public static final EventProperty getMaxTransfer(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) MaxTransfer$delegate.getValue();
    }

    public static final EventProperty getOAuthType(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) OAuthType$delegate.getValue();
    }

    public static final EventProperty getOnrampEnabled(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) OnrampEnabled$delegate.getValue();
    }

    public static final EventProperty getPaymentMethodType(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) PaymentMethodType$delegate.getValue();
    }

    public static final EventProperty getRequiresCompletionStep(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) RequiresCompletionStep$delegate.getValue();
    }

    public static final EventProperty getSendSelected(EventProperty.Companion companion) {
        m.g(companion, "<this>");
        return (EventProperty) SendSelected$delegate.getValue();
    }
}