package com.coinbase.wallet.ethereum.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EthereumBasedConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00015BQ\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u00020%8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\u00020.8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumBasedConfiguration;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "displayName", "(Lcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "Ljava/net/URL;", "imageURLForNetwork", "(Lcom/coinbase/wallet/blockchains/models/Network;)Ljava/net/URL;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodeForNetwork", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "isWalletIndexSwitchable", "Z", "()Z", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networkSetting", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "getNetworkSetting", "()Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "", "refreshInterval", "J", "getRefreshInterval", "()J", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "isERC20Supported", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "defaultReceiveType", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "getDefaultReceiveType", "()Lcom/coinbase/wallet/blockchains/models/AddressType;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "imageURL", "Ljava/net/URL;", "getImageURL", "()Ljava/net/URL;", "", "decimals", "I", "getDecimals", "()I", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/NetworkSetting;JLcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/net/URL;Lcom/coinbase/wallet/blockchains/models/AddressType;ZZ)V", "Companion", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumBasedConfiguration extends WalletConfiguration {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final AddressType defaultReceiveType;
    private final URL imageURL;
    private final boolean isERC20Supported;
    private final boolean isWalletIndexSwitchable;
    private final NetworkSetting networkSetting;
    private final long refreshInterval;

    /* compiled from: EthereumBasedConfiguration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumBasedConfiguration$Companion;", "", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EthereumBasedConfiguration(Blockchain blockchain, NetworkSetting networkSetting, long j2, CurrencyCode currencyCode, int i2, URL url, AddressType defaultReceiveType, boolean z, boolean z2) {
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
        this.isERC20Supported = z2;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public CurrencyCode currencyCodeForNetwork(Network network) {
        m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            return getCurrencyCode();
        }
        String baseAssetCurrencyCode = asEthereumChain.getBaseAssetCurrencyCode();
        if (baseAssetCurrencyCode == null) {
            baseAssetCurrencyCode = getCurrencyCode().getCode();
        }
        return new CurrencyCode(baseAssetCurrencyCode);
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public String displayName(Network network) {
        m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        return asEthereumChain == null ? "Unknown" : asEthereumChain.getBaseAssetDisplayName();
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
    public URL imageURLForNetwork(Network network) {
        m.g(network, "network");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
        if (asEthereumChain == null) {
            return getImageURL();
        }
        if (asEthereumChain.getBaseAssetImageUrl() != null) {
            return new URL(asEthereumChain.getBaseAssetImageUrl());
        }
        return getImageURL();
    }

    public final boolean isERC20Supported() {
        return this.isERC20Supported;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public boolean isWalletIndexSwitchable() {
        return this.isWalletIndexSwitchable;
    }
}