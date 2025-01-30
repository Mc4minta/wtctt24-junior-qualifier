package com.coinbase.wallet.analytics;

import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.s0;

/* compiled from: Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "appsFlyerEventNames", "Ljava/util/Set;", "analytics_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsKt {
    private static final Set<String> appsFlyerEventNames;

    static {
        Set<String> e2;
        e2 = s0.e("onboarding.new_wallet.created", "onboarding.restore_wallet.success", "task_confirm_transaction_tx_submitted_success", "confirm_transaction.tx_submitted", "balance_update");
        appsFlyerEventNames = e2;
    }
}