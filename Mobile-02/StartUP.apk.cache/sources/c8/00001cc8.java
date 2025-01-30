package com.coinbase.wallet.ethereum.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: PendingERC20s.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/PendingERC20s;", "", "", "", "component1", "()Ljava/util/List;", "erC20s", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/ethereum/models/PendingERC20s;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getErC20s", "<init>", "(Ljava/util/List;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PendingERC20s {
    private final List<String> erC20s;

    public PendingERC20s() {
        this(null, 1, null);
    }

    public PendingERC20s(List<String> erC20s) {
        m.g(erC20s, "erC20s");
        this.erC20s = erC20s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingERC20s copy$default(PendingERC20s pendingERC20s, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = pendingERC20s.erC20s;
        }
        return pendingERC20s.copy(list);
    }

    public final List<String> component1() {
        return this.erC20s;
    }

    public final PendingERC20s copy(List<String> erC20s) {
        m.g(erC20s, "erC20s");
        return new PendingERC20s(erC20s);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PendingERC20s) && m.c(this.erC20s, ((PendingERC20s) obj).erC20s);
    }

    public final List<String> getErC20s() {
        return this.erC20s;
    }

    public int hashCode() {
        return this.erC20s.hashCode();
    }

    public String toString() {
        return "PendingERC20s(erC20s=" + this.erC20s + ')';
    }

    public /* synthetic */ PendingERC20s(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list);
    }
}