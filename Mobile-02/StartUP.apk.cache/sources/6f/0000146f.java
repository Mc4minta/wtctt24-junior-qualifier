package com.coinbase.wallet.common.models;

import com.coinbase.wallet.analytics.models.AnalyticsUserProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: UserProperties.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0017\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u0019\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\u001d\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010\u001f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u0019\u0010!\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u0019\u0010#\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014R\u0019\u0010%\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u0019\u0010'\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u0019\u0010)\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R\u0019\u0010+\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/common/models/UserProperties;", "", "", "hasPaymentMethods", "Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "consumerConnectHasPaymentMethods", "(Z)Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "hasUsableAccount", "consumerConnectHasUsableAccount", "", "", "restrictions", "consumerUserRestrictions", "(Ljava/util/List;)Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "enabled", "consumerOnrampEnabled", "consumerEUOnrampEnabled", "cloudBackupDeactivated", "Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "getCloudBackupDeactivated", "()Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "cloudBackupActivated", "getCloudBackupActivated", "lendActivated", "getLendActivated", "userHasBTC", "getUserHasBTC", "userIsActivated", "getUserIsActivated", "userHasLTC", "getUserHasLTC", "userHasCollectible", "getUserHasCollectible", "consumerConnectActivated", "getConsumerConnectActivated", "userHasETC", "getUserHasETC", "userHasXRP", "getUserHasXRP", "userHasETH", "getUserHasETH", "consumerConnectDeactivated", "getConsumerConnectDeactivated", "userHasBCH", "getUserHasBCH", "<init>", "()V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UserProperties {
    public static final UserProperties INSTANCE = new UserProperties();
    private static final AnalyticsUserProperty cloudBackupActivated;
    private static final AnalyticsUserProperty cloudBackupDeactivated;
    private static final AnalyticsUserProperty consumerConnectActivated;
    private static final AnalyticsUserProperty consumerConnectDeactivated;
    private static final AnalyticsUserProperty lendActivated;
    private static final AnalyticsUserProperty userHasBCH;
    private static final AnalyticsUserProperty userHasBTC;
    private static final AnalyticsUserProperty userHasCollectible;
    private static final AnalyticsUserProperty userHasETC;
    private static final AnalyticsUserProperty userHasETH;
    private static final AnalyticsUserProperty userHasLTC;
    private static final AnalyticsUserProperty userHasXRP;
    private static final AnalyticsUserProperty userIsActivated;

    static {
        Boolean bool = Boolean.TRUE;
        cloudBackupActivated = new AnalyticsUserProperty("IsCloudBackupActivated", bool);
        Boolean bool2 = Boolean.FALSE;
        cloudBackupDeactivated = new AnalyticsUserProperty("IsCloudBackupActivated", bool2);
        userIsActivated = new AnalyticsUserProperty("IsActivated", bool);
        userHasETH = new AnalyticsUserProperty("HasETH", bool);
        userHasBTC = new AnalyticsUserProperty("HasBTC", bool);
        userHasETC = new AnalyticsUserProperty("HasETC", bool);
        userHasLTC = new AnalyticsUserProperty("HasLTC", bool);
        userHasBCH = new AnalyticsUserProperty("HasBCH", bool);
        userHasXRP = new AnalyticsUserProperty("HasXRP", bool);
        userHasCollectible = new AnalyticsUserProperty("HasCollectible", bool);
        consumerConnectActivated = new AnalyticsUserProperty("IsConsumerConnectActivated", bool);
        consumerConnectDeactivated = new AnalyticsUserProperty("IsConsumerConnectActivated", bool2);
        lendActivated = new AnalyticsUserProperty("IsLendActivated", bool);
    }

    private UserProperties() {
    }

    public final AnalyticsUserProperty consumerConnectHasPaymentMethods(boolean z) {
        return new AnalyticsUserProperty("HasConsumerPaymentMethods", Boolean.valueOf(z));
    }

    public final AnalyticsUserProperty consumerConnectHasUsableAccount(boolean z) {
        return new AnalyticsUserProperty("HasConsumerUsableAccount", Boolean.valueOf(z));
    }

    public final AnalyticsUserProperty consumerEUOnrampEnabled(boolean z) {
        return new AnalyticsUserProperty("ConsumerEUOnrampEnabled", Boolean.valueOf(z));
    }

    public final AnalyticsUserProperty consumerOnrampEnabled(boolean z) {
        return new AnalyticsUserProperty("ConsumerOnrampEnabled", Boolean.valueOf(z));
    }

    public final AnalyticsUserProperty consumerUserRestrictions(List<String> restrictions) {
        m.g(restrictions, "restrictions");
        return new AnalyticsUserProperty("ConsumerUserRestrictions", restrictions);
    }

    public final AnalyticsUserProperty getCloudBackupActivated() {
        return cloudBackupActivated;
    }

    public final AnalyticsUserProperty getCloudBackupDeactivated() {
        return cloudBackupDeactivated;
    }

    public final AnalyticsUserProperty getConsumerConnectActivated() {
        return consumerConnectActivated;
    }

    public final AnalyticsUserProperty getConsumerConnectDeactivated() {
        return consumerConnectDeactivated;
    }

    public final AnalyticsUserProperty getLendActivated() {
        return lendActivated;
    }

    public final AnalyticsUserProperty getUserHasBCH() {
        return userHasBCH;
    }

    public final AnalyticsUserProperty getUserHasBTC() {
        return userHasBTC;
    }

    public final AnalyticsUserProperty getUserHasCollectible() {
        return userHasCollectible;
    }

    public final AnalyticsUserProperty getUserHasETC() {
        return userHasETC;
    }

    public final AnalyticsUserProperty getUserHasETH() {
        return userHasETH;
    }

    public final AnalyticsUserProperty getUserHasLTC() {
        return userHasLTC;
    }

    public final AnalyticsUserProperty getUserHasXRP() {
        return userHasXRP;
    }

    public final AnalyticsUserProperty getUserIsActivated() {
        return userIsActivated;
    }
}