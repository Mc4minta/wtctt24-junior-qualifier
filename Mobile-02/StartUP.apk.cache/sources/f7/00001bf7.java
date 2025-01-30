package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559DTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559DTO;", "", "Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "result", "Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "getResult", "()Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;", "<init>", "(Lcom/coinbase/wallet/ethereum/dtos/AdjustableMinerFee1559Result;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559DTO {
    private final AdjustableMinerFee1559Result result;

    public AdjustableMinerFee1559DTO(AdjustableMinerFee1559Result result) {
        m.g(result, "result");
        this.result = result;
    }

    public final AdjustableMinerFee1559Result getResult() {
        return this.result;
    }
}