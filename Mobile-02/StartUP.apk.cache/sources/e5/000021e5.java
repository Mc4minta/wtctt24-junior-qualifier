package com.coinbase.wallet.features.swap.models;

import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SwapAssetType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "", "<init>", "()V", "NonConvertible", "Supported", "Unsupported", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType$Supported;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType$Unsupported;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType$NonConvertible;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SwapAssetType {

    /* compiled from: SwapAssetType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetType$NonConvertible;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NonConvertible extends SwapAssetType {
        public static final NonConvertible INSTANCE = new NonConvertible();

        private NonConvertible() {
            super(null);
        }
    }

    /* compiled from: SwapAssetType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetType$Supported;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "asset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getAsset", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Supported extends SwapAssetType {
        private final SwapAsset asset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Supported(SwapAsset asset) {
            super(null);
            m.g(asset, "asset");
            this.asset = asset;
        }

        public final SwapAsset getAsset() {
            return this.asset;
        }
    }

    /* compiled from: SwapAssetType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetType$Unsupported;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetType;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "asset", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "getAsset", "()Lcom/coinbase/wallet/swap/models/SwapAsset;", "<init>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Unsupported extends SwapAssetType {
        private final SwapAsset asset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unsupported(SwapAsset asset) {
            super(null);
            m.g(asset, "asset");
            this.asset = asset;
        }

        public final SwapAsset getAsset() {
            return this.asset;
        }
    }

    private SwapAssetType() {
    }

    public /* synthetic */ SwapAssetType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}