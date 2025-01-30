package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.cipherwebview.models.MoshiKt;
import com.coinbase.cipherwebview.models.web3.Web3CallMethod;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EthereumAddressFromSignedMessageCallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;", "component3", "()Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;", "id", "method", "params", "copy", "(ILjava/lang/String;Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;)Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMethod", "I", "getId", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;", "getParams", "<init>", "(ILjava/lang/String;Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallParamsJson;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumAddressFromSignedMessageCallJson {
    public static final Companion Companion = new Companion(null);
    private static final EthereumAddressFromSignedMessageCallJsonJsonAdapter jsonAdapter;
    @Json(name = "id")
    private final int id;
    @Json(name = "method")
    private final String method;
    @Json(name = "params")
    private final EthereumAddressFromSignedMessageCallParamsJson params;

    /* compiled from: EthereumAddressFromSignedMessageCallJson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJson$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJsonJsonAdapter;", "jsonAdapter", "Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJsonJsonAdapter;", "getJsonAdapter$cipher_webview_release", "()Lcom/coinbase/cipherwebview/models/web3/json/EthereumAddressFromSignedMessageCallJsonJsonAdapter;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EthereumAddressFromSignedMessageCallJsonJsonAdapter getJsonAdapter$cipher_webview_release() {
            return EthereumAddressFromSignedMessageCallJson.jsonAdapter;
        }
    }

    static {
        Moshi moshi = MoshiKt.getMoshi();
        m.f(moshi, "moshi");
        jsonAdapter = new EthereumAddressFromSignedMessageCallJsonJsonAdapter(moshi);
    }

    public EthereumAddressFromSignedMessageCallJson(int i2, String method, EthereumAddressFromSignedMessageCallParamsJson params) {
        m.g(method, "method");
        m.g(params, "params");
        this.id = i2;
        this.method = method;
        this.params = params;
    }

    public static /* synthetic */ EthereumAddressFromSignedMessageCallJson copy$default(EthereumAddressFromSignedMessageCallJson ethereumAddressFromSignedMessageCallJson, int i2, String str, EthereumAddressFromSignedMessageCallParamsJson ethereumAddressFromSignedMessageCallParamsJson, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = ethereumAddressFromSignedMessageCallJson.id;
        }
        if ((i3 & 2) != 0) {
            str = ethereumAddressFromSignedMessageCallJson.method;
        }
        if ((i3 & 4) != 0) {
            ethereumAddressFromSignedMessageCallParamsJson = ethereumAddressFromSignedMessageCallJson.params;
        }
        return ethereumAddressFromSignedMessageCallJson.copy(i2, str, ethereumAddressFromSignedMessageCallParamsJson);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.method;
    }

    public final EthereumAddressFromSignedMessageCallParamsJson component3() {
        return this.params;
    }

    public final EthereumAddressFromSignedMessageCallJson copy(int i2, String method, EthereumAddressFromSignedMessageCallParamsJson params) {
        m.g(method, "method");
        m.g(params, "params");
        return new EthereumAddressFromSignedMessageCallJson(i2, method, params);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumAddressFromSignedMessageCallJson) {
            EthereumAddressFromSignedMessageCallJson ethereumAddressFromSignedMessageCallJson = (EthereumAddressFromSignedMessageCallJson) obj;
            return this.id == ethereumAddressFromSignedMessageCallJson.id && m.c(this.method, ethereumAddressFromSignedMessageCallJson.method) && m.c(this.params, ethereumAddressFromSignedMessageCallJson.params);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMethod() {
        return this.method;
    }

    public final EthereumAddressFromSignedMessageCallParamsJson getParams() {
        return this.params;
    }

    public int hashCode() {
        return (((this.id * 31) + this.method.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "EthereumAddressFromSignedMessageCallJson(id=" + this.id + ", method=" + this.method + ", params=" + this.params + ')';
    }

    public /* synthetic */ EthereumAddressFromSignedMessageCallJson(int i2, String str, EthereumAddressFromSignedMessageCallParamsJson ethereumAddressFromSignedMessageCallParamsJson, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? Web3CallMethod.EthereumAddressFromSignedMessage.getValue() : str, ethereumAddressFromSignedMessageCallParamsJson);
    }
}