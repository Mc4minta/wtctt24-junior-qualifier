package com.coinbase.wallet.features.swap.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SwapAmountPickerEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "", "<init>", "()V", "InvalidCryptoSourceInput", "InvalidCryptoTargetInput", "InvalidFiatInput", "NoSourceSelected", "NoTargetSelected", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$InvalidFiatInput;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$InvalidCryptoSourceInput;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$InvalidCryptoTargetInput;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$NoSourceSelected;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$NoTargetSelected;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SwapAmountPickerEvent {

    /* compiled from: SwapAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$InvalidCryptoSourceInput;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidCryptoSourceInput extends SwapAmountPickerEvent {
        public static final InvalidCryptoSourceInput INSTANCE = new InvalidCryptoSourceInput();

        private InvalidCryptoSourceInput() {
            super(null);
        }
    }

    /* compiled from: SwapAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$InvalidCryptoTargetInput;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidCryptoTargetInput extends SwapAmountPickerEvent {
        public static final InvalidCryptoTargetInput INSTANCE = new InvalidCryptoTargetInput();

        private InvalidCryptoTargetInput() {
            super(null);
        }
    }

    /* compiled from: SwapAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$InvalidFiatInput;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidFiatInput extends SwapAmountPickerEvent {
        public static final InvalidFiatInput INSTANCE = new InvalidFiatInput();

        private InvalidFiatInput() {
            super(null);
        }
    }

    /* compiled from: SwapAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$NoSourceSelected;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NoSourceSelected extends SwapAmountPickerEvent {
        public static final NoSourceSelected INSTANCE = new NoSourceSelected();

        private NoSourceSelected() {
            super(null);
        }
    }

    /* compiled from: SwapAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent$NoTargetSelected;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NoTargetSelected extends SwapAmountPickerEvent {
        public static final NoTargetSelected INSTANCE = new NoTargetSelected();

        private NoTargetSelected() {
            super(null);
        }
    }

    private SwapAmountPickerEvent() {
    }

    public /* synthetic */ SwapAmountPickerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}