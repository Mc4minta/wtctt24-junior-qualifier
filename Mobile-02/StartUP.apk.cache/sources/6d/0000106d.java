package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.cipherwebview.models.MoshiKt;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Web3CallResponse.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Object;", "id", "errorMessage", "result", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getResult", "I", "getId", "Ljava/lang/String;", "getErrorMessage", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Web3CallResponse {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<Web3CallResponse> jsonAdapter;
    @Json(name = "errorMessage")
    private final String errorMessage;
    @Json(name = "id")
    private final int id;
    @Json(name = "result")
    private final Object result;

    /* compiled from: Web3CallResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$cipher_webview_release", "()Lcom/squareup/moshi/JsonAdapter;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<Web3CallResponse> getJsonAdapter$cipher_webview_release() {
            return Web3CallResponse.jsonAdapter;
        }
    }

    static {
        Moshi moshi = MoshiKt.getMoshi();
        m.f(moshi, "moshi");
        jsonAdapter = new Web3CallResponseJsonAdapter(moshi).serializeNulls();
    }

    public Web3CallResponse(int i2, String str, Object obj) {
        this.id = i2;
        this.errorMessage = str;
        this.result = obj;
    }

    public static /* synthetic */ Web3CallResponse copy$default(Web3CallResponse web3CallResponse, int i2, String str, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = web3CallResponse.id;
        }
        if ((i3 & 2) != 0) {
            str = web3CallResponse.errorMessage;
        }
        if ((i3 & 4) != 0) {
            obj = web3CallResponse.result;
        }
        return web3CallResponse.copy(i2, str, obj);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final Object component3() {
        return this.result;
    }

    public final Web3CallResponse copy(int i2, String str, Object obj) {
        return new Web3CallResponse(i2, str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Web3CallResponse) {
            Web3CallResponse web3CallResponse = (Web3CallResponse) obj;
            return this.id == web3CallResponse.id && m.c(this.errorMessage, web3CallResponse.errorMessage) && m.c(this.result, web3CallResponse.result);
        }
        return false;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getId() {
        return this.id;
    }

    public final Object getResult() {
        return this.result;
    }

    public int hashCode() {
        int i2 = this.id * 31;
        String str = this.errorMessage;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.result;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "Web3CallResponse(id=" + this.id + ", errorMessage=" + ((Object) this.errorMessage) + ", result=" + this.result + ')';
    }
}