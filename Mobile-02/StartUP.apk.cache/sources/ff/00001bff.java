package com.coinbase.wallet.ethereum.dtos;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20BalancesResult.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "tokenBalance", "errorMessage", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20BalancesDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTokenBalance", "getContractAddress", "getErrorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20BalancesDTO {
    private final String contractAddress;
    private final String errorMessage;
    private final String tokenBalance;

    public GetERC20BalancesDTO(String contractAddress, String tokenBalance, String str) {
        m.g(contractAddress, "contractAddress");
        m.g(tokenBalance, "tokenBalance");
        this.contractAddress = contractAddress;
        this.tokenBalance = tokenBalance;
        this.errorMessage = str;
    }

    public static /* synthetic */ GetERC20BalancesDTO copy$default(GetERC20BalancesDTO getERC20BalancesDTO, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getERC20BalancesDTO.contractAddress;
        }
        if ((i2 & 2) != 0) {
            str2 = getERC20BalancesDTO.tokenBalance;
        }
        if ((i2 & 4) != 0) {
            str3 = getERC20BalancesDTO.errorMessage;
        }
        return getERC20BalancesDTO.copy(str, str2, str3);
    }

    public final String component1() {
        return this.contractAddress;
    }

    public final String component2() {
        return this.tokenBalance;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final GetERC20BalancesDTO copy(String contractAddress, String tokenBalance, String str) {
        m.g(contractAddress, "contractAddress");
        m.g(tokenBalance, "tokenBalance");
        return new GetERC20BalancesDTO(contractAddress, tokenBalance, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetERC20BalancesDTO) {
            GetERC20BalancesDTO getERC20BalancesDTO = (GetERC20BalancesDTO) obj;
            return m.c(this.contractAddress, getERC20BalancesDTO.contractAddress) && m.c(this.tokenBalance, getERC20BalancesDTO.tokenBalance) && m.c(this.errorMessage, getERC20BalancesDTO.errorMessage);
        }
        return false;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getTokenBalance() {
        return this.tokenBalance;
    }

    public int hashCode() {
        int hashCode = ((this.contractAddress.hashCode() * 31) + this.tokenBalance.hashCode()) * 31;
        String str = this.errorMessage;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "GetERC20BalancesDTO(contractAddress=" + this.contractAddress + ", tokenBalance=" + this.tokenBalance + ", errorMessage=" + ((Object) this.errorMessage) + ')';
    }
}