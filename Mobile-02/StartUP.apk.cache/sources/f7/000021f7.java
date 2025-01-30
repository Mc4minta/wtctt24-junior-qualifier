package com.coinbase.wallet.features.swap.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.toshi.R;

/* compiled from: SwapCurrencyType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\n\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", "", "", ApiConstants.DESCRIPTION, "I", "getDescription", "()I", "", "getAnalyticsName", "()Ljava/lang/String;", "analyticsName", "<init>", "(Ljava/lang/String;II)V", "FIAT", "CRYPTO", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum SwapCurrencyType {
    FIAT(R.string.swap_main_tab_fiat),
    CRYPTO(R.string.swap_main_tab_crypto);
    
    private final int description;

    /* compiled from: SwapCurrencyType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SwapCurrencyType.values().length];
            iArr[SwapCurrencyType.FIAT.ordinal()] = 1;
            iArr[SwapCurrencyType.CRYPTO.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SwapCurrencyType(int i2) {
        this.description = i2;
    }

    public final String getAnalyticsName() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "crypto";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "fiat";
    }

    public final int getDescription() {
        return this.description;
    }
}