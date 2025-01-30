package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20TokensOwnedByAddressDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;", "", "", "", "component1", "()Ljava/util/List;", "contractAddresses", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokensOwnedByAddressDTO;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getContractAddresses", "<init>", "(Ljava/util/List;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20TokensOwnedByAddressDTO {
    private final List<String> contractAddresses;

    public GetERC20TokensOwnedByAddressDTO(List<String> contractAddresses) {
        m.g(contractAddresses, "contractAddresses");
        this.contractAddresses = contractAddresses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetERC20TokensOwnedByAddressDTO copy$default(GetERC20TokensOwnedByAddressDTO getERC20TokensOwnedByAddressDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getERC20TokensOwnedByAddressDTO.contractAddresses;
        }
        return getERC20TokensOwnedByAddressDTO.copy(list);
    }

    public final List<String> component1() {
        return this.contractAddresses;
    }

    public final GetERC20TokensOwnedByAddressDTO copy(List<String> contractAddresses) {
        m.g(contractAddresses, "contractAddresses");
        return new GetERC20TokensOwnedByAddressDTO(contractAddresses);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetERC20TokensOwnedByAddressDTO) && m.c(this.contractAddresses, ((GetERC20TokensOwnedByAddressDTO) obj).contractAddresses);
    }

    public final List<String> getContractAddresses() {
        return this.contractAddresses;
    }

    public int hashCode() {
        return this.contractAddresses.hashCode();
    }

    public String toString() {
        return "GetERC20TokensOwnedByAddressDTO(contractAddresses=" + this.contractAddresses + ')';
    }
}