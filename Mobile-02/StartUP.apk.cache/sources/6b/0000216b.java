package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.core.util.Optional;
import kotlin.Metadata;

/* compiled from: Observable+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "T", "Lcom/coinbase/wallet/core/util/Optional;", "it", "", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)Z", "com/coinbase/wallet/core/extensions/Observable_CoreKt$unwrap$1"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$handleAdjustableMinerFeeResult$$inlined$unwrap$1<T> implements h.c.m0.p {
    public static final TxSignerViewModel$handleAdjustableMinerFeeResult$$inlined$unwrap$1<T> INSTANCE = new TxSignerViewModel$handleAdjustableMinerFeeResult$$inlined$unwrap$1<>();

    public final boolean test(Optional<? extends T> it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.toNullable() != null;
    }

    @Override // h.c.m0.p
    public /* bridge */ /* synthetic */ boolean test(Object obj) {
        return test((Optional) ((Optional) obj));
    }
}