package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.cipherwebview.models.web3.json.SwitchEthereumCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SwitchEthereumChainCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SwitchEthereumChainCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "()Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "component2", "id", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(II)Lcom/coinbase/cipherwebview/models/web3/call/SwitchEthereumChainCall;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChainId", "getId", "<init>", "(II)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwitchEthereumChainCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final int chainId;
    private final int id;

    /* compiled from: SwitchEthereumChainCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/SwitchEthereumChainCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/SwitchEthereumCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/SwitchEthereumChainCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/SwitchEthereumCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/SwitchEthereumChainCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SwitchEthereumChainCall fromJson$cipher_webview_release(SwitchEthereumCallJson switchEthereumCallJson) {
            if (switchEthereumCallJson == null) {
                return null;
            }
            return new SwitchEthereumChainCall(switchEthereumCallJson.getId(), switchEthereumCallJson.getParams().getChainId());
        }
    }

    public SwitchEthereumChainCall(int i2, int i3) {
        this.id = i2;
        this.chainId = i3;
    }

    public static /* synthetic */ SwitchEthereumChainCall copy$default(SwitchEthereumChainCall switchEthereumChainCall, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = switchEthereumChainCall.getId();
        }
        if ((i4 & 2) != 0) {
            i3 = switchEthereumChainCall.chainId;
        }
        return switchEthereumChainCall.copy(i2, i3);
    }

    public final int component1() {
        return getId();
    }

    public final int component2() {
        return this.chainId;
    }

    public final SwitchEthereumChainCall copy(int i2, int i3) {
        return new SwitchEthereumChainCall(i2, i3);
    }

    public final Web3CallResponse createResponse() {
        return new Web3CallResponse(getId(), null, Boolean.TRUE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwitchEthereumChainCall) {
            SwitchEthereumChainCall switchEthereumChainCall = (SwitchEthereumChainCall) obj;
            return getId() == switchEthereumChainCall.getId() && this.chainId == switchEthereumChainCall.chainId;
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public int hashCode() {
        return (getId() * 31) + this.chainId;
    }

    public String toString() {
        return "SwitchEthereumChainCall(id=" + getId() + ", chainId=" + this.chainId + ')';
    }
}