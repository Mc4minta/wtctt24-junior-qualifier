package com.coinbase.walletengine.models;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CallMessage.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/coinbase/walletengine/models/CallMessage;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "id", "service", "method", "paramsJSON", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletengine/models/CallMessage;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getParamsJSON", "getMethod", "getService", "I", "getId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CallMessage {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<CallMessage> jsonAdapter;
    private static final Moshi moshi;
    @Json(name = "id")
    private final int id;
    @Json(name = "method")
    private final String method;
    @Json(name = "paramsJSON")
    private final String paramsJSON;
    @Json(name = "service")
    private final String service;

    /* compiled from: CallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/models/CallMessage$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/CallMessage;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$wallet_engine_release", "()Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<CallMessage> getJsonAdapter$wallet_engine_release() {
            return CallMessage.jsonAdapter;
        }
    }

    static {
        Moshi build = new Moshi.Builder().build();
        moshi = build;
        jsonAdapter = build.adapter(CallMessage.class).serializeNulls();
    }

    public CallMessage(int i2, String service, String method, String paramsJSON) {
        m.g(service, "service");
        m.g(method, "method");
        m.g(paramsJSON, "paramsJSON");
        this.id = i2;
        this.service = service;
        this.method = method;
        this.paramsJSON = paramsJSON;
    }

    public static /* synthetic */ CallMessage copy$default(CallMessage callMessage, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = callMessage.id;
        }
        if ((i3 & 2) != 0) {
            str = callMessage.service;
        }
        if ((i3 & 4) != 0) {
            str2 = callMessage.method;
        }
        if ((i3 & 8) != 0) {
            str3 = callMessage.paramsJSON;
        }
        return callMessage.copy(i2, str, str2, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.service;
    }

    public final String component3() {
        return this.method;
    }

    public final String component4() {
        return this.paramsJSON;
    }

    public final CallMessage copy(int i2, String service, String method, String paramsJSON) {
        m.g(service, "service");
        m.g(method, "method");
        m.g(paramsJSON, "paramsJSON");
        return new CallMessage(i2, service, method, paramsJSON);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallMessage) {
            CallMessage callMessage = (CallMessage) obj;
            return this.id == callMessage.id && m.c(this.service, callMessage.service) && m.c(this.method, callMessage.method) && m.c(this.paramsJSON, callMessage.paramsJSON);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getParamsJSON() {
        return this.paramsJSON;
    }

    public final String getService() {
        return this.service;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.service.hashCode()) * 31) + this.method.hashCode()) * 31) + this.paramsJSON.hashCode();
    }

    public String toString() {
        return "CallMessage(id=" + this.id + ", service=" + this.service + ", method=" + this.method + ", paramsJSON=" + this.paramsJSON + ')';
    }
}