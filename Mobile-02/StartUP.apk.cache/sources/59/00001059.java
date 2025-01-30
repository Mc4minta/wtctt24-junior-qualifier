package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SignEthereumMessageCallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallParamsJson;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", ApiConstants.MESSAGE, "address", "addPrefix", "typedDataJson", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/json/SignEthereumMessageCallParamsJson;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "getAddress", "getTypedDataJson", "Z", "getAddPrefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignEthereumMessageCallParamsJson {
    @Json(name = "addPrefix")
    private final boolean addPrefix;
    @Json(name = "address")
    private final String address;
    @Json(name = ApiConstants.MESSAGE)
    private final String message;
    @Json(name = "typedDataJson")
    private final String typedDataJson;

    public SignEthereumMessageCallParamsJson(String message, String address, boolean z, String str) {
        m.g(message, "message");
        m.g(address, "address");
        this.message = message;
        this.address = address;
        this.addPrefix = z;
        this.typedDataJson = str;
    }

    public static /* synthetic */ SignEthereumMessageCallParamsJson copy$default(SignEthereumMessageCallParamsJson signEthereumMessageCallParamsJson, String str, String str2, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = signEthereumMessageCallParamsJson.message;
        }
        if ((i2 & 2) != 0) {
            str2 = signEthereumMessageCallParamsJson.address;
        }
        if ((i2 & 4) != 0) {
            z = signEthereumMessageCallParamsJson.addPrefix;
        }
        if ((i2 & 8) != 0) {
            str3 = signEthereumMessageCallParamsJson.typedDataJson;
        }
        return signEthereumMessageCallParamsJson.copy(str, str2, z, str3);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.address;
    }

    public final boolean component3() {
        return this.addPrefix;
    }

    public final String component4() {
        return this.typedDataJson;
    }

    public final SignEthereumMessageCallParamsJson copy(String message, String address, boolean z, String str) {
        m.g(message, "message");
        m.g(address, "address");
        return new SignEthereumMessageCallParamsJson(message, address, z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignEthereumMessageCallParamsJson) {
            SignEthereumMessageCallParamsJson signEthereumMessageCallParamsJson = (SignEthereumMessageCallParamsJson) obj;
            return m.c(this.message, signEthereumMessageCallParamsJson.message) && m.c(this.address, signEthereumMessageCallParamsJson.address) && this.addPrefix == signEthereumMessageCallParamsJson.addPrefix && m.c(this.typedDataJson, signEthereumMessageCallParamsJson.typedDataJson);
        }
        return false;
    }

    public final boolean getAddPrefix() {
        return this.addPrefix;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTypedDataJson() {
        return this.typedDataJson;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.message.hashCode() * 31) + this.address.hashCode()) * 31;
        boolean z = this.addPrefix;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        String str = this.typedDataJson;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SignEthereumMessageCallParamsJson(message=" + this.message + ", address=" + this.address + ", addPrefix=" + this.addPrefix + ", typedDataJson=" + ((Object) this.typedDataJson) + ')';
    }
}