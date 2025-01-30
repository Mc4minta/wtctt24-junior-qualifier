package com.coinbase.wallet.bip44wallets.dtos;

import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BatchBalanceDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/dtos/BatchBalanceDTO;", "", "", "", "Ljava/math/BigInteger;", "result", "Ljava/util/Map;", "getResult", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BatchBalanceDTO {
    private final Map<String, BigInteger> result;

    /* JADX WARN: Multi-variable type inference failed */
    public BatchBalanceDTO(Map<String, ? extends BigInteger> result) {
        m.g(result, "result");
        this.result = result;
    }

    public final Map<String, BigInteger> getResult() {
        return this.result;
    }
}