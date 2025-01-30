package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerCoinCellViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/consumer/models/SectionHeader;", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellSectionViewState;", "", "component1", "()Ljava/lang/String;", ApiConstants.NAME, "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/SectionHeader;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SectionHeader extends ConsumerCoinCellSectionViewState {
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionHeader(String name) {
        super(null);
        m.g(name, "name");
        this.name = name;
    }

    public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sectionHeader.name;
        }
        return sectionHeader.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final SectionHeader copy(String name) {
        m.g(name, "name");
        return new SectionHeader(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SectionHeader) && m.c(this.name, ((SectionHeader) obj).name);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "SectionHeader(name=" + this.name + ')';
    }
}