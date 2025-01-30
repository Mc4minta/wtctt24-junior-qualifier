package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.ApiConstants;
import com.coinbase.cipherwebview.models.web3.json.SignEthereumMessageCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.cipherwebview.util.ByteArray_CipherWebViewKt;
import com.coinbase.cipherwebview.util.String_CipherWebViewKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SignEthereumMessageCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B1\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJD\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\tJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\u0011R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\u000bR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b&\u0010\u000eR\u001c\u0010\u0013\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\t¨\u0006,"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumMessageCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "signature", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "([B)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "component2", "()[B", "", "component3", "()Ljava/lang/String;", "", "component4", "()Z", "component5", "id", ApiConstants.MESSAGE, "address", "addPrefix", "typedDataJson", "copy", "(I[BLjava/lang/String;ZLjava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumMessageCall;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAddPrefix", "Ljava/lang/String;", "getTypedDataJson", "[B", "getMessage", "getAddress", "I", "getId", "<init>", "(I[BLjava/lang/String;ZLjava/lang/String;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignEthereumMessageCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final boolean addPrefix;
    private final String address;
    private final int id;
    private final byte[] message;
    private final String typedDataJson;

    /* compiled from: SignEthereumMessageCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumMessageCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumMessageCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumMessageCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignEthereumMessageCall fromJson$cipher_webview_release(SignEthereumMessageCallJson signEthereumMessageCallJson) {
            byte[] byteArrayUsingHexEncoding;
            if (signEthereumMessageCallJson == null || (byteArrayUsingHexEncoding = String_CipherWebViewKt.toByteArrayUsingHexEncoding(signEthereumMessageCallJson.getParams().getMessage())) == null) {
                return null;
            }
            return new SignEthereumMessageCall(signEthereumMessageCallJson.getId(), byteArrayUsingHexEncoding, signEthereumMessageCallJson.getParams().getAddress(), signEthereumMessageCallJson.getParams().getAddPrefix(), signEthereumMessageCallJson.getParams().getTypedDataJson());
        }
    }

    public SignEthereumMessageCall(int i2, byte[] message, String address, boolean z, String str) {
        m.g(message, "message");
        m.g(address, "address");
        this.id = i2;
        this.message = message;
        this.address = address;
        this.addPrefix = z;
        this.typedDataJson = str;
    }

    public static /* synthetic */ SignEthereumMessageCall copy$default(SignEthereumMessageCall signEthereumMessageCall, int i2, byte[] bArr, String str, boolean z, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = signEthereumMessageCall.getId();
        }
        if ((i3 & 2) != 0) {
            bArr = signEthereumMessageCall.message;
        }
        byte[] bArr2 = bArr;
        if ((i3 & 4) != 0) {
            str = signEthereumMessageCall.address;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            z = signEthereumMessageCall.addPrefix;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            str2 = signEthereumMessageCall.typedDataJson;
        }
        return signEthereumMessageCall.copy(i2, bArr2, str3, z2, str2);
    }

    public final int component1() {
        return getId();
    }

    public final byte[] component2() {
        return this.message;
    }

    public final String component3() {
        return this.address;
    }

    public final boolean component4() {
        return this.addPrefix;
    }

    public final String component5() {
        return this.typedDataJson;
    }

    public final SignEthereumMessageCall copy(int i2, byte[] message, String address, boolean z, String str) {
        m.g(message, "message");
        m.g(address, "address");
        return new SignEthereumMessageCall(i2, message, address, z, str);
    }

    public final Web3CallResponse createResponse(byte[] signature) {
        m.g(signature, "signature");
        return new Web3CallResponse(getId(), null, ByteArray_CipherWebViewKt.toHexEncodedString(signature, true));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignEthereumMessageCall) {
            SignEthereumMessageCall signEthereumMessageCall = (SignEthereumMessageCall) obj;
            return getId() == signEthereumMessageCall.getId() && m.c(this.message, signEthereumMessageCall.message) && m.c(this.address, signEthereumMessageCall.address) && this.addPrefix == signEthereumMessageCall.addPrefix && m.c(this.typedDataJson, signEthereumMessageCall.typedDataJson);
        }
        return false;
    }

    public final boolean getAddPrefix() {
        return this.addPrefix;
    }

    public final String getAddress() {
        return this.address;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public final byte[] getMessage() {
        return this.message;
    }

    public final String getTypedDataJson() {
        return this.typedDataJson;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int id = ((((getId() * 31) + Arrays.hashCode(this.message)) * 31) + this.address.hashCode()) * 31;
        boolean z = this.addPrefix;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (id + i2) * 31;
        String str = this.typedDataJson;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SignEthereumMessageCall(id=" + getId() + ", message=" + Arrays.toString(this.message) + ", address=" + this.address + ", addPrefix=" + this.addPrefix + ", typedDataJson=" + ((Object) this.typedDataJson) + ')';
    }
}