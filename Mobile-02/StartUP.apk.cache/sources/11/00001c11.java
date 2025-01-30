package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20TokensOwnedByAddressDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressResultDTO;", "", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;", "component1", "()Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;", "result", "copy", "(Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressResultDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;", "getResult", "<init>", "(Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20TokensOwnedByAddressResultDTO {
    private final GetERC20TokensOwnedByAddressDTO result;

    public GetERC20TokensOwnedByAddressResultDTO(GetERC20TokensOwnedByAddressDTO getERC20TokensOwnedByAddressDTO) {
        this.result = getERC20TokensOwnedByAddressDTO;
    }

    public static /* synthetic */ GetERC20TokensOwnedByAddressResultDTO copy$default(GetERC20TokensOwnedByAddressResultDTO getERC20TokensOwnedByAddressResultDTO, GetERC20TokensOwnedByAddressDTO getERC20TokensOwnedByAddressDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            getERC20TokensOwnedByAddressDTO = getERC20TokensOwnedByAddressResultDTO.result;
        }
        return getERC20TokensOwnedByAddressResultDTO.copy(getERC20TokensOwnedByAddressDTO);
    }

    public final GetERC20TokensOwnedByAddressDTO component1() {
        return this.result;
    }

    public final GetERC20TokensOwnedByAddressResultDTO copy(GetERC20TokensOwnedByAddressDTO getERC20TokensOwnedByAddressDTO) {
        return new GetERC20TokensOwnedByAddressResultDTO(getERC20TokensOwnedByAddressDTO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetERC20TokensOwnedByAddressResultDTO) && m.c(this.result, ((GetERC20TokensOwnedByAddressResultDTO) obj).result);
    }

    public final GetERC20TokensOwnedByAddressDTO getResult() {
        return this.result;
    }

    public int hashCode() {
        GetERC20TokensOwnedByAddressDTO getERC20TokensOwnedByAddressDTO = this.result;
        if (getERC20TokensOwnedByAddressDTO == null) {
            return 0;
        }
        return getERC20TokensOwnedByAddressDTO.hashCode();
    }

    public String toString() {
        return "GetERC20TokensOwnedByAddressResultDTO(result=" + this.result + ')';
    }
}