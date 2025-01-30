package com.coinbase.wallet.features.swap.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.u;

/* compiled from: SwapInterstitialFragmentArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapInterstitialFragmentArgs;", "", "", "hasSharedElementTransition", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "sourceAsset", "targetAsset", "Landroid/os/Bundle;", "createArguments", "(ZLcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;)Landroid/os/Bundle;", "", "sourceAssetKey", "Ljava/lang/String;", "targetAssetKey", "hasSharedElementTransitionKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapInterstitialFragmentArgs {
    public static final SwapInterstitialFragmentArgs INSTANCE = new SwapInterstitialFragmentArgs();
    public static final String hasSharedElementTransitionKey = "hasSharedElementTransition";
    public static final String sourceAssetKey = "sourceAsset";
    public static final String targetAssetKey = "targetAsset";

    private SwapInterstitialFragmentArgs() {
    }

    public static /* synthetic */ Bundle createArguments$default(SwapInterstitialFragmentArgs swapInterstitialFragmentArgs, boolean z, SwapAsset swapAsset, SwapAsset swapAsset2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            swapAsset = null;
        }
        if ((i2 & 4) != 0) {
            swapAsset2 = null;
        }
        return swapInterstitialFragmentArgs.createArguments(z, swapAsset, swapAsset2);
    }

    public final Bundle createArguments(boolean z, SwapAsset swapAsset, SwapAsset swapAsset2) {
        return b.a(u.a("hasSharedElementTransition", Boolean.valueOf(z)), u.a("sourceAsset", swapAsset), u.a("targetAsset", swapAsset2));
    }
}