package com.coinbase.wallet.features.send.models;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AddressResolution.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AddressResolution;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component2", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component3", "address", "metadataKey", SendConfirmationArgs.metadataKey, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/AddressResolution;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMetadata", "getAddress", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AddressResolution {
    private final String address;
    private final String metadata;
    private final TxMetadataKey metadataKey;

    public AddressResolution(String address, TxMetadataKey txMetadataKey, String str) {
        m.g(address, "address");
        this.address = address;
        this.metadataKey = txMetadataKey;
        this.metadata = str;
    }

    public static /* synthetic */ AddressResolution copy$default(AddressResolution addressResolution, String str, TxMetadataKey txMetadataKey, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addressResolution.address;
        }
        if ((i2 & 2) != 0) {
            txMetadataKey = addressResolution.metadataKey;
        }
        if ((i2 & 4) != 0) {
            str2 = addressResolution.metadata;
        }
        return addressResolution.copy(str, txMetadataKey, str2);
    }

    public final String component1() {
        return this.address;
    }

    public final TxMetadataKey component2() {
        return this.metadataKey;
    }

    public final String component3() {
        return this.metadata;
    }

    public final AddressResolution copy(String address, TxMetadataKey txMetadataKey, String str) {
        m.g(address, "address");
        return new AddressResolution(address, txMetadataKey, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddressResolution) {
            AddressResolution addressResolution = (AddressResolution) obj;
            return m.c(this.address, addressResolution.address) && m.c(this.metadataKey, addressResolution.metadataKey) && m.c(this.metadata, addressResolution.metadata);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final TxMetadataKey getMetadataKey() {
        return this.metadataKey;
    }

    public int hashCode() {
        int hashCode = this.address.hashCode() * 31;
        TxMetadataKey txMetadataKey = this.metadataKey;
        int hashCode2 = (hashCode + (txMetadataKey == null ? 0 : txMetadataKey.hashCode())) * 31;
        String str = this.metadata;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AddressResolution(address=" + this.address + ", metadataKey=" + this.metadataKey + ", metadata=" + ((Object) this.metadata) + ')';
    }
}