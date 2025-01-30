package com.coinbase.wallet.swap.models;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapAssetInfo.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J@\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0005R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAssetInfo;", "", "", "Lcom/coinbase/wallet/swap/models/Aggregator;", "component1", "()Ljava/util/List;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "component2", "component3", "aggregators", "supported", "unsupported", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/coinbase/wallet/swap/models/SwapAssetInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAggregators", "getUnsupported", "getSupported", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAssetInfo {
    private final List<Aggregator> aggregators;
    private final List<SwapAsset> supported;
    private final List<SwapAsset> unsupported;

    public SwapAssetInfo(List<Aggregator> aggregators, List<SwapAsset> supported, List<SwapAsset> unsupported) {
        m.g(aggregators, "aggregators");
        m.g(supported, "supported");
        m.g(unsupported, "unsupported");
        this.aggregators = aggregators;
        this.supported = supported;
        this.unsupported = unsupported;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SwapAssetInfo copy$default(SwapAssetInfo swapAssetInfo, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = swapAssetInfo.aggregators;
        }
        if ((i2 & 2) != 0) {
            list2 = swapAssetInfo.supported;
        }
        if ((i2 & 4) != 0) {
            list3 = swapAssetInfo.unsupported;
        }
        return swapAssetInfo.copy(list, list2, list3);
    }

    public final List<Aggregator> component1() {
        return this.aggregators;
    }

    public final List<SwapAsset> component2() {
        return this.supported;
    }

    public final List<SwapAsset> component3() {
        return this.unsupported;
    }

    public final SwapAssetInfo copy(List<Aggregator> aggregators, List<SwapAsset> supported, List<SwapAsset> unsupported) {
        m.g(aggregators, "aggregators");
        m.g(supported, "supported");
        m.g(unsupported, "unsupported");
        return new SwapAssetInfo(aggregators, supported, unsupported);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapAssetInfo) {
            SwapAssetInfo swapAssetInfo = (SwapAssetInfo) obj;
            return m.c(this.aggregators, swapAssetInfo.aggregators) && m.c(this.supported, swapAssetInfo.supported) && m.c(this.unsupported, swapAssetInfo.unsupported);
        }
        return false;
    }

    public final List<Aggregator> getAggregators() {
        return this.aggregators;
    }

    public final List<SwapAsset> getSupported() {
        return this.supported;
    }

    public final List<SwapAsset> getUnsupported() {
        return this.unsupported;
    }

    public int hashCode() {
        return (((this.aggregators.hashCode() * 31) + this.supported.hashCode()) * 31) + this.unsupported.hashCode();
    }

    public String toString() {
        return "SwapAssetInfo(aggregators=" + this.aggregators + ", supported=" + this.supported + ", unsupported=" + this.unsupported + ')';
    }
}