package com.coinbase.wallet.common.utilities;

import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import l.a.a;

/* compiled from: Locales.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/common/utilities/Locales;", "", "Ljava/util/Locale;", "getCurrent", "()Ljava/util/Locale;", "current", "<init>", "()V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Locales {
    public static final Locales INSTANCE = new Locales();

    private Locales() {
    }

    public final Locale getCurrent() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Contexts.INSTANCE.getApp().getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Contexts.INSTANCE.getApp().getResources().getConfiguration().locale;
            }
            m.f(locale, "{\n                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {\n                    Contexts.app.resources.configuration.locales.get(0)\n                } else {\n                    Contexts.app.resources.configuration.locale\n                }\n            }");
            return locale;
        } catch (NullPointerException e2) {
            a.f(e2, "NPE when getting locale", new Object[0]);
            Locale locale2 = Locale.US;
            m.f(locale2, "{\n                Timber.e(e, \"NPE when getting locale\")\n                // Default to something!\n                Locale.US\n            }");
            return locale2;
        }
    }
}