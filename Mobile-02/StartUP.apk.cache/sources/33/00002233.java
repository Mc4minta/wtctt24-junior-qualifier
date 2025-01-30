package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.models.SwapAssetPickerItem;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAssetPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "assetItem", "", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerViewModel$setup$1$filter$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SwapAssetPickerItem.SwapAssetItem, Boolean> {
    final /* synthetic */ String $query;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerViewModel$setup$1$filter$1(String str) {
        super(1);
        this.$query = str;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(SwapAssetPickerItem.SwapAssetItem swapAssetItem) {
        return Boolean.valueOf(invoke2(swapAssetItem));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean invoke2(com.coinbase.wallet.features.swap.models.SwapAssetPickerItem.SwapAssetItem r7) {
        /*
            r6 = this;
            java.lang.String r0 = "assetItem"
            kotlin.jvm.internal.m.g(r7, r0)
            com.coinbase.wallet.features.swap.models.SwapAssetType r0 = r7.getType()
            boolean r1 = r0 instanceof com.coinbase.wallet.features.swap.models.SwapAssetType.Supported
            r2 = 0
            if (r1 == 0) goto L20
            com.coinbase.wallet.features.swap.models.SwapAssetType$Supported r0 = (com.coinbase.wallet.features.swap.models.SwapAssetType.Supported) r0
            com.coinbase.wallet.swap.models.SwapAsset r0 = r0.getAsset()
            com.coinbase.wallet.ethereum.models.ContractAddress r0 = r0.getContractAddress()
            if (r0 != 0) goto L1b
            goto L35
        L1b:
            java.lang.String r2 = r0.getRawValue()
            goto L35
        L20:
            boolean r1 = r0 instanceof com.coinbase.wallet.features.swap.models.SwapAssetType.Unsupported
            if (r1 == 0) goto L35
            com.coinbase.wallet.features.swap.models.SwapAssetType$Unsupported r0 = (com.coinbase.wallet.features.swap.models.SwapAssetType.Unsupported) r0
            com.coinbase.wallet.swap.models.SwapAsset r0 = r0.getAsset()
            com.coinbase.wallet.ethereum.models.ContractAddress r0 = r0.getContractAddress()
            if (r0 != 0) goto L31
            goto L35
        L31:
            java.lang.String r2 = r0.getRawValue()
        L35:
            java.lang.String r0 = r7.getName()
            java.lang.String r1 = r6.$query
            r3 = 1
            boolean r0 = kotlin.l0.o.T(r0, r1, r3)
            java.lang.String r7 = r7.getCurrencyCode()
            java.lang.String r1 = r6.$query
            boolean r7 = kotlin.l0.o.T(r7, r1, r3)
            java.lang.String r1 = r6.$query
            int r1 = r1.length()
            r4 = 6
            r5 = 0
            if (r1 < r4) goto L65
            if (r2 != 0) goto L58
        L56:
            r1 = r5
            goto L61
        L58:
            java.lang.String r1 = r6.$query
            boolean r1 = kotlin.l0.o.T(r2, r1, r3)
            if (r1 != r3) goto L56
            r1 = r3
        L61:
            if (r1 == 0) goto L65
            r1 = r3
            goto L66
        L65:
            r1 = r5
        L66:
            if (r0 != 0) goto L6e
            if (r7 != 0) goto L6e
            if (r1 == 0) goto L6d
            goto L6e
        L6d:
            r3 = r5
        L6e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel$setup$1$filter$1.invoke2(com.coinbase.wallet.features.swap.models.SwapAssetPickerItem$SwapAssetItem):boolean");
    }
}