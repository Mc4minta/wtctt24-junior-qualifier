package com.coinbase.wallet.wallets.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CryptoCurrency.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b1\u00102B;\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b1\u00103J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\tJX\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\"\u0010\fR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010#\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010&R\u001c\u0010\u001a\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\fR\u001c\u0010\u0019\u001a\u00020\n8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b+\u0010\fR\u001c\u0010\u001d\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010\tR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010\u0013R\u001c\u0010\u001f\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b0\u0010\t¨\u00064"}, d2 = {"Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component2", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component3", "Ljava/net/URL;", "component4", "()Ljava/net/URL;", "component5", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component6", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component7", "id", "code", ApiConstants.NAME, "imageUrl", "decimals", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "sortIndex", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/net/URL;ILcom/coinbase/wallet/blockchains/models/Blockchain;I)Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "toString", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "setBlockchain", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)V", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCode", "Ljava/lang/String;", "getName", "getId", "I", "getDecimals", "Ljava/net/URL;", "getImageUrl", "getSortIndex", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/net/URL;ILcom/coinbase/wallet/blockchains/models/Blockchain;I)V", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/net/URL;ILcom/coinbase/wallet/blockchains/models/Blockchain;I)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CryptoCurrency implements DatabaseModelObject {
    private Blockchain blockchain;
    private final CurrencyCode code;
    private final int decimals;
    private final String id;
    private final URL imageUrl;
    private final String name;
    private final int sortIndex;

    public CryptoCurrency(String id, CurrencyCode code, String name, URL url, int i2, Blockchain blockchain, int i3) {
        m.g(id, "id");
        m.g(code, "code");
        m.g(name, "name");
        m.g(blockchain, "blockchain");
        this.id = id;
        this.code = code;
        this.name = name;
        this.imageUrl = url;
        this.decimals = i2;
        this.blockchain = blockchain;
        this.sortIndex = i3;
    }

    public static /* synthetic */ CryptoCurrency copy$default(CryptoCurrency cryptoCurrency, String str, CurrencyCode currencyCode, String str2, URL url, int i2, Blockchain blockchain, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = cryptoCurrency.getId();
        }
        if ((i4 & 2) != 0) {
            currencyCode = cryptoCurrency.code;
        }
        CurrencyCode currencyCode2 = currencyCode;
        if ((i4 & 4) != 0) {
            str2 = cryptoCurrency.name;
        }
        String str3 = str2;
        if ((i4 & 8) != 0) {
            url = cryptoCurrency.imageUrl;
        }
        URL url2 = url;
        if ((i4 & 16) != 0) {
            i2 = cryptoCurrency.decimals;
        }
        int i5 = i2;
        if ((i4 & 32) != 0) {
            blockchain = cryptoCurrency.blockchain;
        }
        Blockchain blockchain2 = blockchain;
        if ((i4 & 64) != 0) {
            i3 = cryptoCurrency.sortIndex;
        }
        return cryptoCurrency.copy(str, currencyCode2, str3, url2, i5, blockchain2, i3);
    }

    public final String component1() {
        return getId();
    }

    public final CurrencyCode component2() {
        return this.code;
    }

    public final String component3() {
        return this.name;
    }

    public final URL component4() {
        return this.imageUrl;
    }

    public final int component5() {
        return this.decimals;
    }

    public final Blockchain component6() {
        return this.blockchain;
    }

    public final int component7() {
        return this.sortIndex;
    }

    public final CryptoCurrency copy(String id, CurrencyCode code, String name, URL url, int i2, Blockchain blockchain, int i3) {
        m.g(id, "id");
        m.g(code, "code");
        m.g(name, "name");
        m.g(blockchain, "blockchain");
        return new CryptoCurrency(id, code, name, url, i2, blockchain, i3);
    }

    public boolean equals(Object obj) {
        String id = getId();
        CryptoCurrency cryptoCurrency = obj instanceof CryptoCurrency ? (CryptoCurrency) obj : null;
        return m.c(id, cryptoCurrency != null ? cryptoCurrency.getId() : null);
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final CurrencyCode getCode() {
        return this.code;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final URL getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSortIndex() {
        return this.sortIndex;
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public final void setBlockchain(Blockchain blockchain) {
        m.g(blockchain, "<set-?>");
        this.blockchain = blockchain;
    }

    public String toString() {
        return "CryptoCurrency(id=" + getId() + ", code=" + this.code + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", decimals=" + this.decimals + ", blockchain=" + this.blockchain + ", sortIndex=" + this.sortIndex + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CryptoCurrency(com.coinbase.wallet.blockchains.models.CurrencyCode r18, java.lang.String r19, java.net.URL r20, int r21, com.coinbase.wallet.blockchains.models.Blockchain r22, int r23) {
        /*
            r17 = this;
            java.lang.String r0 = "code"
            r3 = r18
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "name"
            r4 = r19
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "blockchain"
            r7 = r22
            kotlin.jvm.internal.m.g(r7, r0)
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = r22.getRawValue()
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = r18.getRawValue()
            r2 = 1
            r0[r2] = r1
            java.util.List r8 = kotlin.a0.p.j(r0)
            java.lang.String r9 = "/"
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 62
            r16 = 0
            java.lang.String r0 = kotlin.a0.p.h0(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "US"
            kotlin.jvm.internal.m.f(r1, r2)
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r2)
            java.lang.String r2 = r0.toUpperCase(r1)
            java.lang.String r0 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.m.f(r2, r0)
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.wallets.models.CryptoCurrency.<init>(com.coinbase.wallet.blockchains.models.CurrencyCode, java.lang.String, java.net.URL, int, com.coinbase.wallet.blockchains.models.Blockchain, int):void");
    }
}