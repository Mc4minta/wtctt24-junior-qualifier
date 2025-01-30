package com.coinbase.wallet.bip44wallets.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.android.apiv3.generated.authed.b;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BIP44Configuration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 S2\u00020\u0001:\u0001SBw\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010&\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0010\u0012\u0006\u0010)\u001a\u00020\u0013\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010+\u001a\u00020\b\u0012\u0006\u0010,\u001a\u00020\u001b\u0012\u0006\u0010-\u001a\u00020\u0013\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020!\u0012\u0006\u00101\u001a\u00020\u001b¢\u0006\u0004\bQ\u0010RJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0015J\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000fJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010\u000fJ\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b$\u0010\u001dJ\u009a\u0001\u00102\u001a\u00020\u00002\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00132\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020!2\b\b\u0002\u00101\u001a\u00020\u001bHÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b4\u0010\u000fJ\u0010\u00105\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b5\u0010\u0015J\u001a\u00109\u001a\u0002082\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b9\u0010:R\u001c\u0010)\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010;\u001a\u0004\b<\u0010\u0015R\u0019\u0010/\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010=\u001a\u0004\b>\u0010\u000fR\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010?\u001a\u0004\b@\u0010\nR\u0019\u0010'\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010=\u001a\u0004\bA\u0010\u000fR\u0019\u0010.\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010=\u001a\u0004\bB\u0010\u000fR\u001c\u00101\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u0010C\u001a\u0004\bD\u0010\u001dR\u0019\u0010-\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010;\u001a\u0004\bE\u0010\u0015R\u001c\u0010+\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010F\u001a\u0004\bG\u0010\u001aR\u0019\u0010,\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010C\u001a\u0004\bH\u0010\u001dR\u001c\u0010&\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010I\u001a\u0004\bJ\u0010\rR\u001c\u0010(\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010K\u001a\u0004\bL\u0010\u0012R\u001e\u0010*\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010M\u001a\u0004\bN\u0010\u0018R\u001c\u00100\u001a\u00020!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u0010O\u001a\u0004\bP\u0010#¨\u0006T"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "displayName", "(Lcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "component1", "()Ljava/util/List;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component2", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component3", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component4", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component5", "()I", "Ljava/net/URL;", "component6", "()Ljava/net/URL;", "component7", "()Lcom/coinbase/wallet/blockchains/models/AddressType;", "", "component8", "()J", "component9", "component10", "component11", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "component12", "()Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "component13", "supportedAddressTypes", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "currencyName", AppsFlyerProperties.CURRENCY_CODE, "decimals", "imageURL", "defaultReceiveType", "txResubmitterInterval", "maxSubmissionAttempts", "qrCodeUriMainnetScheme", "qrCodeUriTestnetScheme", "networkSetting", "refreshInterval", "copy", "(Ljava/util/List;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/net/URL;Lcom/coinbase/wallet/blockchains/models/AddressType;JILjava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/NetworkSetting;J)Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDecimals", "Ljava/lang/String;", "getQrCodeUriTestnetScheme", "Ljava/util/List;", "getSupportedAddressTypes", "getCurrencyName", "getQrCodeUriMainnetScheme", "J", "getRefreshInterval", "getMaxSubmissionAttempts", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "getDefaultReceiveType", "getTxResubmitterInterval", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/net/URL;", "getImageURL", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "getNetworkSetting", "<init>", "(Ljava/util/List;Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/net/URL;Lcom/coinbase/wallet/blockchains/models/AddressType;JILjava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/NetworkSetting;J)V", "Companion", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44Configuration extends WalletConfiguration {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String currencyName;
    private final int decimals;
    private final AddressType defaultReceiveType;
    private final URL imageURL;
    private final int maxSubmissionAttempts;
    private final NetworkSetting networkSetting;
    private final String qrCodeUriMainnetScheme;
    private final String qrCodeUriTestnetScheme;
    private final long refreshInterval;
    private final List<AddressType> supportedAddressTypes;
    private final long txResubmitterInterval;

    /* compiled from: BIP44Configuration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44Configuration$Companion;", "", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BIP44Configuration(List<AddressType> supportedAddressTypes, Blockchain blockchain, String currencyName, CurrencyCode currencyCode, int i2, URL url, AddressType defaultReceiveType, long j2, int i3, String qrCodeUriMainnetScheme, String qrCodeUriTestnetScheme, NetworkSetting networkSetting, long j3) {
        super(blockchain, networkSetting, j3, currencyCode, i2, url, defaultReceiveType, false, true);
        m.g(supportedAddressTypes, "supportedAddressTypes");
        m.g(blockchain, "blockchain");
        m.g(currencyName, "currencyName");
        m.g(currencyCode, "currencyCode");
        m.g(defaultReceiveType, "defaultReceiveType");
        m.g(qrCodeUriMainnetScheme, "qrCodeUriMainnetScheme");
        m.g(qrCodeUriTestnetScheme, "qrCodeUriTestnetScheme");
        m.g(networkSetting, "networkSetting");
        this.supportedAddressTypes = supportedAddressTypes;
        this.blockchain = blockchain;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.decimals = i2;
        this.imageURL = url;
        this.defaultReceiveType = defaultReceiveType;
        this.txResubmitterInterval = j2;
        this.maxSubmissionAttempts = i3;
        this.qrCodeUriMainnetScheme = qrCodeUriMainnetScheme;
        this.qrCodeUriTestnetScheme = qrCodeUriTestnetScheme;
        this.networkSetting = networkSetting;
        this.refreshInterval = j3;
    }

    public final List<AddressType> component1() {
        return this.supportedAddressTypes;
    }

    public final String component10() {
        return this.qrCodeUriMainnetScheme;
    }

    public final String component11() {
        return this.qrCodeUriTestnetScheme;
    }

    public final NetworkSetting component12() {
        return getNetworkSetting();
    }

    public final long component13() {
        return getRefreshInterval();
    }

    public final Blockchain component2() {
        return getBlockchain();
    }

    public final String component3() {
        return this.currencyName;
    }

    public final CurrencyCode component4() {
        return getCurrencyCode();
    }

    public final int component5() {
        return getDecimals();
    }

    public final URL component6() {
        return getImageURL();
    }

    public final AddressType component7() {
        return getDefaultReceiveType();
    }

    public final long component8() {
        return this.txResubmitterInterval;
    }

    public final int component9() {
        return this.maxSubmissionAttempts;
    }

    public final BIP44Configuration copy(List<AddressType> supportedAddressTypes, Blockchain blockchain, String currencyName, CurrencyCode currencyCode, int i2, URL url, AddressType defaultReceiveType, long j2, int i3, String qrCodeUriMainnetScheme, String qrCodeUriTestnetScheme, NetworkSetting networkSetting, long j3) {
        m.g(supportedAddressTypes, "supportedAddressTypes");
        m.g(blockchain, "blockchain");
        m.g(currencyName, "currencyName");
        m.g(currencyCode, "currencyCode");
        m.g(defaultReceiveType, "defaultReceiveType");
        m.g(qrCodeUriMainnetScheme, "qrCodeUriMainnetScheme");
        m.g(qrCodeUriTestnetScheme, "qrCodeUriTestnetScheme");
        m.g(networkSetting, "networkSetting");
        return new BIP44Configuration(supportedAddressTypes, blockchain, currencyName, currencyCode, i2, url, defaultReceiveType, j2, i3, qrCodeUriMainnetScheme, qrCodeUriTestnetScheme, networkSetting, j3);
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public String displayName(Network network) {
        m.g(network, "network");
        return network.isTestnet() ? m.o("Testnet ", this.currencyName) : this.currencyName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BIP44Configuration) {
            BIP44Configuration bIP44Configuration = (BIP44Configuration) obj;
            return m.c(this.supportedAddressTypes, bIP44Configuration.supportedAddressTypes) && m.c(getBlockchain(), bIP44Configuration.getBlockchain()) && m.c(this.currencyName, bIP44Configuration.currencyName) && m.c(getCurrencyCode(), bIP44Configuration.getCurrencyCode()) && getDecimals() == bIP44Configuration.getDecimals() && m.c(getImageURL(), bIP44Configuration.getImageURL()) && m.c(getDefaultReceiveType(), bIP44Configuration.getDefaultReceiveType()) && this.txResubmitterInterval == bIP44Configuration.txResubmitterInterval && this.maxSubmissionAttempts == bIP44Configuration.maxSubmissionAttempts && m.c(this.qrCodeUriMainnetScheme, bIP44Configuration.qrCodeUriMainnetScheme) && m.c(this.qrCodeUriTestnetScheme, bIP44Configuration.qrCodeUriTestnetScheme) && m.c(getNetworkSetting(), bIP44Configuration.getNetworkSetting()) && getRefreshInterval() == bIP44Configuration.getRefreshInterval();
        }
        return false;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getCurrencyName() {
        return this.currencyName;
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

    public final int getMaxSubmissionAttempts() {
        return this.maxSubmissionAttempts;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public NetworkSetting getNetworkSetting() {
        return this.networkSetting;
    }

    public final String getQrCodeUriMainnetScheme() {
        return this.qrCodeUriMainnetScheme;
    }

    public final String getQrCodeUriTestnetScheme() {
        return this.qrCodeUriTestnetScheme;
    }

    @Override // com.coinbase.wallet.blockchains.models.WalletConfiguration
    public long getRefreshInterval() {
        return this.refreshInterval;
    }

    public final List<AddressType> getSupportedAddressTypes() {
        return this.supportedAddressTypes;
    }

    public final long getTxResubmitterInterval() {
        return this.txResubmitterInterval;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.supportedAddressTypes.hashCode() * 31) + getBlockchain().hashCode()) * 31) + this.currencyName.hashCode()) * 31) + getCurrencyCode().hashCode()) * 31) + getDecimals()) * 31) + (getImageURL() == null ? 0 : getImageURL().hashCode())) * 31) + getDefaultReceiveType().hashCode()) * 31) + b.a(this.txResubmitterInterval)) * 31) + this.maxSubmissionAttempts) * 31) + this.qrCodeUriMainnetScheme.hashCode()) * 31) + this.qrCodeUriTestnetScheme.hashCode()) * 31) + getNetworkSetting().hashCode()) * 31) + b.a(getRefreshInterval());
    }

    public String toString() {
        return "BIP44Configuration(supportedAddressTypes=" + this.supportedAddressTypes + ", blockchain=" + getBlockchain() + ", currencyName=" + this.currencyName + ", currencyCode=" + getCurrencyCode() + ", decimals=" + getDecimals() + ", imageURL=" + getImageURL() + ", defaultReceiveType=" + getDefaultReceiveType() + ", txResubmitterInterval=" + this.txResubmitterInterval + ", maxSubmissionAttempts=" + this.maxSubmissionAttempts + ", qrCodeUriMainnetScheme=" + this.qrCodeUriMainnetScheme + ", qrCodeUriTestnetScheme=" + this.qrCodeUriTestnetScheme + ", networkSetting=" + getNetworkSetting() + ", refreshInterval=" + getRefreshInterval() + ')';
    }
}