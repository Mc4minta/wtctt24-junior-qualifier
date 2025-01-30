package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20BalancesResult.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResult;", "", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResultDTO;", "component1", "()Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResultDTO;", "result", "copy", "(Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResultDTO;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResultDTO;", "getResult", "<init>", "(Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesResultDTO;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20BalancesResult {
    private final GetERC20BalancesResultDTO result;

    public GetERC20BalancesResult(GetERC20BalancesResultDTO result) {
        m.g(result, "result");
        this.result = result;
    }

    public static /* synthetic */ GetERC20BalancesResult copy$default(GetERC20BalancesResult getERC20BalancesResult, GetERC20BalancesResultDTO getERC20BalancesResultDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            getERC20BalancesResultDTO = getERC20BalancesResult.result;
        }
        return getERC20BalancesResult.copy(getERC20BalancesResultDTO);
    }

    public final GetERC20BalancesResultDTO component1() {
        return this.result;
    }

    public final GetERC20BalancesResult copy(GetERC20BalancesResultDTO result) {
        m.g(result, "result");
        return new GetERC20BalancesResult(result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetERC20BalancesResult) && m.c(this.result, ((GetERC20BalancesResult) obj).result);
    }

    public final GetERC20BalancesResultDTO getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "GetERC20BalancesResult(result=" + this.result + ')';
    }
}