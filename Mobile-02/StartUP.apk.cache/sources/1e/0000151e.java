package com.coinbase.wallet.compoundfinance.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.a;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CryptoCurrencyDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JZ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\tJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\rR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\tR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/dtos/CryptoCurrencyDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "component5", "", "component6", "()D", "component7", ApiConstants.NAME, "code", "imageUrl", "decimals", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "marketCap", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;DLjava/lang/String;)Lcom/coinbase/wallet/compoundfinance/dtos/CryptoCurrencyDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "D", "getMarketCap", "getContractAddress", "I", "getDecimals", "getBlockchain", "getName", "getImageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;DLjava/lang/String;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CryptoCurrencyDTO {
    private final String blockchain;
    private final String code;
    private final String contractAddress;
    private final int decimals;
    private final String imageUrl;
    private final double marketCap;
    private final String name;

    public CryptoCurrencyDTO(String name, String code, String str, int i2, String blockchain, double d2, String str2) {
        m.g(name, "name");
        m.g(code, "code");
        m.g(blockchain, "blockchain");
        this.name = name;
        this.code = code;
        this.imageUrl = str;
        this.decimals = i2;
        this.blockchain = blockchain;
        this.marketCap = d2;
        this.contractAddress = str2;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final int component4() {
        return this.decimals;
    }

    public final String component5() {
        return this.blockchain;
    }

    public final double component6() {
        return this.marketCap;
    }

    public final String component7() {
        return this.contractAddress;
    }

    public final CryptoCurrencyDTO copy(String name, String code, String str, int i2, String blockchain, double d2, String str2) {
        m.g(name, "name");
        m.g(code, "code");
        m.g(blockchain, "blockchain");
        return new CryptoCurrencyDTO(name, code, str, i2, blockchain, d2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CryptoCurrencyDTO) {
            CryptoCurrencyDTO cryptoCurrencyDTO = (CryptoCurrencyDTO) obj;
            return m.c(this.name, cryptoCurrencyDTO.name) && m.c(this.code, cryptoCurrencyDTO.code) && m.c(this.imageUrl, cryptoCurrencyDTO.imageUrl) && this.decimals == cryptoCurrencyDTO.decimals && m.c(this.blockchain, cryptoCurrencyDTO.blockchain) && m.c(Double.valueOf(this.marketCap), Double.valueOf(cryptoCurrencyDTO.marketCap)) && m.c(this.contractAddress, cryptoCurrencyDTO.contractAddress);
        }
        return false;
    }

    public final String getBlockchain() {
        return this.blockchain;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final double getMarketCap() {
        return this.marketCap;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.code.hashCode()) * 31;
        String str = this.imageUrl;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.decimals) * 31) + this.blockchain.hashCode()) * 31) + a.a(this.marketCap)) * 31;
        String str2 = this.contractAddress;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CryptoCurrencyDTO(name=" + this.name + ", code=" + this.code + ", imageUrl=" + ((Object) this.imageUrl) + ", decimals=" + this.decimals + ", blockchain=" + this.blockchain + ", marketCap=" + this.marketCap + ", contractAddress=" + ((Object) this.contractAddress) + ')';
    }
}