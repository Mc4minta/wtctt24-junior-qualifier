package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.cipherwebview.models.web3.json.SubmitEthereumTransactionCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.cipherwebview.util.ByteArray_CipherWebViewKt;
import com.coinbase.cipherwebview.util.String_CipherWebViewKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SubmitEthereumTransactionCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\tJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\tR\u001c\u0010\r\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001f\u0010\t¨\u0006#"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SubmitEthereumTransactionCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "transactionHash", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "([B)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "component2", "()[B", "component3", "id", "signedTransaction", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(I[BI)Lcom/coinbase/cipherwebview/models/web3/call/SubmitEthereumTransactionCall;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getSignedTransaction", "I", "getChainId", "getId", "<init>", "(I[BI)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SubmitEthereumTransactionCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final int chainId;
    private final int id;
    private final byte[] signedTransaction;

    /* compiled from: SubmitEthereumTransactionCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SubmitEthereumTransactionCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/SubmitEthereumTransactionCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/SubmitEthereumTransactionCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/SubmitEthereumTransactionCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/SubmitEthereumTransactionCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubmitEthereumTransactionCall fromJson$cipher_webview_release(SubmitEthereumTransactionCallJson submitEthereumTransactionCallJson) {
            byte[] byteArrayUsingHexEncoding;
            if (submitEthereumTransactionCallJson == null || (byteArrayUsingHexEncoding = String_CipherWebViewKt.toByteArrayUsingHexEncoding(submitEthereumTransactionCallJson.getParams().getSignedTransaction())) == null) {
                return null;
            }
            return new SubmitEthereumTransactionCall(submitEthereumTransactionCallJson.getId(), byteArrayUsingHexEncoding, submitEthereumTransactionCallJson.getParams().getChainId());
        }
    }

    public SubmitEthereumTransactionCall(int i2, byte[] signedTransaction, int i3) {
        m.g(signedTransaction, "signedTransaction");
        this.id = i2;
        this.signedTransaction = signedTransaction;
        this.chainId = i3;
    }

    public static /* synthetic */ SubmitEthereumTransactionCall copy$default(SubmitEthereumTransactionCall submitEthereumTransactionCall, int i2, byte[] bArr, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = submitEthereumTransactionCall.getId();
        }
        if ((i4 & 2) != 0) {
            bArr = submitEthereumTransactionCall.signedTransaction;
        }
        if ((i4 & 4) != 0) {
            i3 = submitEthereumTransactionCall.chainId;
        }
        return submitEthereumTransactionCall.copy(i2, bArr, i3);
    }

    public final int component1() {
        return getId();
    }

    public final byte[] component2() {
        return this.signedTransaction;
    }

    public final int component3() {
        return this.chainId;
    }

    public final SubmitEthereumTransactionCall copy(int i2, byte[] signedTransaction, int i3) {
        m.g(signedTransaction, "signedTransaction");
        return new SubmitEthereumTransactionCall(i2, signedTransaction, i3);
    }

    public final Web3CallResponse createResponse(byte[] transactionHash) {
        m.g(transactionHash, "transactionHash");
        return new Web3CallResponse(getId(), null, ByteArray_CipherWebViewKt.toHexEncodedString(transactionHash, true));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubmitEthereumTransactionCall) {
            SubmitEthereumTransactionCall submitEthereumTransactionCall = (SubmitEthereumTransactionCall) obj;
            return getId() == submitEthereumTransactionCall.getId() && m.c(this.signedTransaction, submitEthereumTransactionCall.signedTransaction) && this.chainId == submitEthereumTransactionCall.chainId;
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public final byte[] getSignedTransaction() {
        return this.signedTransaction;
    }

    public int hashCode() {
        return (((getId() * 31) + Arrays.hashCode(this.signedTransaction)) * 31) + this.chainId;
    }

    public String toString() {
        return "SubmitEthereumTransactionCall(id=" + getId() + ", signedTransaction=" + Arrays.toString(this.signedTransaction) + ", chainId=" + this.chainId + ')';
    }
}