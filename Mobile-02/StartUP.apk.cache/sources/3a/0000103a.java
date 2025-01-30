package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.cipherwebview.models.web3.json.MakeEthereumJSONRPCRequestCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: MakeEthereumJSONRPCRequestCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\rHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\tJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\tR!\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\f¨\u0006$"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/MakeEthereumJSONRPCRequestCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "result", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "(Ljava/lang/Object;)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/List;", "id", "rpcMethod", "rpcParams", "copy", "(ILjava/lang/String;Ljava/util/List;)Lcom/coinbase/cipherwebview/models/web3/call/MakeEthereumJSONRPCRequestCall;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/util/List;", "getRpcParams", "Ljava/lang/String;", "getRpcMethod", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MakeEthereumJSONRPCRequestCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final int id;
    private final String rpcMethod;
    private final List<Object> rpcParams;

    /* compiled from: MakeEthereumJSONRPCRequestCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/MakeEthereumJSONRPCRequestCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/MakeEthereumJSONRPCRequestCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/MakeEthereumJSONRPCRequestCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/MakeEthereumJSONRPCRequestCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MakeEthereumJSONRPCRequestCall fromJson$cipher_webview_release(MakeEthereumJSONRPCRequestCallJson makeEthereumJSONRPCRequestCallJson) {
            if (makeEthereumJSONRPCRequestCallJson == null) {
                return null;
            }
            return new MakeEthereumJSONRPCRequestCall(makeEthereumJSONRPCRequestCallJson.getId(), makeEthereumJSONRPCRequestCallJson.getParams().getRpcMethod(), makeEthereumJSONRPCRequestCallJson.getParams().getRpcParams());
        }
    }

    public MakeEthereumJSONRPCRequestCall(int i2, String rpcMethod, List<? extends Object> rpcParams) {
        m.g(rpcMethod, "rpcMethod");
        m.g(rpcParams, "rpcParams");
        this.id = i2;
        this.rpcMethod = rpcMethod;
        this.rpcParams = rpcParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MakeEthereumJSONRPCRequestCall copy$default(MakeEthereumJSONRPCRequestCall makeEthereumJSONRPCRequestCall, int i2, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = makeEthereumJSONRPCRequestCall.getId();
        }
        if ((i3 & 2) != 0) {
            str = makeEthereumJSONRPCRequestCall.rpcMethod;
        }
        if ((i3 & 4) != 0) {
            list = makeEthereumJSONRPCRequestCall.rpcParams;
        }
        return makeEthereumJSONRPCRequestCall.copy(i2, str, list);
    }

    public final int component1() {
        return getId();
    }

    public final String component2() {
        return this.rpcMethod;
    }

    public final List<Object> component3() {
        return this.rpcParams;
    }

    public final MakeEthereumJSONRPCRequestCall copy(int i2, String rpcMethod, List<? extends Object> rpcParams) {
        m.g(rpcMethod, "rpcMethod");
        m.g(rpcParams, "rpcParams");
        return new MakeEthereumJSONRPCRequestCall(i2, rpcMethod, rpcParams);
    }

    public final Web3CallResponse createResponse(Object obj) {
        return new Web3CallResponse(getId(), null, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MakeEthereumJSONRPCRequestCall) {
            MakeEthereumJSONRPCRequestCall makeEthereumJSONRPCRequestCall = (MakeEthereumJSONRPCRequestCall) obj;
            return getId() == makeEthereumJSONRPCRequestCall.getId() && m.c(this.rpcMethod, makeEthereumJSONRPCRequestCall.rpcMethod) && m.c(this.rpcParams, makeEthereumJSONRPCRequestCall.rpcParams);
        }
        return false;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public final String getRpcMethod() {
        return this.rpcMethod;
    }

    public final List<Object> getRpcParams() {
        return this.rpcParams;
    }

    public int hashCode() {
        return (((getId() * 31) + this.rpcMethod.hashCode()) * 31) + this.rpcParams.hashCode();
    }

    public String toString() {
        return "MakeEthereumJSONRPCRequestCall(id=" + getId() + ", rpcMethod=" + this.rpcMethod + ", rpcParams=" + this.rpcParams + ')';
    }
}