package com.coinbase.wallet.common.utilities;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LocalizedStrings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/common/utilities/LocalizedStrings;", "", "", "resId", "", "get", "(I)Ljava/lang/String;", "", "formatArgs", "(I[Ljava/lang/Object;)Ljava/lang/String;", "<init>", "()V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LocalizedStrings {
    public static final LocalizedStrings INSTANCE = new LocalizedStrings();

    private LocalizedStrings() {
    }

    public final String get(int i2) {
        String string = Contexts.INSTANCE.getApp().getString(i2);
        m.f(string, "Contexts.app.getString(resId)");
        return string;
    }

    public final String get(int i2, Object... formatArgs) {
        m.g(formatArgs, "formatArgs");
        String string = Contexts.INSTANCE.getApp().getString(i2, Arrays.copyOf(formatArgs, formatArgs.length));
        m.f(string, "Contexts.app.getString(resId, *formatArgs)");
        return string;
    }
}