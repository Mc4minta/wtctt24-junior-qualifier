package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ConsumerAmountPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerArgs;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "consumerAccount", "", "onrampEnabled", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Z)Landroid/os/Bundle;", "", "onrampEnabledKey", "Ljava/lang/String;", "consumerAccountKey", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerArgs {
    public static final ConsumerAmountPickerArgs INSTANCE = new ConsumerAmountPickerArgs();
    public static final String consumerAccountKey = "consumer_account";
    public static final String onrampEnabledKey = "ONRAMP_USA";

    private ConsumerAmountPickerArgs() {
    }

    public final Bundle createArguments(ConsumerAccount consumerAccount, boolean z) {
        m.g(consumerAccount, "consumerAccount");
        return b.a(u.a(consumerAccountKey, consumerAccount), u.a("ONRAMP_USA", Boolean.valueOf(z)));
    }
}