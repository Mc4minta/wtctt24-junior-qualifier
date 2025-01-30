package com.coinbase.wallet.bip44wallets.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BIP44SignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;BG\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0016¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J`\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b#\u0010\u0005J\u0010\u0010$\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b$\u0010\u0018J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001c\u0010\u001d\u001a\u00020\r8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b+\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u0005R\u001c\u0010\u0019\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b.\u0010\u0005R\u001c\u0010 \u001a\u00020\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\b0\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u00108\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\u0012R\u001c\u0010\u001c\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\fR\u001c\u0010\u001f\u001a\u00020\u00138\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b6\u0010\u0015R\u001c\u0010\u001a\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\b8\u0010\b¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "component3", "Lcom/coinbase/wallet/blockchains/models/Network;", "component4", "()Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component6", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/TxState;", "component7", "()Lcom/coinbase/wallet/blockchains/models/TxState;", "", "component8", "()I", "id", "signedTransactionData", "txHash", "network", AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.BLOCKCHAIN, ApiConstants.STATE, "notFoundCount", "copy", "(Ljava/lang/String;[BLjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/TxState;I)Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedTx;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/lang/String;", "getTxHash", "getId", "I", "getNotFoundCount", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getState", "[B", "getSignedTransactionData", "<init>", "(Ljava/lang/String;[BLjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/TxState;I)V", "Companion", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44SignedTx implements SignedTx, DatabaseModelObject {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String id;
    private final Network network;
    private final int notFoundCount;
    private final byte[] signedTransactionData;
    private final TxState state;
    private final String txHash;

    /* compiled from: BIP44SignedTx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedTx$Companion;", "", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BIP44SignedTx(String id, byte[] signedTransactionData, String txHash, Network network, CurrencyCode currencyCode, Blockchain blockchain, TxState state, int i2) {
        m.g(id, "id");
        m.g(signedTransactionData, "signedTransactionData");
        m.g(txHash, "txHash");
        m.g(network, "network");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        m.g(state, "state");
        this.id = id;
        this.signedTransactionData = signedTransactionData;
        this.txHash = txHash;
        this.network = network;
        this.currencyCode = currencyCode;
        this.blockchain = blockchain;
        this.state = state;
        this.notFoundCount = i2;
    }

    public final String component1() {
        return getId();
    }

    public final byte[] component2() {
        return this.signedTransactionData;
    }

    public final String component3() {
        return getTxHash();
    }

    public final Network component4() {
        return this.network;
    }

    public final CurrencyCode component5() {
        return getCurrencyCode();
    }

    public final Blockchain component6() {
        return getBlockchain();
    }

    public final TxState component7() {
        return getState();
    }

    public final int component8() {
        return this.notFoundCount;
    }

    public final BIP44SignedTx copy(String id, byte[] signedTransactionData, String txHash, Network network, CurrencyCode currencyCode, Blockchain blockchain, TxState state, int i2) {
        m.g(id, "id");
        m.g(signedTransactionData, "signedTransactionData");
        m.g(txHash, "txHash");
        m.g(network, "network");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        m.g(state, "state");
        return new BIP44SignedTx(id, signedTransactionData, txHash, network, currencyCode, blockchain, state, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BIP44SignedTx) {
            BIP44SignedTx bIP44SignedTx = (BIP44SignedTx) obj;
            return m.c(getId(), bIP44SignedTx.getId()) && m.c(this.signedTransactionData, bIP44SignedTx.signedTransactionData) && m.c(getTxHash(), bIP44SignedTx.getTxHash()) && m.c(this.network, bIP44SignedTx.network) && m.c(getCurrencyCode(), bIP44SignedTx.getCurrencyCode()) && m.c(getBlockchain(), bIP44SignedTx.getBlockchain()) && getState() == bIP44SignedTx.getState() && this.notFoundCount == bIP44SignedTx.notFoundCount;
        }
        return false;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final int getNotFoundCount() {
        return this.notFoundCount;
    }

    public final byte[] getSignedTransactionData() {
        return this.signedTransactionData;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public TxState getState() {
        return this.state;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public String getTxHash() {
        return this.txHash;
    }

    public int hashCode() {
        return (((((((((((((getId().hashCode() * 31) + Arrays.hashCode(this.signedTransactionData)) * 31) + getTxHash().hashCode()) * 31) + this.network.hashCode()) * 31) + getCurrencyCode().hashCode()) * 31) + getBlockchain().hashCode()) * 31) + getState().hashCode()) * 31) + this.notFoundCount;
    }

    public String toString() {
        return "BIP44SignedTx(id=" + getId() + ", signedTransactionData=" + Arrays.toString(this.signedTransactionData) + ", txHash=" + getTxHash() + ", network=" + this.network + ", currencyCode=" + getCurrencyCode() + ", blockchain=" + getBlockchain() + ", state=" + getState() + ", notFoundCount=" + this.notFoundCount + ')';
    }
}