package com.coinbase.wallet.common.extensions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Trace+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "", ApiConstants.NAME, "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;Lkotlin/e0/c/a;)Ljava/lang/Object;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Trace_CommonKt {
    public static final <T> T trace(String name, kotlin.e0.c.a<? extends T> block) {
        m.g(name, "name");
        m.g(block, "block");
        return block.invoke();
    }
}