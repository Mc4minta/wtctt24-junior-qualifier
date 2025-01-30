package com.coinbase.wallet.bip44wallets.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;

/* compiled from: BIP44UnsignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JV\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\nJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\nR\u001c\u0010\u001a\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010\u0011R\u001c\u0010/\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u000eR(\u00104\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\"028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u001b\u001a\u00020\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b:\u0010\nR\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010;\u001a\u0004\b<\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b=\u0010\u000e¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44UnsignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "component2", "()Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "", "component3", "()Ljava/lang/String;", "component4", "Ljava/math/BigInteger;", "component5", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component6", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/Network;", "component7", "()Lcom/coinbase/wallet/blockchains/models/Network;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "coinSelection", "fromAddress", SendConfirmationArgs.recipientAddressKey, "transferValue", AppsFlyerProperties.CURRENCY_CODE, "network", "copy", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/bip44wallets/models/BIP44UnsignedTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRecipientAddress", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "feeCurrencyCode", "getFeeCurrencyCode", "estimatedFee", "Ljava/math/BigInteger;", "getEstimatedFee", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", SendConfirmationArgs.metadataKey, "Ljava/util/Map;", "getMetadata", "()Ljava/util/Map;", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "getFromAddress", "Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "getCoinSelection", "getTransferValue", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44UnsignedTx implements UnsignedTx {
    private final Blockchain blockchain;
    private final BIP44CoinSelection coinSelection;
    private final CurrencyCode currencyCode;
    private final BigInteger estimatedFee;
    private final CurrencyCode feeCurrencyCode;
    private final String fromAddress;
    private final Map<TxMetadataKey, Object> metadata;
    private final Network network;
    private final String recipientAddress;
    private final BigInteger transferValue;

    public BIP44UnsignedTx(Blockchain blockchain, BIP44CoinSelection coinSelection, String fromAddress, String recipientAddress, BigInteger transferValue, CurrencyCode currencyCode, Network network) {
        Map<TxMetadataKey, Object> i2;
        m.g(blockchain, "blockchain");
        m.g(coinSelection, "coinSelection");
        m.g(fromAddress, "fromAddress");
        m.g(recipientAddress, "recipientAddress");
        m.g(transferValue, "transferValue");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        this.blockchain = blockchain;
        this.coinSelection = coinSelection;
        this.fromAddress = fromAddress;
        this.recipientAddress = recipientAddress;
        this.transferValue = transferValue;
        this.currencyCode = currencyCode;
        this.network = network;
        this.estimatedFee = coinSelection.getFee();
        this.feeCurrencyCode = getCurrencyCode();
        i2 = m0.i();
        this.metadata = i2;
    }

    public static /* synthetic */ BIP44UnsignedTx copy$default(BIP44UnsignedTx bIP44UnsignedTx, Blockchain blockchain, BIP44CoinSelection bIP44CoinSelection, String str, String str2, BigInteger bigInteger, CurrencyCode currencyCode, Network network, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            blockchain = bIP44UnsignedTx.getBlockchain();
        }
        if ((i2 & 2) != 0) {
            bIP44CoinSelection = bIP44UnsignedTx.coinSelection;
        }
        BIP44CoinSelection bIP44CoinSelection2 = bIP44CoinSelection;
        if ((i2 & 4) != 0) {
            str = bIP44UnsignedTx.getFromAddress();
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = bIP44UnsignedTx.getRecipientAddress();
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            bigInteger = bIP44UnsignedTx.getTransferValue();
        }
        BigInteger bigInteger2 = bigInteger;
        if ((i2 & 32) != 0) {
            currencyCode = bIP44UnsignedTx.getCurrencyCode();
        }
        CurrencyCode currencyCode2 = currencyCode;
        if ((i2 & 64) != 0) {
            network = bIP44UnsignedTx.getNetwork();
        }
        return bIP44UnsignedTx.copy(blockchain, bIP44CoinSelection2, str3, str4, bigInteger2, currencyCode2, network);
    }

    public final Blockchain component1() {
        return getBlockchain();
    }

    public final BIP44CoinSelection component2() {
        return this.coinSelection;
    }

    public final String component3() {
        return getFromAddress();
    }

    public final String component4() {
        return getRecipientAddress();
    }

    public final BigInteger component5() {
        return getTransferValue();
    }

    public final CurrencyCode component6() {
        return getCurrencyCode();
    }

    public final Network component7() {
        return getNetwork();
    }

    public final BIP44UnsignedTx copy(Blockchain blockchain, BIP44CoinSelection coinSelection, String fromAddress, String recipientAddress, BigInteger transferValue, CurrencyCode currencyCode, Network network) {
        m.g(blockchain, "blockchain");
        m.g(coinSelection, "coinSelection");
        m.g(fromAddress, "fromAddress");
        m.g(recipientAddress, "recipientAddress");
        m.g(transferValue, "transferValue");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        return new BIP44UnsignedTx(blockchain, coinSelection, fromAddress, recipientAddress, transferValue, currencyCode, network);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BIP44UnsignedTx) {
            BIP44UnsignedTx bIP44UnsignedTx = (BIP44UnsignedTx) obj;
            return m.c(getBlockchain(), bIP44UnsignedTx.getBlockchain()) && m.c(this.coinSelection, bIP44UnsignedTx.coinSelection) && m.c(getFromAddress(), bIP44UnsignedTx.getFromAddress()) && m.c(getRecipientAddress(), bIP44UnsignedTx.getRecipientAddress()) && m.c(getTransferValue(), bIP44UnsignedTx.getTransferValue()) && m.c(getCurrencyCode(), bIP44UnsignedTx.getCurrencyCode()) && m.c(getNetwork(), bIP44UnsignedTx.getNetwork());
        }
        return false;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final BIP44CoinSelection getCoinSelection() {
        return this.coinSelection;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public BigInteger getEstimatedFee() {
        return this.estimatedFee;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public CurrencyCode getFeeCurrencyCode() {
        return this.feeCurrencyCode;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public String getFromAddress() {
        return this.fromAddress;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Map<TxMetadataKey, Object> getMetadata() {
        return this.metadata;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Network getNetwork() {
        return this.network;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public BigInteger getTransferValue() {
        return this.transferValue;
    }

    public int hashCode() {
        return (((((((((((getBlockchain().hashCode() * 31) + this.coinSelection.hashCode()) * 31) + getFromAddress().hashCode()) * 31) + getRecipientAddress().hashCode()) * 31) + getTransferValue().hashCode()) * 31) + getCurrencyCode().hashCode()) * 31) + getNetwork().hashCode();
    }

    public String toString() {
        return "BIP44UnsignedTx(blockchain=" + getBlockchain() + ", coinSelection=" + this.coinSelection + ", fromAddress=" + getFromAddress() + ", recipientAddress=" + getRecipientAddress() + ", transferValue=" + getTransferValue() + ", currencyCode=" + getCurrencyCode() + ", network=" + getNetwork() + ')';
    }
}