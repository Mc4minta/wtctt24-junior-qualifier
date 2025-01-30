package com.coinbase.wallet.lending.models;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendInterest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/lending/models/LendInterest;", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component1", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "component2", "()Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "", "component3", "()Ljava/lang/String;", "", "component4", "()I", "code", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "interestEarned", "decimals", "copy", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Ljava/lang/String;I)Lcom/coinbase/wallet/lending/models/LendInterest;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInterestEarned", "I", "getDecimals", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCode", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "getContractAddress", "<init>", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Ljava/lang/String;I)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendInterest {
    private final CurrencyCode code;
    private final ContractAddress contractAddress;
    private final int decimals;
    private final String interestEarned;

    public LendInterest(CurrencyCode code, ContractAddress contractAddress, String interestEarned, int i2) {
        m.g(code, "code");
        m.g(interestEarned, "interestEarned");
        this.code = code;
        this.contractAddress = contractAddress;
        this.interestEarned = interestEarned;
        this.decimals = i2;
    }

    public static /* synthetic */ LendInterest copy$default(LendInterest lendInterest, CurrencyCode currencyCode, ContractAddress contractAddress, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            currencyCode = lendInterest.code;
        }
        if ((i3 & 2) != 0) {
            contractAddress = lendInterest.contractAddress;
        }
        if ((i3 & 4) != 0) {
            str = lendInterest.interestEarned;
        }
        if ((i3 & 8) != 0) {
            i2 = lendInterest.decimals;
        }
        return lendInterest.copy(currencyCode, contractAddress, str, i2);
    }

    public final CurrencyCode component1() {
        return this.code;
    }

    public final ContractAddress component2() {
        return this.contractAddress;
    }

    public final String component3() {
        return this.interestEarned;
    }

    public final int component4() {
        return this.decimals;
    }

    public final LendInterest copy(CurrencyCode code, ContractAddress contractAddress, String interestEarned, int i2) {
        m.g(code, "code");
        m.g(interestEarned, "interestEarned");
        return new LendInterest(code, contractAddress, interestEarned, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendInterest) {
            LendInterest lendInterest = (LendInterest) obj;
            return m.c(this.code, lendInterest.code) && m.c(this.contractAddress, lendInterest.contractAddress) && m.c(this.interestEarned, lendInterest.interestEarned) && this.decimals == lendInterest.decimals;
        }
        return false;
    }

    public final CurrencyCode getCode() {
        return this.code;
    }

    public final ContractAddress getContractAddress() {
        return this.contractAddress;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getInterestEarned() {
        return this.interestEarned;
    }

    public int hashCode() {
        int hashCode = this.code.hashCode() * 31;
        ContractAddress contractAddress = this.contractAddress;
        return ((((hashCode + (contractAddress == null ? 0 : contractAddress.hashCode())) * 31) + this.interestEarned.hashCode()) * 31) + this.decimals;
    }

    public String toString() {
        return "LendInterest(code=" + this.code + ", contractAddress=" + this.contractAddress + ", interestEarned=" + this.interestEarned + ", decimals=" + this.decimals + ')';
    }
}