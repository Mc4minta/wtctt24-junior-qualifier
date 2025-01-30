package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.cipherwebview.util.ByteArray_CipherWebViewKt;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SignEthereumTransactionCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0086\b\u0018\u0000 F2\u00020\u0001:\u0001FBs\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010!\u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\u001b¢\u0006\u0004\bD\u0010EJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0011J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0011J\u0010\u0010\u001a\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0094\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\u001bHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b,\u0010\rJ\u0010\u0010-\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b-\u0010\nJ\u001a\u00100\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b0\u00101R\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b3\u0010\u0011R\u001b\u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u0010\u0015R\u001b\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u00102\u001a\u0004\b6\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\nR\u0019\u0010!\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b9\u0010\u0011R\u0019\u0010)\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b;\u0010\u001dR\u001b\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\rR\u0019\u0010(\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b>\u0010\nR\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00102\u001a\u0004\b?\u0010\u0011R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010\u0013R\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\bB\u0010\rR\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00102\u001a\u0004\bC\u0010\u0011¨\u0006G"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumTransactionCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "signedTransaction", "transactionHash", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "([B[B)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "component5", "()[B", "component6", "()Ljava/lang/Integer;", "component7", "component8", "component9", "component10", "component11", "", "component12", "()Z", "id", "fromAddress", "toAddress", "weiValue", "data", AdjustableMinerFeeArgs.NONCE, "gasPriceInWei", "maxFeePerGas", "maxPriorityFeePerGas", "gasLimit", RouteActionKey.RouteActionKeys.CHAIN_ID, "shouldSubmit", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;IZ)Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumTransactionCall;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigInteger;", "getGasPriceInWei", "Ljava/lang/Integer;", "getNonce", "getGasLimit", "I", "getId", "getWeiValue", "Z", "getShouldSubmit", "Ljava/lang/String;", "getToAddress", "getChainId", "getMaxPriorityFeePerGas", "[B", "getData", "getFromAddress", "getMaxFeePerGas", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;[BLjava/lang/Integer;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;IZ)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignEthereumTransactionCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final int chainId;
    private final byte[] data;
    private final String fromAddress;
    private final BigInteger gasLimit;
    private final BigInteger gasPriceInWei;
    private final int id;
    private final BigInteger maxFeePerGas;
    private final BigInteger maxPriorityFeePerGas;
    private final Integer nonce;
    private final boolean shouldSubmit;
    private final String toAddress;
    private final BigInteger weiValue;

    /* compiled from: SignEthereumTransactionCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumTransactionCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumTransactionCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumTransactionCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumTransactionCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/SignEthereumTransactionCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0004, code lost:
            r6 = kotlin.l0.v.k(r16.getParams().getWeiValue());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall fromJson$cipher_webview_release(com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallJson r16) {
            /*
                r15 = this;
                r0 = 0
                if (r16 != 0) goto L4
                return r0
            L4:
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r1 = r1.getWeiValue()
                java.math.BigInteger r6 = kotlin.l0.o.k(r1)
                if (r6 != 0) goto L13
                return r0
            L13:
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r1 = r1.getData()
                byte[] r7 = com.coinbase.cipherwebview.util.String_CipherWebViewKt.toByteArrayUsingHexEncoding(r1)
                if (r7 != 0) goto L22
                return r0
            L22:
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r1 = r1.getGasPriceInWei()
                if (r1 != 0) goto L2e
                r9 = r0
                goto L33
            L2e:
                java.math.BigInteger r1 = kotlin.l0.o.k(r1)
                r9 = r1
            L33:
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r1 = r1.getMaxFeePerGas()
                if (r1 != 0) goto L3f
                r10 = r0
                goto L44
            L3f:
                java.math.BigInteger r1 = kotlin.l0.o.k(r1)
                r10 = r1
            L44:
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r1 = r1.getMaxPriorityFeePerGas()
                if (r1 != 0) goto L50
                r11 = r0
                goto L55
            L50:
                java.math.BigInteger r1 = kotlin.l0.o.k(r1)
                r11 = r1
            L55:
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r1 = r1.getGasLimit()
                if (r1 != 0) goto L60
                goto L64
            L60:
                java.math.BigInteger r0 = kotlin.l0.o.k(r1)
            L64:
                r12 = r0
                com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall r0 = new com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall
                int r3 = r16.getId()
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r4 = r1.getFromAddress()
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.String r5 = r1.getToAddress()
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                java.lang.Integer r8 = r1.getNonce()
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                int r13 = r1.getChainId()
                com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallParamsJson r1 = r16.getParams()
                boolean r14 = r1.getShouldSubmit()
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall.Companion.fromJson$cipher_webview_release(com.coinbase.cipherwebview.models.web3.json.SignEthereumTransactionCallJson):com.coinbase.cipherwebview.models.web3.call.SignEthereumTransactionCall");
        }
    }

    public SignEthereumTransactionCall(int i2, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i3, boolean z) {
        m.g(fromAddress, "fromAddress");
        m.g(weiValue, "weiValue");
        m.g(data, "data");
        this.id = i2;
        this.fromAddress = fromAddress;
        this.toAddress = str;
        this.weiValue = weiValue;
        this.data = data;
        this.nonce = num;
        this.gasPriceInWei = bigInteger;
        this.maxFeePerGas = bigInteger2;
        this.maxPriorityFeePerGas = bigInteger3;
        this.gasLimit = bigInteger4;
        this.chainId = i3;
        this.shouldSubmit = z;
    }

    public final int component1() {
        return getId();
    }

    public final BigInteger component10() {
        return this.gasLimit;
    }

    public final int component11() {
        return this.chainId;
    }

    public final boolean component12() {
        return this.shouldSubmit;
    }

    public final String component2() {
        return this.fromAddress;
    }

    public final String component3() {
        return this.toAddress;
    }

    public final BigInteger component4() {
        return this.weiValue;
    }

    public final byte[] component5() {
        return this.data;
    }

    public final Integer component6() {
        return this.nonce;
    }

    public final BigInteger component7() {
        return this.gasPriceInWei;
    }

    public final BigInteger component8() {
        return this.maxFeePerGas;
    }

    public final BigInteger component9() {
        return this.maxPriorityFeePerGas;
    }

    public final SignEthereumTransactionCall copy(int i2, String fromAddress, String str, BigInteger weiValue, byte[] data, Integer num, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i3, boolean z) {
        m.g(fromAddress, "fromAddress");
        m.g(weiValue, "weiValue");
        m.g(data, "data");
        return new SignEthereumTransactionCall(i2, fromAddress, str, weiValue, data, num, bigInteger, bigInteger2, bigInteger3, bigInteger4, i3, z);
    }

    public final Web3CallResponse createResponse(byte[] signedTransaction, byte[] transactionHash) {
        m.g(signedTransaction, "signedTransaction");
        m.g(transactionHash, "transactionHash");
        if (this.shouldSubmit) {
            signedTransaction = transactionHash;
        }
        return new Web3CallResponse(getId(), null, ByteArray_CipherWebViewKt.toHexEncodedString(signedTransaction, true));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignEthereumTransactionCall) {
            SignEthereumTransactionCall signEthereumTransactionCall = (SignEthereumTransactionCall) obj;
            return getId() == signEthereumTransactionCall.getId() && m.c(this.fromAddress, signEthereumTransactionCall.fromAddress) && m.c(this.toAddress, signEthereumTransactionCall.toAddress) && m.c(this.weiValue, signEthereumTransactionCall.weiValue) && m.c(this.data, signEthereumTransactionCall.data) && m.c(this.nonce, signEthereumTransactionCall.nonce) && m.c(this.gasPriceInWei, signEthereumTransactionCall.gasPriceInWei) && m.c(this.maxFeePerGas, signEthereumTransactionCall.maxFeePerGas) && m.c(this.maxPriorityFeePerGas, signEthereumTransactionCall.maxPriorityFeePerGas) && m.c(this.gasLimit, signEthereumTransactionCall.gasLimit) && this.chainId == signEthereumTransactionCall.chainId && this.shouldSubmit == signEthereumTransactionCall.shouldSubmit;
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getFromAddress() {
        return this.fromAddress;
    }

    public final BigInteger getGasLimit() {
        return this.gasLimit;
    }

    public final BigInteger getGasPriceInWei() {
        return this.gasPriceInWei;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public final BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final BigInteger getMaxPriorityFeePerGas() {
        return this.maxPriorityFeePerGas;
    }

    public final Integer getNonce() {
        return this.nonce;
    }

    public final boolean getShouldSubmit() {
        return this.shouldSubmit;
    }

    public final String getToAddress() {
        return this.toAddress;
    }

    public final BigInteger getWeiValue() {
        return this.weiValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int id = ((getId() * 31) + this.fromAddress.hashCode()) * 31;
        String str = this.toAddress;
        int hashCode = (((((id + (str == null ? 0 : str.hashCode())) * 31) + this.weiValue.hashCode()) * 31) + Arrays.hashCode(this.data)) * 31;
        Integer num = this.nonce;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        BigInteger bigInteger = this.gasPriceInWei;
        int hashCode3 = (hashCode2 + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31;
        BigInteger bigInteger2 = this.maxFeePerGas;
        int hashCode4 = (hashCode3 + (bigInteger2 == null ? 0 : bigInteger2.hashCode())) * 31;
        BigInteger bigInteger3 = this.maxPriorityFeePerGas;
        int hashCode5 = (hashCode4 + (bigInteger3 == null ? 0 : bigInteger3.hashCode())) * 31;
        BigInteger bigInteger4 = this.gasLimit;
        int hashCode6 = (((hashCode5 + (bigInteger4 != null ? bigInteger4.hashCode() : 0)) * 31) + this.chainId) * 31;
        boolean z = this.shouldSubmit;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode6 + i2;
    }

    public String toString() {
        return "SignEthereumTransactionCall(id=" + getId() + ", fromAddress=" + this.fromAddress + ", toAddress=" + ((Object) this.toAddress) + ", weiValue=" + this.weiValue + ", data=" + Arrays.toString(this.data) + ", nonce=" + this.nonce + ", gasPriceInWei=" + this.gasPriceInWei + ", maxFeePerGas=" + this.maxFeePerGas + ", maxPriorityFeePerGas=" + this.maxPriorityFeePerGas + ", gasLimit=" + this.gasLimit + ", chainId=" + this.chainId + ", shouldSubmit=" + this.shouldSubmit + ')';
    }
}