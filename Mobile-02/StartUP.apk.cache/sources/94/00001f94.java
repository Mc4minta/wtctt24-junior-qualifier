package com.coinbase.wallet.features.send.models;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.txhistory.models.RecipientType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AddressSearchResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AddressSearchResult;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component2", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component3", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component4", "destination", "recipientType", "metadataKey", SendConfirmationArgs.metadataKey, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/AddressSearchResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMetadata", "getDestination", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AddressSearchResult {
    private final String destination;
    private final String metadata;
    private final TxMetadataKey metadataKey;
    private final RecipientType recipientType;

    public AddressSearchResult(String destination, RecipientType recipientType, TxMetadataKey txMetadataKey, String str) {
        m.g(destination, "destination");
        m.g(recipientType, "recipientType");
        this.destination = destination;
        this.recipientType = recipientType;
        this.metadataKey = txMetadataKey;
        this.metadata = str;
    }

    public static /* synthetic */ AddressSearchResult copy$default(AddressSearchResult addressSearchResult, String str, RecipientType recipientType, TxMetadataKey txMetadataKey, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addressSearchResult.destination;
        }
        if ((i2 & 2) != 0) {
            recipientType = addressSearchResult.recipientType;
        }
        if ((i2 & 4) != 0) {
            txMetadataKey = addressSearchResult.metadataKey;
        }
        if ((i2 & 8) != 0) {
            str2 = addressSearchResult.metadata;
        }
        return addressSearchResult.copy(str, recipientType, txMetadataKey, str2);
    }

    public final String component1() {
        return this.destination;
    }

    public final RecipientType component2() {
        return this.recipientType;
    }

    public final TxMetadataKey component3() {
        return this.metadataKey;
    }

    public final String component4() {
        return this.metadata;
    }

    public final AddressSearchResult copy(String destination, RecipientType recipientType, TxMetadataKey txMetadataKey, String str) {
        m.g(destination, "destination");
        m.g(recipientType, "recipientType");
        return new AddressSearchResult(destination, recipientType, txMetadataKey, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddressSearchResult) {
            AddressSearchResult addressSearchResult = (AddressSearchResult) obj;
            return m.c(this.destination, addressSearchResult.destination) && this.recipientType == addressSearchResult.recipientType && m.c(this.metadataKey, addressSearchResult.metadataKey) && m.c(this.metadata, addressSearchResult.metadata);
        }
        return false;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final TxMetadataKey getMetadataKey() {
        return this.metadataKey;
    }

    public final RecipientType getRecipientType() {
        return this.recipientType;
    }

    public int hashCode() {
        int hashCode = ((this.destination.hashCode() * 31) + this.recipientType.hashCode()) * 31;
        TxMetadataKey txMetadataKey = this.metadataKey;
        int hashCode2 = (hashCode + (txMetadataKey == null ? 0 : txMetadataKey.hashCode())) * 31;
        String str = this.metadata;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AddressSearchResult(destination=" + this.destination + ", recipientType=" + this.recipientType + ", metadataKey=" + this.metadataKey + ", metadata=" + ((Object) this.metadata) + ')';
    }
}