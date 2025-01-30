package com.coinbase.wallet.features.swap.models;

import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SwapAssetPickerEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent;", "", "<init>", "()V", "LaunchPrompt", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent$LaunchPrompt;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SwapAssetPickerEvent {

    /* compiled from: SwapAssetPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent$LaunchPrompt;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerEvent;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "properties", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "getProperties", "()Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "<init>", "(Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LaunchPrompt extends SwapAssetPickerEvent {
        private final PromptDialogHelper.Properties properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LaunchPrompt(PromptDialogHelper.Properties properties) {
            super(null);
            m.g(properties, "properties");
            this.properties = properties;
        }

        public final PromptDialogHelper.Properties getProperties() {
            return this.properties;
        }
    }

    private SwapAssetPickerEvent() {
    }

    public /* synthetic */ SwapAssetPickerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}