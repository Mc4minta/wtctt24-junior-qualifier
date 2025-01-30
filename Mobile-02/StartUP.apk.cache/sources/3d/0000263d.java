package com.coinbase.wallet.stellar.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.stellar.extensions.CurrencyCode_StellarKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: StellarUnsignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jr\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\bR\u001c\u0010\u0014\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b'\u0010\bR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b+\u0010\bR\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b-\u0010\u0004R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020 0.8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001c\u00104\u001a\u0002038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u0019\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u00108\u001a\u0004\b9\u0010\u0010R\u001c\u0010:\u001a\u0002038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u00107R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b<\u0010\u0004R\u001c\u0010>\u001a\u00020=8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/coinbase/wallet/stellar/models/StellarUnsignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "component4", "component5", "component6", "component7", "component8", "Lcom/coinbase/wallet/blockchains/models/Network;", "component9", "()Lcom/coinbase/wallet/blockchains/models/Network;", "fromAddress", SendConfirmationArgs.recipientAddressKey, "transferValue", "estimatedFee", "memoText", "memoId", "memoHash", "memoReturn", "network", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/stellar/models/StellarUnsignedTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getMemoId", "getEstimatedFee", "Ljava/lang/String;", "getMemoHash", "getMemoText", "getTransferValue", "getRecipientAddress", "getMemoReturn", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadata", "()Ljava/util/Map;", SendConfirmationArgs.metadataKey, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "feeCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getFeeCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", AppsFlyerProperties.CURRENCY_CODE, "getCurrencyCode", "getFromAddress", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarUnsignedTx implements UnsignedTx {
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final BigInteger estimatedFee;
    private final CurrencyCode feeCurrencyCode;
    private final String fromAddress;
    private final String memoHash;
    private final BigInteger memoId;
    private final String memoReturn;
    private final String memoText;
    private final Network network;
    private final String recipientAddress;
    private final BigInteger transferValue;

    public StellarUnsignedTx(String fromAddress, String recipientAddress, BigInteger transferValue, BigInteger estimatedFee, String str, BigInteger bigInteger, String str2, String str3, Network network) {
        m.g(fromAddress, "fromAddress");
        m.g(recipientAddress, "recipientAddress");
        m.g(transferValue, "transferValue");
        m.g(estimatedFee, "estimatedFee");
        m.g(network, "network");
        this.fromAddress = fromAddress;
        this.recipientAddress = recipientAddress;
        this.transferValue = transferValue;
        this.estimatedFee = estimatedFee;
        this.memoText = str;
        this.memoId = bigInteger;
        this.memoHash = str2;
        this.memoReturn = str3;
        this.network = network;
        CurrencyCode.Companion companion = CurrencyCode.Companion;
        this.currencyCode = CurrencyCode_StellarKt.getXLM(companion);
        this.feeCurrencyCode = CurrencyCode_StellarKt.getXLM(companion);
        this.blockchain = Blockchain_StellarKt.getSTELLAR(Blockchain.Companion);
    }

    public final String component1() {
        return getFromAddress();
    }

    public final String component2() {
        return getRecipientAddress();
    }

    public final BigInteger component3() {
        return getTransferValue();
    }

    public final BigInteger component4() {
        return getEstimatedFee();
    }

    public final String component5() {
        return this.memoText;
    }

    public final BigInteger component6() {
        return this.memoId;
    }

    public final String component7() {
        return this.memoHash;
    }

    public final String component8() {
        return this.memoReturn;
    }

    public final Network component9() {
        return getNetwork();
    }

    public final StellarUnsignedTx copy(String fromAddress, String recipientAddress, BigInteger transferValue, BigInteger estimatedFee, String str, BigInteger bigInteger, String str2, String str3, Network network) {
        m.g(fromAddress, "fromAddress");
        m.g(recipientAddress, "recipientAddress");
        m.g(transferValue, "transferValue");
        m.g(estimatedFee, "estimatedFee");
        m.g(network, "network");
        return new StellarUnsignedTx(fromAddress, recipientAddress, transferValue, estimatedFee, str, bigInteger, str2, str3, network);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StellarUnsignedTx) {
            StellarUnsignedTx stellarUnsignedTx = (StellarUnsignedTx) obj;
            return m.c(getFromAddress(), stellarUnsignedTx.getFromAddress()) && m.c(getRecipientAddress(), stellarUnsignedTx.getRecipientAddress()) && m.c(getTransferValue(), stellarUnsignedTx.getTransferValue()) && m.c(getEstimatedFee(), stellarUnsignedTx.getEstimatedFee()) && m.c(this.memoText, stellarUnsignedTx.memoText) && m.c(this.memoId, stellarUnsignedTx.memoId) && m.c(this.memoHash, stellarUnsignedTx.memoHash) && m.c(this.memoReturn, stellarUnsignedTx.memoReturn) && m.c(getNetwork(), stellarUnsignedTx.getNetwork());
        }
        return false;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Blockchain getBlockchain() {
        return this.blockchain;
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

    public final String getMemoHash() {
        return this.memoHash;
    }

    public final BigInteger getMemoId() {
        return this.memoId;
    }

    public final String getMemoReturn() {
        return this.memoReturn;
    }

    public final String getMemoText() {
        return this.memoText;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.UnsignedTx
    public Map<TxMetadataKey, Object> getMetadata() {
        Map<TxMetadataKey, Object> i2;
        Map<TxMetadataKey, Object> e2;
        Map<TxMetadataKey, Object> e3;
        Map<TxMetadataKey, Object> e4;
        Map<TxMetadataKey, Object> e5;
        if (this.memoText != null) {
            e5 = l0.e(u.a(TxMetadataKey_StellarKt.getMemoText(TxMetadataKey.Companion), this.memoText));
            return e5;
        } else if (this.memoId != null) {
            e4 = l0.e(u.a(TxMetadataKey_StellarKt.getMemoId(TxMetadataKey.Companion), this.memoId));
            return e4;
        } else if (this.memoReturn != null) {
            e3 = l0.e(u.a(TxMetadataKey_StellarKt.getMemoReturn(TxMetadataKey.Companion), this.memoReturn));
            return e3;
        } else if (this.memoHash != null) {
            e2 = l0.e(u.a(TxMetadataKey_StellarKt.getMemoHash(TxMetadataKey.Companion), this.memoHash));
            return e2;
        } else {
            i2 = m0.i();
            return i2;
        }
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
        int hashCode = ((((((getFromAddress().hashCode() * 31) + getRecipientAddress().hashCode()) * 31) + getTransferValue().hashCode()) * 31) + getEstimatedFee().hashCode()) * 31;
        String str = this.memoText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        BigInteger bigInteger = this.memoId;
        int hashCode3 = (hashCode2 + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31;
        String str2 = this.memoHash;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.memoReturn;
        return ((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + getNetwork().hashCode();
    }

    public String toString() {
        return "StellarUnsignedTx(fromAddress=" + getFromAddress() + ", recipientAddress=" + getRecipientAddress() + ", transferValue=" + getTransferValue() + ", estimatedFee=" + getEstimatedFee() + ", memoText=" + ((Object) this.memoText) + ", memoId=" + this.memoId + ", memoHash=" + ((Object) this.memoHash) + ", memoReturn=" + ((Object) this.memoReturn) + ", network=" + getNetwork() + ')';
    }
}