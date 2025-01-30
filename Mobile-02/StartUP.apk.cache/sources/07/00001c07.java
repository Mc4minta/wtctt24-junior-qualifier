package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ERC20IconDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsResultDTO;", "", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "component1", "()Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "result", "copy", "(Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsResultDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "getResult", "<init>", "(Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20IconsResultDTO {
    private final GetERC20IconsDTO result;

    public GetERC20IconsResultDTO(GetERC20IconsDTO getERC20IconsDTO) {
        this.result = getERC20IconsDTO;
    }

    public static /* synthetic */ GetERC20IconsResultDTO copy$default(GetERC20IconsResultDTO getERC20IconsResultDTO, GetERC20IconsDTO getERC20IconsDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            getERC20IconsDTO = getERC20IconsResultDTO.result;
        }
        return getERC20IconsResultDTO.copy(getERC20IconsDTO);
    }

    public final GetERC20IconsDTO component1() {
        return this.result;
    }

    public final GetERC20IconsResultDTO copy(GetERC20IconsDTO getERC20IconsDTO) {
        return new GetERC20IconsResultDTO(getERC20IconsDTO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetERC20IconsResultDTO) && m.c(this.result, ((GetERC20IconsResultDTO) obj).result);
    }

    public final GetERC20IconsDTO getResult() {
        return this.result;
    }

    public int hashCode() {
        GetERC20IconsDTO getERC20IconsDTO = this.result;
        if (getERC20IconsDTO == null) {
            return 0;
        }
        return getERC20IconsDTO.hashCode();
    }

    public String toString() {
        return "GetERC20IconsResultDTO(result=" + this.result + ')';
    }
}