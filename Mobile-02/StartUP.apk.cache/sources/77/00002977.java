package com.coinbase.wallet.wallets.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: WatchAddressDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/WatchAddressResultDTO;", "", "", "component1", "()Z", "added", "copy", "(Z)Lcom/coinbase/wallet/wallets/dtos/WatchAddressResultDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAdded", "<init>", "(Z)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WatchAddressResultDTO {
    private final boolean added;

    public WatchAddressResultDTO(boolean z) {
        this.added = z;
    }

    public static /* synthetic */ WatchAddressResultDTO copy$default(WatchAddressResultDTO watchAddressResultDTO, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = watchAddressResultDTO.added;
        }
        return watchAddressResultDTO.copy(z);
    }

    public final boolean component1() {
        return this.added;
    }

    public final WatchAddressResultDTO copy(boolean z) {
        return new WatchAddressResultDTO(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WatchAddressResultDTO) && this.added == ((WatchAddressResultDTO) obj).added;
    }

    public final boolean getAdded() {
        return this.added;
    }

    public int hashCode() {
        boolean z = this.added;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "WatchAddressResultDTO(added=" + this.added + ')';
    }
}