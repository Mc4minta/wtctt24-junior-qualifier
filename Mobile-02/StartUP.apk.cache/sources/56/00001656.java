package com.coinbase.wallet.consumer.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAddress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004JZ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\rR\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\nR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u0010¨\u00062"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAddress;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component2", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component3", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/Network;", "component4", "()Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component5", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component6", "component7", "address", RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", "metadataKey", SendConfirmationArgs.metadataKey, "email", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerAddress;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmail", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "getMetadata", "getAddress", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAddress {
    private final String address;
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String email;
    private final String metadata;
    private final TxMetadataKey metadataKey;
    private final Network network;

    public ConsumerAddress(String address, Blockchain blockchain, CurrencyCode currencyCode, Network network, TxMetadataKey txMetadataKey, String str, String email) {
        m.g(address, "address");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(email, "email");
        this.address = address;
        this.blockchain = blockchain;
        this.currencyCode = currencyCode;
        this.network = network;
        this.metadataKey = txMetadataKey;
        this.metadata = str;
        this.email = email;
    }

    public static /* synthetic */ ConsumerAddress copy$default(ConsumerAddress consumerAddress, String str, Blockchain blockchain, CurrencyCode currencyCode, Network network, TxMetadataKey txMetadataKey, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerAddress.address;
        }
        if ((i2 & 2) != 0) {
            blockchain = consumerAddress.blockchain;
        }
        Blockchain blockchain2 = blockchain;
        if ((i2 & 4) != 0) {
            currencyCode = consumerAddress.currencyCode;
        }
        CurrencyCode currencyCode2 = currencyCode;
        if ((i2 & 8) != 0) {
            network = consumerAddress.network;
        }
        Network network2 = network;
        if ((i2 & 16) != 0) {
            txMetadataKey = consumerAddress.metadataKey;
        }
        TxMetadataKey txMetadataKey2 = txMetadataKey;
        if ((i2 & 32) != 0) {
            str2 = consumerAddress.metadata;
        }
        String str4 = str2;
        if ((i2 & 64) != 0) {
            str3 = consumerAddress.email;
        }
        return consumerAddress.copy(str, blockchain2, currencyCode2, network2, txMetadataKey2, str4, str3);
    }

    public final String component1() {
        return this.address;
    }

    public final Blockchain component2() {
        return this.blockchain;
    }

    public final CurrencyCode component3() {
        return this.currencyCode;
    }

    public final Network component4() {
        return this.network;
    }

    public final TxMetadataKey component5() {
        return this.metadataKey;
    }

    public final String component6() {
        return this.metadata;
    }

    public final String component7() {
        return this.email;
    }

    public final ConsumerAddress copy(String address, Blockchain blockchain, CurrencyCode currencyCode, Network network, TxMetadataKey txMetadataKey, String str, String email) {
        m.g(address, "address");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(email, "email");
        return new ConsumerAddress(address, blockchain, currencyCode, network, txMetadataKey, str, email);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAddress) {
            ConsumerAddress consumerAddress = (ConsumerAddress) obj;
            return m.c(this.address, consumerAddress.address) && m.c(this.blockchain, consumerAddress.blockchain) && m.c(this.currencyCode, consumerAddress.currencyCode) && m.c(this.network, consumerAddress.network) && m.c(this.metadataKey, consumerAddress.metadataKey) && m.c(this.metadata, consumerAddress.metadata) && m.c(this.email, consumerAddress.email);
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

    public final String getEmail() {
        return this.email;
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

    public int hashCode() {
        int hashCode = ((((((this.address.hashCode() * 31) + this.blockchain.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.network.hashCode()) * 31;
        TxMetadataKey txMetadataKey = this.metadataKey;
        int hashCode2 = (hashCode + (txMetadataKey == null ? 0 : txMetadataKey.hashCode())) * 31;
        String str = this.metadata;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.email.hashCode();
    }

    public String toString() {
        return "ConsumerAddress(address=" + this.address + ", blockchain=" + this.blockchain + ", currencyCode=" + this.currencyCode + ", network=" + this.network + ", metadataKey=" + this.metadataKey + ", metadata=" + ((Object) this.metadata) + ", email=" + this.email + ')';
    }
}