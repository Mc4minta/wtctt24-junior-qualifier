package com.toshi.model.local.room;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Erc721Token.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\nR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/toshi/model/local/room/Erc721Token;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()I", "component6", "tokenId", ApiConstants.NAME, "address", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID, "image", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/toshi/model/local/room/Erc721Token;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContractAddress", "getAddress", "getImage", "getName", "I", "getChainId", "getTokenId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Erc721Token {
    private final String address;
    private final int chainId;
    private final String contractAddress;
    private final String image;
    private final String name;
    private final String tokenId;

    public Erc721Token(String tokenId, String name, String address, String contractAddress, int i2, String str) {
        m.g(tokenId, "tokenId");
        m.g(name, "name");
        m.g(address, "address");
        m.g(contractAddress, "contractAddress");
        this.tokenId = tokenId;
        this.name = name;
        this.address = address;
        this.contractAddress = contractAddress;
        this.chainId = i2;
        this.image = str;
    }

    public static /* synthetic */ Erc721Token copy$default(Erc721Token erc721Token, String str, String str2, String str3, String str4, int i2, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = erc721Token.tokenId;
        }
        if ((i3 & 2) != 0) {
            str2 = erc721Token.name;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = erc721Token.address;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = erc721Token.contractAddress;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            i2 = erc721Token.chainId;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            str5 = erc721Token.image;
        }
        return erc721Token.copy(str, str6, str7, str8, i4, str5);
    }

    public final String component1() {
        return this.tokenId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.address;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final int component5() {
        return this.chainId;
    }

    public final String component6() {
        return this.image;
    }

    public final Erc721Token copy(String tokenId, String name, String address, String contractAddress, int i2, String str) {
        m.g(tokenId, "tokenId");
        m.g(name, "name");
        m.g(address, "address");
        m.g(contractAddress, "contractAddress");
        return new Erc721Token(tokenId, name, address, contractAddress, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Erc721Token) {
            Erc721Token erc721Token = (Erc721Token) obj;
            return m.c(this.tokenId, erc721Token.tokenId) && m.c(this.name, erc721Token.name) && m.c(this.address, erc721Token.address) && m.c(this.contractAddress, erc721Token.contractAddress) && this.chainId == erc721Token.chainId && m.c(this.image, erc721Token.image);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTokenId() {
        return this.tokenId;
    }

    public int hashCode() {
        int hashCode = ((((((((this.tokenId.hashCode() * 31) + this.name.hashCode()) * 31) + this.address.hashCode()) * 31) + this.contractAddress.hashCode()) * 31) + this.chainId) * 31;
        String str = this.image;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Erc721Token(tokenId=" + this.tokenId + ", name=" + this.name + ", address=" + this.address + ", contractAddress=" + this.contractAddress + ", chainId=" + this.chainId + ", image=" + ((Object) this.image) + ')';
    }
}