package com.coinbase.wallet.stellar.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.authed.b;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.stellar.extensions.CurrencyCode_StellarKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StellarSignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B7\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JL\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0018\u001a\u00020\u00108\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u0012R\u001c\u0010'\u001a\u00020&8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010\u0005R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b-\u0010\u0005R\u001c\u0010\u0016\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u0010\fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00102\u001a\u0004\b3\u0010\bR\u001c\u00105\u001a\u0002048\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/stellar/models/StellarSignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "component3", "Lcom/coinbase/wallet/blockchains/models/Network;", "component4", "()Lcom/coinbase/wallet/blockchains/models/Network;", "", "component5", "()J", "Lcom/coinbase/wallet/blockchains/models/TxState;", "component6", "()Lcom/coinbase/wallet/blockchains/models/TxState;", "id", "signedTransactionData", "txHash", "network", "validBefore", ApiConstants.STATE, "copy", "(Ljava/lang/String;[BLjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;JLcom/coinbase/wallet/blockchains/models/TxState;)Lcom/coinbase/wallet/stellar/models/StellarSignedTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getState", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Ljava/lang/String;", "getId", "getTxHash", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "J", "getValidBefore", "[B", "getSignedTransactionData", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "<init>", "(Ljava/lang/String;[BLjava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;JLcom/coinbase/wallet/blockchains/models/TxState;)V", "Companion", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarSignedTx implements SignedTx, DatabaseModelObject {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String id;
    private final Network network;
    private final byte[] signedTransactionData;
    private final TxState state;
    private final String txHash;
    private final long validBefore;

    /* compiled from: StellarSignedTx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/stellar/models/StellarSignedTx$Companion;", "", "<init>", "()V", "stellar_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StellarSignedTx(String id, byte[] signedTransactionData, String txHash, Network network, long j2, TxState state) {
        m.g(id, "id");
        m.g(signedTransactionData, "signedTransactionData");
        m.g(txHash, "txHash");
        m.g(network, "network");
        m.g(state, "state");
        this.id = id;
        this.signedTransactionData = signedTransactionData;
        this.txHash = txHash;
        this.network = network;
        this.validBefore = j2;
        this.state = state;
        this.blockchain = Blockchain_StellarKt.getSTELLAR(Blockchain.Companion);
        this.currencyCode = CurrencyCode_StellarKt.getXLM(CurrencyCode.Companion);
    }

    public static /* synthetic */ StellarSignedTx copy$default(StellarSignedTx stellarSignedTx, String str, byte[] bArr, String str2, Network network, long j2, TxState txState, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stellarSignedTx.getId();
        }
        if ((i2 & 2) != 0) {
            bArr = stellarSignedTx.signedTransactionData;
        }
        byte[] bArr2 = bArr;
        if ((i2 & 4) != 0) {
            str2 = stellarSignedTx.getTxHash();
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            network = stellarSignedTx.network;
        }
        Network network2 = network;
        if ((i2 & 16) != 0) {
            j2 = stellarSignedTx.validBefore;
        }
        long j3 = j2;
        if ((i2 & 32) != 0) {
            txState = stellarSignedTx.getState();
        }
        return stellarSignedTx.copy(str, bArr2, str3, network2, j3, txState);
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

    public final long component5() {
        return this.validBefore;
    }

    public final TxState component6() {
        return getState();
    }

    public final StellarSignedTx copy(String id, byte[] signedTransactionData, String txHash, Network network, long j2, TxState state) {
        m.g(id, "id");
        m.g(signedTransactionData, "signedTransactionData");
        m.g(txHash, "txHash");
        m.g(network, "network");
        m.g(state, "state");
        return new StellarSignedTx(id, signedTransactionData, txHash, network, j2, state);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StellarSignedTx) {
            StellarSignedTx stellarSignedTx = (StellarSignedTx) obj;
            return m.c(getId(), stellarSignedTx.getId()) && m.c(this.signedTransactionData, stellarSignedTx.signedTransactionData) && m.c(getTxHash(), stellarSignedTx.getTxHash()) && m.c(this.network, stellarSignedTx.network) && this.validBefore == stellarSignedTx.validBefore && getState() == stellarSignedTx.getState();
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

    public final long getValidBefore() {
        return this.validBefore;
    }

    public int hashCode() {
        return (((((((((getId().hashCode() * 31) + Arrays.hashCode(this.signedTransactionData)) * 31) + getTxHash().hashCode()) * 31) + this.network.hashCode()) * 31) + b.a(this.validBefore)) * 31) + getState().hashCode();
    }

    public String toString() {
        return "StellarSignedTx(id=" + getId() + ", signedTransactionData=" + Arrays.toString(this.signedTransactionData) + ", txHash=" + getTxHash() + ", network=" + this.network + ", validBefore=" + this.validBefore + ", state=" + getState() + ')';
    }
}