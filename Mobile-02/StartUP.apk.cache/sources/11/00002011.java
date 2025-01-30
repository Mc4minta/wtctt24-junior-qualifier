package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import kotlin.Metadata;

/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/PendingRecipient;", "", "", "component1", "()Ljava/lang/String;", "component2", "Le/j/k/a/a;", "component3", "()Le/j/k/a/a;", "address", SendConfirmationArgs.metadataKey, "memoType", "copy", "(Ljava/lang/String;Ljava/lang/String;Le/j/k/a/a;)Lcom/coinbase/wallet/features/send/viewmodels/PendingRecipient;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMetadata", "getAddress", "Le/j/k/a/a;", "getMemoType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Le/j/k/a/a;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PendingRecipient {
    private final String address;
    private final e.j.k.a.a memoType;
    private final String metadata;

    public PendingRecipient(String str, String str2, e.j.k.a.a aVar) {
        this.address = str;
        this.metadata = str2;
        this.memoType = aVar;
    }

    public static /* synthetic */ PendingRecipient copy$default(PendingRecipient pendingRecipient, String str, String str2, e.j.k.a.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pendingRecipient.address;
        }
        if ((i2 & 2) != 0) {
            str2 = pendingRecipient.metadata;
        }
        if ((i2 & 4) != 0) {
            aVar = pendingRecipient.memoType;
        }
        return pendingRecipient.copy(str, str2, aVar);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.metadata;
    }

    public final e.j.k.a.a component3() {
        return this.memoType;
    }

    public final PendingRecipient copy(String str, String str2, e.j.k.a.a aVar) {
        return new PendingRecipient(str, str2, aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PendingRecipient) {
            PendingRecipient pendingRecipient = (PendingRecipient) obj;
            return kotlin.jvm.internal.m.c(this.address, pendingRecipient.address) && kotlin.jvm.internal.m.c(this.metadata, pendingRecipient.metadata) && this.memoType == pendingRecipient.memoType;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final e.j.k.a.a getMemoType() {
        return this.memoType;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        String str = this.address;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.metadata;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        e.j.k.a.a aVar = this.memoType;
        return hashCode2 + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "PendingRecipient(address=" + ((Object) this.address) + ", metadata=" + ((Object) this.metadata) + ", memoType=" + this.memoType + ')';
    }
}