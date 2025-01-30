package com.coinbase.wallet.common.extensions;

import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: List+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "", "index", "require", "(Ljava/util/List;I)Ljava/lang/Object;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class List_CommonKt {
    public static final <T> T require(List<? extends T> list, int i2) {
        Objects.requireNonNull(list);
        return list.get(i2);
    }
}