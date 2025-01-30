package com.coinbase.wallet.features.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TokenAddressesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/TokenAddressesDTO;", "", "", "", "component1", "()Ljava/util/List;", "contractAddresses", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/features/ethereum/dtos/TokenAddressesDTO;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getContractAddresses", "<init>", "(Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TokenAddressesDTO {
    private final List<String> contractAddresses;

    public TokenAddressesDTO(List<String> contractAddresses) {
        m.g(contractAddresses, "contractAddresses");
        this.contractAddresses = contractAddresses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TokenAddressesDTO copy$default(TokenAddressesDTO tokenAddressesDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = tokenAddressesDTO.contractAddresses;
        }
        return tokenAddressesDTO.copy(list);
    }

    public final List<String> component1() {
        return this.contractAddresses;
    }

    public final TokenAddressesDTO copy(List<String> contractAddresses) {
        m.g(contractAddresses, "contractAddresses");
        return new TokenAddressesDTO(contractAddresses);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TokenAddressesDTO) && m.c(this.contractAddresses, ((TokenAddressesDTO) obj).contractAddresses);
    }

    public final List<String> getContractAddresses() {
        return this.contractAddresses;
    }

    public int hashCode() {
        return this.contractAddresses.hashCode();
    }

    public String toString() {
        return "TokenAddressesDTO(contractAddresses=" + this.contractAddresses + ')';
    }
}