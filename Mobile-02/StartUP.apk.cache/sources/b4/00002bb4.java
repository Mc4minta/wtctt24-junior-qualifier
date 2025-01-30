package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: Web3RequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/coinbase/walletlink/dtos/SwitchEthereumChainParams;", "", "", "component1", "()I", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(I)Lcom/coinbase/walletlink/dtos/SwitchEthereumChainParams;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChainId", "<init>", "(I)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwitchEthereumChainParams {
    private final int chainId;

    public SwitchEthereumChainParams(int i2) {
        this.chainId = i2;
    }

    public static /* synthetic */ SwitchEthereumChainParams copy$default(SwitchEthereumChainParams switchEthereumChainParams, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = switchEthereumChainParams.chainId;
        }
        return switchEthereumChainParams.copy(i2);
    }

    public final int component1() {
        return this.chainId;
    }

    public final SwitchEthereumChainParams copy(int i2) {
        return new SwitchEthereumChainParams(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwitchEthereumChainParams) && this.chainId == ((SwitchEthereumChainParams) obj).chainId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public int hashCode() {
        return this.chainId;
    }

    public String toString() {
        return "SwitchEthereumChainParams(chainId=" + this.chainId + ')';
    }
}