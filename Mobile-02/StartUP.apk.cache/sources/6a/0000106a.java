package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.cipherwebview.models.MoshiKt;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Web3CallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/Web3CallJson;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "id", "method", "copy", "(ILjava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallJson;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getMethod", "<init>", "(ILjava/lang/String;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Web3CallJson {
    public static final Companion Companion = new Companion(null);
    private static final Web3CallJsonJsonAdapter jsonAdapter;
    @Json(name = "id")
    private final int id;
    @Json(name = "method")
    private final String method;

    /* compiled from: Web3CallJson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/Web3CallJson$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallJsonJsonAdapter;", "jsonAdapter", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallJsonJsonAdapter;", "getJsonAdapter$cipher_webview_release", "()Lcom/coinbase/cipherwebview/models/web3/json/Web3CallJsonJsonAdapter;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Web3CallJsonJsonAdapter getJsonAdapter$cipher_webview_release() {
            return Web3CallJson.jsonAdapter;
        }
    }

    static {
        Moshi moshi = MoshiKt.getMoshi();
        m.f(moshi, "moshi");
        jsonAdapter = new Web3CallJsonJsonAdapter(moshi);
    }

    public Web3CallJson(int i2, String method) {
        m.g(method, "method");
        this.id = i2;
        this.method = method;
    }

    public static /* synthetic */ Web3CallJson copy$default(Web3CallJson web3CallJson, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = web3CallJson.id;
        }
        if ((i3 & 2) != 0) {
            str = web3CallJson.method;
        }
        return web3CallJson.copy(i2, str);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.method;
    }

    public final Web3CallJson copy(int i2, String method) {
        m.g(method, "method");
        return new Web3CallJson(i2, method);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Web3CallJson) {
            Web3CallJson web3CallJson = (Web3CallJson) obj;
            return this.id == web3CallJson.id && m.c(this.method, web3CallJson.method);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMethod() {
        return this.method;
    }

    public int hashCode() {
        return (this.id * 31) + this.method.hashCode();
    }

    public String toString() {
        return "Web3CallJson(id=" + this.id + ", method=" + this.method + ')';
    }
}