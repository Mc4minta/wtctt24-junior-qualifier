package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.core.util.Optional;
import kotlin.Metadata;

/* compiled from: Observable+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¨\u0006\u0005"}, d2 = {"", "T", "Lcom/coinbase/wallet/core/util/Optional;", "it", "kotlin.jvm.PlatformType", "com/coinbase/wallet/core/extensions/Observable_CoreKt$unwrap$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$handleAdjustableMinerFeeResult$$inlined$unwrap$2<T, R> implements h.c.m0.n {
    public static final TxSignerViewModel$handleAdjustableMinerFeeResult$$inlined$unwrap$2<T, R> INSTANCE = new TxSignerViewModel$handleAdjustableMinerFeeResult$$inlined$unwrap$2<>();

    public final T apply(Optional<? extends T> it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.toNullable();
    }

    @Override // h.c.m0.n
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Optional) ((Optional) obj));
    }
}