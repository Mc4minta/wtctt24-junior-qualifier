package com.coinbase.wallet.stellar.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: XLMConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u00020%8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(R\u001c\u0010*\u001a\u00020)8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/coinbase/wallet/stellar/models/XLMConfiguration;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "displayName", "(Lcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "decimals", "I", "getDecimals", "()I", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networkSetting", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "getNetworkSetting", "()Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "", "refreshInterval", "J", "getRefreshInterval", "()J", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Ljava/net/URL;", "imageURL", "Ljava/net/URL;", "getImageURL", "()Ljava/net/URL;", "", "isWalletIndexSwitchable", "Z", "()Z", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "defaultReceiveType", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "getDefaultReceiveType", "()Lcom/coinbase/wallet/blockchains/models/AddressType;", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/NetworkSetting;JLcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/net/URL;Lcom/coinbase/wallet/blockchains/models/AddressType;Z)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XLMConfiguration extends WalletConfiguration {
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final AddressType defaultReceiveType;
    private final URL imageURL;
    private final boolean isWalletIndexSwitchable;
    private final NetworkSetting networkSetting;
    private final long refreshInterval;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XLMConfiguration(Blockchain blockchain, NetworkSetting networkSetting, long j2, CurrencyCode currencyCode, int i2, URL url, AddressType defaultReceiveType, boolean z) {
        super(blockchain, networkSetting, j2, currencyCode, i2, url, defaultReceiveType, z, false);
        m.g(blockchain, "blockchain");
        m.g(networkSetting, "networkSetting");
        m.g(currencyCode, "currencyCode");
        m.g(defaultReceiveType, "defaultReceiveType");
        this.blockchain = blockchain;
        this.networkSetting = networkSetting;
        this.refreshInterval = j2;
        this.currencyCode = currencyCode;
        this.decimals = i2;
        this.imageURL = url;
        this.defaultReceiveType = defaultReceiveType;
        this.isWalletIndexSwitchable = z;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public String displayName(Network network) {
        m.g(network, "network");
        return network.isTestnet() ? "Testnet Stellar Lumens" : "Stellar Lumens";
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public int getDecimals() {
        return this.decimals;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public AddressType getDefaultReceiveType() {
        return this.defaultReceiveType;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public URL getImageURL() {
        return this.imageURL;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public NetworkSetting getNetworkSetting() {
        return this.networkSetting;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public long getRefreshInterval() {
        return this.refreshInterval;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public boolean isWalletIndexSwitchable() {
        return this.isWalletIndexSwitchable;
    }
}