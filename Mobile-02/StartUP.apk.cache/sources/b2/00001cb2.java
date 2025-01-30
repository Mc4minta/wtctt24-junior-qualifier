package com.coinbase.wallet.ethereum.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ERC20.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001BK\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b2\u00103BC\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b2\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jb\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001f\u0010\bJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0016\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\bR\u001c\u0010\u0019\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010\rR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0010R\u001c\u0010\u0018\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b-\u0010\bR\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b.\u0010\u0004R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b1\u0010\u0004¨\u00065"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ERC20;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "component5", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component6", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component7", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Ljava/net/URL;", "component8", "()Ljava/net/URL;", "id", ApiConstants.NAME, "decimals", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID, AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.BLOCKCHAIN, "imageURL", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/net/URL;)Lcom/coinbase/wallet/ethereum/models/ERC20;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDecimals", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/lang/String;", "getId", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "getChainId", "getContractAddress", "Ljava/net/URL;", "getImageURL", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/net/URL;)V", "(Ljava/lang/String;ILjava/lang/String;ILcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/net/URL;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20 implements DatabaseModelObject {
    private final Blockchain blockchain;
    private final int chainId;
    private final String contractAddress;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final String id;
    private final URL imageURL;
    private final String name;

    public ERC20(String id, String name, int i2, String contractAddress, int i3, CurrencyCode currencyCode, Blockchain blockchain, URL url) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(contractAddress, "contractAddress");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        this.id = id;
        this.name = name;
        this.decimals = i2;
        this.contractAddress = contractAddress;
        this.chainId = i3;
        this.currencyCode = currencyCode;
        this.blockchain = blockchain;
        this.imageURL = url;
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.decimals;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final int component5() {
        return this.chainId;
    }

    public final CurrencyCode component6() {
        return this.currencyCode;
    }

    public final Blockchain component7() {
        return this.blockchain;
    }

    public final URL component8() {
        return this.imageURL;
    }

    public final ERC20 copy(String id, String name, int i2, String contractAddress, int i3, CurrencyCode currencyCode, Blockchain blockchain, URL url) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(contractAddress, "contractAddress");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        return new ERC20(id, name, i2, contractAddress, i3, currencyCode, blockchain, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ERC20) {
            ERC20 erc20 = (ERC20) obj;
            return m.c(getId(), erc20.getId()) && m.c(this.name, erc20.name) && this.decimals == erc20.decimals && m.c(this.contractAddress, erc20.contractAddress) && this.chainId == erc20.chainId && m.c(this.currencyCode, erc20.currencyCode) && m.c(this.blockchain, erc20.blockchain) && m.c(this.imageURL, erc20.imageURL);
        }
        return false;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((((((((((((getId().hashCode() * 31) + this.name.hashCode()) * 31) + this.decimals) * 31) + this.contractAddress.hashCode()) * 31) + this.chainId) * 31) + this.currencyCode.hashCode()) * 31) + this.blockchain.hashCode()) * 31;
        URL url = this.imageURL;
        return hashCode + (url == null ? 0 : url.hashCode());
    }

    public String toString() {
        return "ERC20(id=" + getId() + ", name=" + this.name + ", decimals=" + this.decimals + ", contractAddress=" + this.contractAddress + ", chainId=" + this.chainId + ", currencyCode=" + this.currencyCode + ", blockchain=" + this.blockchain + ", imageURL=" + this.imageURL + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ERC20(java.lang.String r18, int r19, java.lang.String r20, int r21, com.coinbase.wallet.blockchains.models.CurrencyCode r22, com.coinbase.wallet.blockchains.models.Blockchain r23, java.net.URL r24) {
        /*
            r17 = this;
            r4 = r20
            java.lang.String r0 = "name"
            r2 = r18
            kotlin.jvm.internal.m.g(r2, r0)
            java.lang.String r0 = "contractAddress"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "currencyCode"
            r6 = r22
            kotlin.jvm.internal.m.g(r6, r0)
            java.lang.String r0 = "blockchain"
            r7 = r23
            kotlin.jvm.internal.m.g(r7, r0)
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = 0
            r0[r1] = r4
            java.lang.String r1 = java.lang.String.valueOf(r21)
            r3 = 1
            r0[r3] = r1
            java.util.List r8 = kotlin.a0.p.j(r0)
            java.lang.String r9 = "/"
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 62
            r16 = 0
            java.lang.String r1 = kotlin.a0.p.h0(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            r3 = r19
            r5 = r21
            r8 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.ethereum.models.ERC20.<init>(java.lang.String, int, java.lang.String, int, com.coinbase.wallet.blockchains.models.CurrencyCode, com.coinbase.wallet.blockchains.models.Blockchain, java.net.URL):void");
    }
}