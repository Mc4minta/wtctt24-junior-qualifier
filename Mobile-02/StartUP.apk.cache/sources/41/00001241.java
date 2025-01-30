package com.coinbase.wallet.application.util;

import android.app.Activity;
import com.coinbase.wallet.commonui.extensions.Activity_ApplicationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ContactUsLauncher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "", "Landroid/app/Activity;", "activity", "Lkotlin/x;", "launch", "(Landroid/app/Activity;)V", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ContactUsLauncher {
    private static final String CONTACT_US_URL = "https://help.coinbase.com/en/more/coinbase-wallet";
    public static final Companion Companion = new Companion(null);

    /* compiled from: ContactUsLauncher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/util/ContactUsLauncher$Companion;", "", "", "CONTACT_US_URL", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void launch(Activity activity) {
        m.g(activity, "activity");
        Activity_ApplicationKt.launchCustomTab$default(activity, CONTACT_US_URL, 268435456, null, new ContactUsLauncher$launch$1(activity), 4, null);
    }
}