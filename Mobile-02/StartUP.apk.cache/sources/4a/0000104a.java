package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: EthereumAddressFromSignedMessageCallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", ApiConstants.MESSAGE, "signature", "addPrefix", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "getSignature", "Z", "getAddPrefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumAddressFromSignedMessageCallParamsJson {
    @Json(name = "addPrefix")
    private final boolean addPrefix;
    @Json(name = ApiConstants.MESSAGE)
    private final String message;
    @Json(name = "signature")
    private final String signature;

    public EthereumAddressFromSignedMessageCallParamsJson(String message, String signature, boolean z) {
        m.g(message, "message");
        m.g(signature, "signature");
        this.message = message;
        this.signature = signature;
        this.addPrefix = z;
    }

    public static /* synthetic */ EthereumAddressFromSignedMessageCallParamsJson copy$default(EthereumAddressFromSignedMessageCallParamsJson ethereumAddressFromSignedMessageCallParamsJson, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ethereumAddressFromSignedMessageCallParamsJson.message;
        }
        if ((i2 & 2) != 0) {
            str2 = ethereumAddressFromSignedMessageCallParamsJson.signature;
        }
        if ((i2 & 4) != 0) {
            z = ethereumAddressFromSignedMessageCallParamsJson.addPrefix;
        }
        return ethereumAddressFromSignedMessageCallParamsJson.copy(str, str2, z);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.signature;
    }

    public final boolean component3() {
        return this.addPrefix;
    }

    public final EthereumAddressFromSignedMessageCallParamsJson copy(String message, String signature, boolean z) {
        m.g(message, "message");
        m.g(signature, "signature");
        return new EthereumAddressFromSignedMessageCallParamsJson(message, signature, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumAddressFromSignedMessageCallParamsJson) {
            EthereumAddressFromSignedMessageCallParamsJson ethereumAddressFromSignedMessageCallParamsJson = (EthereumAddressFromSignedMessageCallParamsJson) obj;
            return m.c(this.message, ethereumAddressFromSignedMessageCallParamsJson.message) && m.c(this.signature, ethereumAddressFromSignedMessageCallParamsJson.signature) && this.addPrefix == ethereumAddressFromSignedMessageCallParamsJson.addPrefix;
        }
        return false;
    }

    public final boolean getAddPrefix() {
        return this.addPrefix;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSignature() {
        return this.signature;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.message.hashCode() * 31) + this.signature.hashCode()) * 31;
        boolean z = this.addPrefix;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "EthereumAddressFromSignedMessageCallParamsJson(message=" + this.message + ", signature=" + this.signature + ", addPrefix=" + this.addPrefix + ')';
    }
}