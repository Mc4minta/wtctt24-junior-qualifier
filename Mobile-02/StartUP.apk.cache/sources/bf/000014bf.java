package com.coinbase.wallet.commonui.utilities;

import com.coinbase.wallet.common.utilities.Contexts;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Colors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/Colors;", "", "id", "get", "(Lcom/coinbase/wallet/commonui/utilities/Colors;I)I", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ColorsKt {
    public static final int get(Colors colors, int i2) {
        m.g(colors, "<this>");
        return androidx.core.content.a.d(Contexts.INSTANCE.getApp(), i2);
    }
}