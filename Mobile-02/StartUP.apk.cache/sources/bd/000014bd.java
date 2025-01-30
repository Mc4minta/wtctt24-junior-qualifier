package com.coinbase.wallet.commonui.utilities;

import kotlin.Metadata;
import kotlin.h;
import kotlin.k;

/* compiled from: Colors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/Colors;", "", "", "errorColor$delegate", "Lkotlin/h;", "getErrorColor", "()I", "errorColor", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Colors {
    public static final Colors INSTANCE = new Colors();
    private static final h errorColor$delegate;

    static {
        h b2;
        b2 = k.b(Colors$errorColor$2.INSTANCE);
        errorColor$delegate = b2;
    }

    private Colors() {
    }

    public final int getErrorColor() {
        return ((Number) errorColor$delegate.getValue()).intValue();
    }
}