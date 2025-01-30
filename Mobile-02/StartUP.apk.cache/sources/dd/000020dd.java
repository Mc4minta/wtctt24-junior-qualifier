package com.coinbase.wallet.features.send.views.adapters;

import com.coinbase.wallet.core.extensions.Strings;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFee1559PresetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "valueOrZero", "(Ljava/lang/String;)Ljava/lang/String;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559PresetAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String valueOrZero(String str) {
        return str.length() == 0 ? Strings.zero : str;
    }
}