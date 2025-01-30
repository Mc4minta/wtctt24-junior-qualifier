package com.coinbase.wallet.consumer.models;

import android.content.ComponentName;
import kotlin.Metadata;
import kotlin.h;
import kotlin.k;

/* compiled from: AppToAppConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AppToAppConfig;", "", "", "whiteListedSigner$delegate", "Lkotlin/h;", "getWhiteListedSigner", "()Ljava/lang/String;", "whiteListedSigner", "Landroid/content/ComponentName;", "appToAppComponent$delegate", "getAppToAppComponent", "()Landroid/content/ComponentName;", "appToAppComponent", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppToAppConfig {
    public static final AppToAppConfig INSTANCE = new AppToAppConfig();
    private static final h appToAppComponent$delegate;
    private static final h whiteListedSigner$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(AppToAppConfig$appToAppComponent$2.INSTANCE);
        appToAppComponent$delegate = b2;
        b3 = k.b(AppToAppConfig$whiteListedSigner$2.INSTANCE);
        whiteListedSigner$delegate = b3;
    }

    private AppToAppConfig() {
    }

    public final ComponentName getAppToAppComponent() {
        return (ComponentName) appToAppComponent$delegate.getValue();
    }

    public final String getWhiteListedSigner() {
        return (String) whiteListedSigner$delegate.getValue();
    }
}