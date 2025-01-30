package com.coinbase.wallet.core.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: Seven.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001aG\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lcom/coinbase/wallet/core/models/Seven;", "", "toList", "(Lcom/coinbase/wallet/core/models/Seven;)Ljava/util/List;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SevenKt {
    public static final <T> List<T> toList(Seven<? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T, ? extends T> seven) {
        List<T> j2;
        m.g(seven, "<this>");
        j2 = r.j(seven.getFirst(), seven.getSecond(), seven.getThird(), seven.getFourth(), seven.getFifth(), seven.getSixth(), seven.getSeventh());
        return j2;
    }
}