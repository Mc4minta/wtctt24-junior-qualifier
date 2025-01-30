package com.coinbase.wallet.consumer.dtos;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerWalletAddressDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J>\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "assetUuid", "address", "signature", AdjustableMinerFeeArgs.NONCE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerWalletAddressDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNonce", "getSignature", "getAssetUuid", "getAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerWalletAddressDTO {
    private final String address;
    private final String assetUuid;
    private final String nonce;
    private final String signature;

    public ConsumerWalletAddressDTO(@Json(name = "asset_uuid") String assetUuid, String str, String str2, String str3) {
        m.g(assetUuid, "assetUuid");
        this.assetUuid = assetUuid;
        this.address = str;
        this.signature = str2;
        this.nonce = str3;
    }

    public static /* synthetic */ ConsumerWalletAddressDTO copy$default(ConsumerWalletAddressDTO consumerWalletAddressDTO, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerWalletAddressDTO.assetUuid;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerWalletAddressDTO.address;
        }
        if ((i2 & 4) != 0) {
            str3 = consumerWalletAddressDTO.signature;
        }
        if ((i2 & 8) != 0) {
            str4 = consumerWalletAddressDTO.nonce;
        }
        return consumerWalletAddressDTO.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.assetUuid;
    }

    public final String component2() {
        return this.address;
    }

    public final String component3() {
        return this.signature;
    }

    public final String component4() {
        return this.nonce;
    }

    public final ConsumerWalletAddressDTO copy(@Json(name = "asset_uuid") String assetUuid, String str, String str2, String str3) {
        m.g(assetUuid, "assetUuid");
        return new ConsumerWalletAddressDTO(assetUuid, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerWalletAddressDTO) {
            ConsumerWalletAddressDTO consumerWalletAddressDTO = (ConsumerWalletAddressDTO) obj;
            return m.c(this.assetUuid, consumerWalletAddressDTO.assetUuid) && m.c(this.address, consumerWalletAddressDTO.address) && m.c(this.signature, consumerWalletAddressDTO.signature) && m.c(this.nonce, consumerWalletAddressDTO.nonce);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAssetUuid() {
        return this.assetUuid;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        int hashCode = this.assetUuid.hashCode() * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.signature;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nonce;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ConsumerWalletAddressDTO(assetUuid=" + this.assetUuid + ", address=" + ((Object) this.address) + ", signature=" + ((Object) this.signature) + ", nonce=" + ((Object) this.nonce) + ')';
    }

    public /* synthetic */ ConsumerWalletAddressDTO(String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }
}