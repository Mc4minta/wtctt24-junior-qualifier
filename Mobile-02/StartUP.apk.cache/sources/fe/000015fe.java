package com.coinbase.wallet.consumer.dtos;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

/* compiled from: ConsumerUserDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/math/BigDecimal;", "debugWithdrawalLimit", "Ljava/util/concurrent/atomic/AtomicReference;", "getDebugWithdrawalLimit", "()Ljava/util/concurrent/atomic/AtomicReference;", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUserDTOKt {
    private static final AtomicReference<BigDecimal> debugWithdrawalLimit = new AtomicReference<>();

    public static final AtomicReference<BigDecimal> getDebugWithdrawalLimit() {
        return debugWithdrawalLimit;
    }
}