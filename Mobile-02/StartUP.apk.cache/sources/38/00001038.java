package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.ApiConstants;
import com.coinbase.cipherwebview.models.web3.json.EthereumAddressFromSignedMessageCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.cipherwebview.util.String_CipherWebViewKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EthereumAddressFromSignedMessageCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\tJ\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\fR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\"\u0010\fR\u001c\u0010\u0011\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\t¨\u0006("}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/EthereumAddressFromSignedMessageCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "ethereumAddress", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "(Ljava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "", "component2", "()[B", "component3", "", "component4", "()Z", "id", ApiConstants.MESSAGE, "signature", "addPrefix", "copy", "(I[B[BZ)Lcom/coinbase/cipherwebview/models/web3/call/EthereumAddressFromSignedMessageCall;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAddPrefix", "[B", "getSignature", "getMessage", "I", "getId", "<init>", "(I[B[BZ)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumAddressFromSignedMessageCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final boolean addPrefix;
    private final int id;
    private final byte[] message;
    private final byte[] signature;

    /* compiled from: EthereumAddressFromSignedMessageCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/EthereumAddressFromSignedMessageCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/EthereumAddressFromSignedMessageCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/EthereumAddressFromSignedMessageCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EthereumAddressFromSignedMessageCall fromJson$cipher_webview_release(EthereumAddressFromSignedMessageCallJson ethereumAddressFromSignedMessageCallJson) {
            byte[] byteArrayUsingHexEncoding;
            byte[] byteArrayUsingHexEncoding2;
            if (ethereumAddressFromSignedMessageCallJson == null || (byteArrayUsingHexEncoding = String_CipherWebViewKt.toByteArrayUsingHexEncoding(ethereumAddressFromSignedMessageCallJson.getParams().getMessage())) == null || (byteArrayUsingHexEncoding2 = String_CipherWebViewKt.toByteArrayUsingHexEncoding(ethereumAddressFromSignedMessageCallJson.getParams().getSignature())) == null) {
                return null;
            }
            return new EthereumAddressFromSignedMessageCall(ethereumAddressFromSignedMessageCallJson.getId(), byteArrayUsingHexEncoding, byteArrayUsingHexEncoding2, ethereumAddressFromSignedMessageCallJson.getParams().getAddPrefix());
        }
    }

    public EthereumAddressFromSignedMessageCall(int i2, byte[] message, byte[] signature, boolean z) {
        m.g(message, "message");
        m.g(signature, "signature");
        this.id = i2;
        this.message = message;
        this.signature = signature;
        this.addPrefix = z;
    }

    public static /* synthetic */ EthereumAddressFromSignedMessageCall copy$default(EthereumAddressFromSignedMessageCall ethereumAddressFromSignedMessageCall, int i2, byte[] bArr, byte[] bArr2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = ethereumAddressFromSignedMessageCall.getId();
        }
        if ((i3 & 2) != 0) {
            bArr = ethereumAddressFromSignedMessageCall.message;
        }
        if ((i3 & 4) != 0) {
            bArr2 = ethereumAddressFromSignedMessageCall.signature;
        }
        if ((i3 & 8) != 0) {
            z = ethereumAddressFromSignedMessageCall.addPrefix;
        }
        return ethereumAddressFromSignedMessageCall.copy(i2, bArr, bArr2, z);
    }

    public final int component1() {
        return getId();
    }

    public final byte[] component2() {
        return this.message;
    }

    public final byte[] component3() {
        return this.signature;
    }

    public final boolean component4() {
        return this.addPrefix;
    }

    public final EthereumAddressFromSignedMessageCall copy(int i2, byte[] message, byte[] signature, boolean z) {
        m.g(message, "message");
        m.g(signature, "signature");
        return new EthereumAddressFromSignedMessageCall(i2, message, signature, z);
    }

    public final Web3CallResponse createResponse(String ethereumAddress) {
        m.g(ethereumAddress, "ethereumAddress");
        return new Web3CallResponse(getId(), null, ethereumAddress);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumAddressFromSignedMessageCall) {
            EthereumAddressFromSignedMessageCall ethereumAddressFromSignedMessageCall = (EthereumAddressFromSignedMessageCall) obj;
            return getId() == ethereumAddressFromSignedMessageCall.getId() && m.c(this.message, ethereumAddressFromSignedMessageCall.message) && m.c(this.signature, ethereumAddressFromSignedMessageCall.signature) && this.addPrefix == ethereumAddressFromSignedMessageCall.addPrefix;
        }
        return false;
    }

    public final boolean getAddPrefix() {
        return this.addPrefix;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public final byte[] getMessage() {
        return this.message;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int id = ((((getId() * 31) + Arrays.hashCode(this.message)) * 31) + Arrays.hashCode(this.signature)) * 31;
        boolean z = this.addPrefix;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return id + i2;
    }

    public String toString() {
        return "EthereumAddressFromSignedMessageCall(id=" + getId() + ", message=" + Arrays.toString(this.message) + ", signature=" + Arrays.toString(this.signature) + ", addPrefix=" + this.addPrefix + ')';
    }
}