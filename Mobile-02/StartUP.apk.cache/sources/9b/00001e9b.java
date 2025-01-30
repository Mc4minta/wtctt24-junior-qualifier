package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.features.lend.models.LendProviderItem;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: Comparisons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: com.coinbase.wallet.features.lend.viewmodels.LendProviderPickerViewModel$setup$lambda-4$$inlined$sortedBy$1  reason: invalid class name */
/* loaded from: classes.dex */
public final class LendProviderPickerViewModel$setup$lambda4$$inlined$sortedBy$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int c2;
        c2 = kotlin.b0.b.c(((LendProviderItem) t).getToken().getProvider().getName(), ((LendProviderItem) t2).getToken().getProvider().getName());
        return c2;
    }
}