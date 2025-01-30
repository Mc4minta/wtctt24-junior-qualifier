package com.coinbase.wallet.txhistory.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: TxAddress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BU\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b:\u0010;BM\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010<\u001a\u00020\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b:\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016Jn\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u0019\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\bR\u001c\u0010\u001a\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u000bR\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b5\u0010\u0004R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b7\u0010\u0012R\u001c\u0010\u001f\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0016¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxAddress;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component3", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component4", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component6", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component7", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component8", "Lcom/coinbase/wallet/blockchains/models/Network;", "component9", "()Lcom/coinbase/wallet/blockchains/models/Network;", "id", MessageBundle.TITLE_ENTRY, RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "address", "recipientType", "metadataKey", SendConfirmationArgs.metadataKey, "network", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/txhistory/models/TxAddress;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMetadata", "getAddress", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "getTitle", "getId", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)V", "type", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxAddress implements DatabaseModelObject {
    private final String address;
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String id;
    private final String metadata;
    private final TxMetadataKey metadataKey;
    private final Network network;
    private final RecipientType recipientType;
    private final String title;

    public TxAddress(String id, String title, Blockchain blockchain, CurrencyCode currencyCode, String address, RecipientType recipientType, TxMetadataKey txMetadataKey, String str, Network network) {
        m.g(id, "id");
        m.g(title, "title");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(address, "address");
        m.g(recipientType, "recipientType");
        m.g(network, "network");
        this.id = id;
        this.title = title;
        this.blockchain = blockchain;
        this.currencyCode = currencyCode;
        this.address = address;
        this.recipientType = recipientType;
        this.metadataKey = txMetadataKey;
        this.metadata = str;
        this.network = network;
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return this.title;
    }

    public final Blockchain component3() {
        return this.blockchain;
    }

    public final CurrencyCode component4() {
        return this.currencyCode;
    }

    public final String component5() {
        return this.address;
    }

    public final RecipientType component6() {
        return this.recipientType;
    }

    public final TxMetadataKey component7() {
        return this.metadataKey;
    }

    public final String component8() {
        return this.metadata;
    }

    public final Network component9() {
        return this.network;
    }

    public final TxAddress copy(String id, String title, Blockchain blockchain, CurrencyCode currencyCode, String address, RecipientType recipientType, TxMetadataKey txMetadataKey, String str, Network network) {
        m.g(id, "id");
        m.g(title, "title");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(address, "address");
        m.g(recipientType, "recipientType");
        m.g(network, "network");
        return new TxAddress(id, title, blockchain, currencyCode, address, recipientType, txMetadataKey, str, network);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TxAddress) {
            TxAddress txAddress = (TxAddress) obj;
            return m.c(getId(), txAddress.getId()) && m.c(this.title, txAddress.title) && m.c(this.blockchain, txAddress.blockchain) && m.c(this.currencyCode, txAddress.currencyCode) && m.c(this.address, txAddress.address) && this.recipientType == txAddress.recipientType && m.c(this.metadataKey, txAddress.metadataKey) && m.c(this.metadata, txAddress.metadata) && m.c(this.network, txAddress.network);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final TxMetadataKey getMetadataKey() {
        return this.metadataKey;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final RecipientType getRecipientType() {
        return this.recipientType;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((((((((getId().hashCode() * 31) + this.title.hashCode()) * 31) + this.blockchain.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.address.hashCode()) * 31) + this.recipientType.hashCode()) * 31;
        TxMetadataKey txMetadataKey = this.metadataKey;
        int hashCode2 = (hashCode + (txMetadataKey == null ? 0 : txMetadataKey.hashCode())) * 31;
        String str = this.metadata;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.network.hashCode();
    }

    public String toString() {
        return "TxAddress(id=" + getId() + ", title=" + this.title + ", blockchain=" + this.blockchain + ", currencyCode=" + this.currencyCode + ", address=" + this.address + ", recipientType=" + this.recipientType + ", metadataKey=" + this.metadataKey + ", metadata=" + ((Object) this.metadata) + ", network=" + this.network + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TxAddress(com.coinbase.wallet.blockchains.models.Blockchain r20, com.coinbase.wallet.blockchains.models.CurrencyCode r21, com.coinbase.wallet.blockchains.models.Network r22, java.lang.String r23, java.lang.String r24, com.coinbase.wallet.txhistory.models.RecipientType r25, com.coinbase.wallet.blockchains.models.TxMetadataKey r26, java.lang.String r27) {
        /*
            r19 = this;
            r5 = r24
            java.lang.String r0 = "blockchain"
            r3 = r20
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "currencyCode"
            r4 = r21
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "network"
            r9 = r22
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "title"
            r2 = r23
            kotlin.jvm.internal.m.g(r2, r0)
            java.lang.String r0 = "address"
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.String r0 = "type"
            r6 = r25
            kotlin.jvm.internal.m.g(r6, r0)
            r0 = 6
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = r20.getRawValue()
            r7 = 0
            r0[r7] = r1
            java.lang.String r1 = r21.getRawValue()
            r7 = 1
            r0[r7] = r1
            java.lang.String r1 = r22.getRawValue()
            r7 = 2
            r0[r7] = r1
            r1 = 3
            r0[r1] = r5
            if (r26 != 0) goto L49
            r1 = 0
            goto L4d
        L49:
            java.lang.String r1 = r26.getRawValue()
        L4d:
            if (r1 != 0) goto L55
            com.coinbase.wallet.core.extensions.Strings r1 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r1 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r1)
        L55:
            r7 = 4
            r0[r7] = r1
            r1 = 5
            if (r27 != 0) goto L62
            com.coinbase.wallet.core.extensions.Strings r7 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r7 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r7)
            goto L64
        L62:
            r7 = r27
        L64:
            r0[r1] = r7
            java.util.List r10 = kotlin.a0.p.j(r0)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 62
            r18 = 0
            java.lang.String r11 = "/"
            java.lang.String r0 = kotlin.a0.p.h0(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r7 = "US"
            kotlin.jvm.internal.m.f(r1, r7)
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r7)
            java.lang.String r1 = r0.toLowerCase(r1)
            java.lang.String r0 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.m.f(r1, r0)
            r0 = r19
            r2 = r23
            r3 = r20
            r4 = r21
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.models.TxAddress.<init>(com.coinbase.wallet.blockchains.models.Blockchain, com.coinbase.wallet.blockchains.models.CurrencyCode, com.coinbase.wallet.blockchains.models.Network, java.lang.String, java.lang.String, com.coinbase.wallet.txhistory.models.RecipientType, com.coinbase.wallet.blockchains.models.TxMetadataKey, java.lang.String):void");
    }
}