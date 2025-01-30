package com.coinbase.wallet.core.util;

import kotlin.Metadata;

/* compiled from: Optional.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "T", "Lcom/coinbase/wallet/core/util/Optional;", "toOptional", "(Ljava/lang/Object;)Lcom/coinbase/wallet/core/util/Optional;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OptionalKt {
    public static final <T> Optional<T> toOptional(T t) {
        return new Optional<>(t);
    }
}