package com.coinbase.wallet.ethereum.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EthereumSignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JBs\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0010\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010'\u001a\u00020\u0014\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020\u001a\u0012\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\nJ\u0096\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00172\b\b\u0002\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010*\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b-\u0010\u0005J\u0010\u0010.\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b.\u0010\nJ\u001a\u00102\u001a\u0002012\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b2\u00103R\u001c\u0010$\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u00104\u001a\u0004\b5\u0010\u0005R\u001c\u0010'\u001a\u00020\u00148\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b'\u00106\u001a\u0004\b7\u0010\u0016R\u001c\u0010)\u001a\u00020\u001a8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b)\u00108\u001a\u0004\b9\u0010\u001cR\u001c\u0010!\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010\nR\u001c\u0010\u001e\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b<\u0010\u0005R\u001c\u0010\"\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b=\u0010\nR\u001c\u0010#\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\b?\u0010\u000eR\u001c\u0010%\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bA\u0010\u0012R\u001e\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00104\u001a\u0004\bB\u0010\u0005R\u001c\u0010*\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010:\u001a\u0004\bC\u0010\nR\u001e\u0010&\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010@\u001a\u0004\bD\u0010\u0012R\u001c\u0010(\u001a\u00020\u00178\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b(\u0010E\u001a\u0004\bF\u0010\u0019R\u001c\u0010\u001f\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00104\u001a\u0004\bG\u0010\u0005¨\u0006K"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "component5", "", "component6", "()[B", "component7", "Ljava/math/BigInteger;", "component8", "()Ljava/math/BigInteger;", "component9", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component10", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component11", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/TxState;", "component12", "()Lcom/coinbase/wallet/blockchains/models/TxState;", "component13", "id", "fromAddress", "toAddress", AdjustableMinerFeeArgs.NONCE, RouteActionKey.RouteActionKeys.CHAIN_ID, "signedTxData", "txHash", "weiValue", "erc20Value", RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, ApiConstants.STATE, "notFoundCount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[BLjava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TxState;I)Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTxHash", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getState", "I", "getNonce", "getId", "getChainId", "[B", "getSignedTxData", "Ljava/math/BigInteger;", "getWeiValue", "getToAddress", "getNotFoundCount", "getErc20Value", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "getFromAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[BLjava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TxState;I)V", "Companion", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumSignedTx implements SignedTx, DatabaseModelObject {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final int chainId;
    private final CurrencyCode currencyCode;
    private final BigInteger erc20Value;
    private final String fromAddress;
    private final String id;
    private final int nonce;
    private final int notFoundCount;
    private final byte[] signedTxData;
    private final TxState state;
    private final String toAddress;
    private final String txHash;
    private final BigInteger weiValue;

    /* compiled from: EthereumSignedTx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx$Companion;", "", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EthereumSignedTx(String id, String fromAddress, String str, int i2, int i3, byte[] signedTxData, String txHash, BigInteger weiValue, BigInteger bigInteger, Blockchain blockchain, CurrencyCode currencyCode, TxState state, int i4) {
        m.g(id, "id");
        m.g(fromAddress, "fromAddress");
        m.g(signedTxData, "signedTxData");
        m.g(txHash, "txHash");
        m.g(weiValue, "weiValue");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(state, "state");
        this.id = id;
        this.fromAddress = fromAddress;
        this.toAddress = str;
        this.nonce = i2;
        this.chainId = i3;
        this.signedTxData = signedTxData;
        this.txHash = txHash;
        this.weiValue = weiValue;
        this.erc20Value = bigInteger;
        this.blockchain = blockchain;
        this.currencyCode = currencyCode;
        this.state = state;
        this.notFoundCount = i4;
    }

    public final String component1() {
        return getId();
    }

    public final Blockchain component10() {
        return getBlockchain();
    }

    public final CurrencyCode component11() {
        return getCurrencyCode();
    }

    public final TxState component12() {
        return getState();
    }

    public final int component13() {
        return this.notFoundCount;
    }

    public final String component2() {
        return this.fromAddress;
    }

    public final String component3() {
        return this.toAddress;
    }

    public final int component4() {
        return this.nonce;
    }

    public final int component5() {
        return this.chainId;
    }

    public final byte[] component6() {
        return this.signedTxData;
    }

    public final String component7() {
        return getTxHash();
    }

    public final BigInteger component8() {
        return this.weiValue;
    }

    public final BigInteger component9() {
        return this.erc20Value;
    }

    public final EthereumSignedTx copy(String id, String fromAddress, String str, int i2, int i3, byte[] signedTxData, String txHash, BigInteger weiValue, BigInteger bigInteger, Blockchain blockchain, CurrencyCode currencyCode, TxState state, int i4) {
        m.g(id, "id");
        m.g(fromAddress, "fromAddress");
        m.g(signedTxData, "signedTxData");
        m.g(txHash, "txHash");
        m.g(weiValue, "weiValue");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(state, "state");
        return new EthereumSignedTx(id, fromAddress, str, i2, i3, signedTxData, txHash, weiValue, bigInteger, blockchain, currencyCode, state, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumSignedTx) {
            EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) obj;
            return m.c(getId(), ethereumSignedTx.getId()) && m.c(this.fromAddress, ethereumSignedTx.fromAddress) && m.c(this.toAddress, ethereumSignedTx.toAddress) && this.nonce == ethereumSignedTx.nonce && this.chainId == ethereumSignedTx.chainId && m.c(this.signedTxData, ethereumSignedTx.signedTxData) && m.c(getTxHash(), ethereumSignedTx.getTxHash()) && m.c(this.weiValue, ethereumSignedTx.weiValue) && m.c(this.erc20Value, ethereumSignedTx.erc20Value) && m.c(getBlockchain(), ethereumSignedTx.getBlockchain()) && m.c(getCurrencyCode(), ethereumSignedTx.getCurrencyCode()) && getState() == ethereumSignedTx.getState() && this.notFoundCount == ethereumSignedTx.notFoundCount;
        }
        return false;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final BigInteger getErc20Value() {
        return this.erc20Value;
    }

    public final String getFromAddress() {
        return this.fromAddress;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final int getNonce() {
        return this.nonce;
    }

    public final int getNotFoundCount() {
        return this.notFoundCount;
    }

    public final byte[] getSignedTxData() {
        return this.signedTxData;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public TxState getState() {
        return this.state;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public String getTxHash() {
        return this.txHash;
    }

    public final BigInteger getWeiValue() {
        return this.weiValue;
    }

    public int hashCode() {
        int hashCode = ((getId().hashCode() * 31) + this.fromAddress.hashCode()) * 31;
        String str = this.toAddress;
        int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.nonce) * 31) + this.chainId) * 31) + Arrays.hashCode(this.signedTxData)) * 31) + getTxHash().hashCode()) * 31) + this.weiValue.hashCode()) * 31;
        BigInteger bigInteger = this.erc20Value;
        return ((((((((hashCode2 + (bigInteger != null ? bigInteger.hashCode() : 0)) * 31) + getBlockchain().hashCode()) * 31) + getCurrencyCode().hashCode()) * 31) + getState().hashCode()) * 31) + this.notFoundCount;
    }

    public String toString() {
        return "EthereumSignedTx(id=" + getId() + ", fromAddress=" + this.fromAddress + ", toAddress=" + ((Object) this.toAddress) + ", nonce=" + this.nonce + ", chainId=" + this.chainId + ", signedTxData=" + Arrays.toString(this.signedTxData) + ", txHash=" + getTxHash() + ", weiValue=" + this.weiValue + ", erc20Value=" + this.erc20Value + ", blockchain=" + getBlockchain() + ", currencyCode=" + getCurrencyCode() + ", state=" + getState() + ", notFoundCount=" + this.notFoundCount + ')';
    }
}