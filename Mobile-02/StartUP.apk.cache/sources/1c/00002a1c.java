package com.coinbase.walletengine.models;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ResponseMessage.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/walletengine/models/ResponseMessage;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "id", "valueJSON", "error", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletengine/models/ResponseMessage;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getError", "I", "getId", "getValueJSON", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ResponseMessage {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<ResponseMessage> jsonAdapter;
    private static final Moshi moshi;
    @Json(name = "error")
    private final String error;
    @Json(name = "id")
    private final int id;
    @Json(name = "valueJSON")
    private final String valueJSON;

    /* compiled from: ResponseMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/models/ResponseMessage$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/ResponseMessage;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$wallet_engine_release", "()Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<ResponseMessage> getJsonAdapter$wallet_engine_release() {
            return ResponseMessage.jsonAdapter;
        }
    }

    static {
        Moshi build = new Moshi.Builder().build();
        moshi = build;
        jsonAdapter = build.adapter(ResponseMessage.class).serializeNulls();
    }

    public ResponseMessage(int i2, String valueJSON, String str) {
        m.g(valueJSON, "valueJSON");
        this.id = i2;
        this.valueJSON = valueJSON;
        this.error = str;
    }

    public static /* synthetic */ ResponseMessage copy$default(ResponseMessage responseMessage, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = responseMessage.id;
        }
        if ((i3 & 2) != 0) {
            str = responseMessage.valueJSON;
        }
        if ((i3 & 4) != 0) {
            str2 = responseMessage.error;
        }
        return responseMessage.copy(i2, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.valueJSON;
    }

    public final String component3() {
        return this.error;
    }

    public final ResponseMessage copy(int i2, String valueJSON, String str) {
        m.g(valueJSON, "valueJSON");
        return new ResponseMessage(i2, valueJSON, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResponseMessage) {
            ResponseMessage responseMessage = (ResponseMessage) obj;
            return this.id == responseMessage.id && m.c(this.valueJSON, responseMessage.valueJSON) && m.c(this.error, responseMessage.error);
        }
        return false;
    }

    public final String getError() {
        return this.error;
    }

    public final int getId() {
        return this.id;
    }

    public final String getValueJSON() {
        return this.valueJSON;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.valueJSON.hashCode()) * 31;
        String str = this.error;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ResponseMessage(id=" + this.id + ", valueJSON=" + this.valueJSON + ", error=" + ((Object) this.error) + ')';
    }
}