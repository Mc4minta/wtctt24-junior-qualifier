package com.coinbase.wallet.ripple.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.authed.b;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.ripple.extensions.CurrencyCode_RippleKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: XRPSignedTx.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB?\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0005JV\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0005J\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001c\u0010\u0016\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0005R\u001c\u0010\u001b\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010\u0014R\u001c\u0010-\u001a\u00020,8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u0017\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b2\u0010\bR\u001c\u0010\u001a\u001a\u00020\u000f8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\u0011R\u001c\u0010\u001c\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b5\u0010\u0005R\u001c\u0010\u0018\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u0010\u000bR\u001c\u00109\u001a\u0002088\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010\u0019\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010=\u001a\u0004\b>\u0010\u000e¨\u0006B"}, d2 = {"Lcom/coinbase/wallet/ripple/models/XRPSignedTx;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "Lcom/coinbase/wallet/blockchains/models/Network;", "component3", "()Lcom/coinbase/wallet/blockchains/models/Network;", "", "component4", "()J", "Lcom/coinbase/wallet/blockchains/models/TxState;", "component5", "()Lcom/coinbase/wallet/blockchains/models/TxState;", "Ljava/math/BigInteger;", "component6", "()Ljava/math/BigInteger;", "component7", "id", "signedTxData", "network", "maxLedgerVersion", ApiConstants.STATE, "transferValue", "txHash", "copy", "(Ljava/lang/String;[BLcom/coinbase/wallet/blockchains/models/Network;JLcom/coinbase/wallet/blockchains/models/TxState;Ljava/math/BigInteger;Ljava/lang/String;)Lcom/coinbase/wallet/ripple/models/XRPSignedTx;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Ljava/math/BigInteger;", "getTransferValue", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "[B", "getSignedTxData", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getState", "getTxHash", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "J", "getMaxLedgerVersion", "<init>", "(Ljava/lang/String;[BLcom/coinbase/wallet/blockchains/models/Network;JLcom/coinbase/wallet/blockchains/models/TxState;Ljava/math/BigInteger;Ljava/lang/String;)V", "Companion", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPSignedTx implements SignedTx, DatabaseModelObject {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String id;
    private final long maxLedgerVersion;
    private final Network network;
    private final byte[] signedTxData;
    private final TxState state;
    private final BigInteger transferValue;
    private final String txHash;

    /* compiled from: XRPSignedTx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/ripple/models/XRPSignedTx$Companion;", "", "<init>", "()V", "ripple_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XRPSignedTx(String id, byte[] signedTxData, Network network, long j2, TxState state, BigInteger transferValue, String txHash) {
        m.g(id, "id");
        m.g(signedTxData, "signedTxData");
        m.g(network, "network");
        m.g(state, "state");
        m.g(transferValue, "transferValue");
        m.g(txHash, "txHash");
        this.id = id;
        this.signedTxData = signedTxData;
        this.network = network;
        this.maxLedgerVersion = j2;
        this.state = state;
        this.transferValue = transferValue;
        this.txHash = txHash;
        this.blockchain = Blockchain_RippleKt.getXRP(Blockchain.Companion);
        this.currencyCode = CurrencyCode_RippleKt.getXRP(CurrencyCode.Companion);
    }

    public final String component1() {
        return getId();
    }

    public final byte[] component2() {
        return this.signedTxData;
    }

    public final Network component3() {
        return this.network;
    }

    public final long component4() {
        return this.maxLedgerVersion;
    }

    public final TxState component5() {
        return getState();
    }

    public final BigInteger component6() {
        return this.transferValue;
    }

    public final String component7() {
        return getTxHash();
    }

    public final XRPSignedTx copy(String id, byte[] signedTxData, Network network, long j2, TxState state, BigInteger transferValue, String txHash) {
        m.g(id, "id");
        m.g(signedTxData, "signedTxData");
        m.g(network, "network");
        m.g(state, "state");
        m.g(transferValue, "transferValue");
        m.g(txHash, "txHash");
        return new XRPSignedTx(id, signedTxData, network, j2, state, transferValue, txHash);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XRPSignedTx) {
            XRPSignedTx xRPSignedTx = (XRPSignedTx) obj;
            return m.c(getId(), xRPSignedTx.getId()) && m.c(this.signedTxData, xRPSignedTx.signedTxData) && m.c(this.network, xRPSignedTx.network) && this.maxLedgerVersion == xRPSignedTx.maxLedgerVersion && getState() == xRPSignedTx.getState() && m.c(this.transferValue, xRPSignedTx.transferValue) && m.c(getTxHash(), xRPSignedTx.getTxHash());
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

    public final long getMaxLedgerVersion() {
        return this.maxLedgerVersion;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final byte[] getSignedTxData() {
        return this.signedTxData;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public TxState getState() {
        return this.state;
    }

    public final BigInteger getTransferValue() {
        return this.transferValue;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.SignedTx
    public String getTxHash() {
        return this.txHash;
    }

    public int hashCode() {
        return (((((((((((getId().hashCode() * 31) + Arrays.hashCode(this.signedTxData)) * 31) + this.network.hashCode()) * 31) + b.a(this.maxLedgerVersion)) * 31) + getState().hashCode()) * 31) + this.transferValue.hashCode()) * 31) + getTxHash().hashCode();
    }

    public String toString() {
        return "XRPSignedTx(id=" + getId() + ", signedTxData=" + Arrays.toString(this.signedTxData) + ", network=" + this.network + ", maxLedgerVersion=" + this.maxLedgerVersion + ", state=" + getState() + ", transferValue=" + this.transferValue + ", txHash=" + getTxHash() + ')';
    }
}