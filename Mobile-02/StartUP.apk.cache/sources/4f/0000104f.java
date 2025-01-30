package com.coinbase.cipherwebview.models.web3.json;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: MakeEthereumJSONRPCRequestCallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallParamsJson;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "", "component3", "()I", "rpcMethod", "rpcParams", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Ljava/lang/String;Ljava/util/List;I)Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallParamsJson;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRpcParams", "Ljava/lang/String;", "getRpcMethod", "I", "getChainId", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MakeEthereumJSONRPCRequestCallParamsJson {
    @Json(name = RouteActionKey.RouteActionKeys.CHAIN_ID)
    private final int chainId;
    @Json(name = "rpcMethod")
    private final String rpcMethod;
    @Json(name = "rpcParams")
    private final List<Object> rpcParams;

    public MakeEthereumJSONRPCRequestCallParamsJson(String rpcMethod, List<? extends Object> rpcParams, int i2) {
        m.g(rpcMethod, "rpcMethod");
        m.g(rpcParams, "rpcParams");
        this.rpcMethod = rpcMethod;
        this.rpcParams = rpcParams;
        this.chainId = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MakeEthereumJSONRPCRequestCallParamsJson copy$default(MakeEthereumJSONRPCRequestCallParamsJson makeEthereumJSONRPCRequestCallParamsJson, String str, List list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = makeEthereumJSONRPCRequestCallParamsJson.rpcMethod;
        }
        if ((i3 & 2) != 0) {
            list = makeEthereumJSONRPCRequestCallParamsJson.rpcParams;
        }
        if ((i3 & 4) != 0) {
            i2 = makeEthereumJSONRPCRequestCallParamsJson.chainId;
        }
        return makeEthereumJSONRPCRequestCallParamsJson.copy(str, list, i2);
    }

    public final String component1() {
        return this.rpcMethod;
    }

    public final List<Object> component2() {
        return this.rpcParams;
    }

    public final int component3() {
        return this.chainId;
    }

    public final MakeEthereumJSONRPCRequestCallParamsJson copy(String rpcMethod, List<? extends Object> rpcParams, int i2) {
        m.g(rpcMethod, "rpcMethod");
        m.g(rpcParams, "rpcParams");
        return new MakeEthereumJSONRPCRequestCallParamsJson(rpcMethod, rpcParams, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MakeEthereumJSONRPCRequestCallParamsJson) {
            MakeEthereumJSONRPCRequestCallParamsJson makeEthereumJSONRPCRequestCallParamsJson = (MakeEthereumJSONRPCRequestCallParamsJson) obj;
            return m.c(this.rpcMethod, makeEthereumJSONRPCRequestCallParamsJson.rpcMethod) && m.c(this.rpcParams, makeEthereumJSONRPCRequestCallParamsJson.rpcParams) && this.chainId == makeEthereumJSONRPCRequestCallParamsJson.chainId;
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getRpcMethod() {
        return this.rpcMethod;
    }

    public final List<Object> getRpcParams() {
        return this.rpcParams;
    }

    public int hashCode() {
        return (((this.rpcMethod.hashCode() * 31) + this.rpcParams.hashCode()) * 31) + this.chainId;
    }

    public String toString() {
        return "MakeEthereumJSONRPCRequestCallParamsJson(rpcMethod=" + this.rpcMethod + ", rpcParams=" + this.rpcParams + ", chainId=" + this.chainId + ')';
    }
}