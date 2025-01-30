package com.coinbase.wallet.features.swap.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.u;

/* compiled from: SwapDisclaimerFragmentArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapDisclaimerFragmentArgs;", "", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "sourceAsset", "targetAsset", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;)Landroid/os/Bundle;", "", "targetAssetKey", "Ljava/lang/String;", "sourceAssetKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapDisclaimerFragmentArgs {
    public static final SwapDisclaimerFragmentArgs INSTANCE = new SwapDisclaimerFragmentArgs();
    public static final String sourceAssetKey = "sourceAsset";
    public static final String targetAssetKey = "targetAsset";

    private SwapDisclaimerFragmentArgs() {
    }

    public static /* synthetic */ Bundle createArguments$default(SwapDisclaimerFragmentArgs swapDisclaimerFragmentArgs, SwapAsset swapAsset, SwapAsset swapAsset2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            swapAsset = null;
        }
        if ((i2 & 2) != 0) {
            swapAsset2 = null;
        }
        return swapDisclaimerFragmentArgs.createArguments(swapAsset, swapAsset2);
    }

    public final Bundle createArguments(SwapAsset swapAsset, SwapAsset swapAsset2) {
        return b.a(u.a("sourceAsset", swapAsset), u.a("targetAsset", swapAsset2));
    }
}