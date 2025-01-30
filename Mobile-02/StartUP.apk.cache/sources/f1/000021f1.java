package com.coinbase.wallet.features.swap.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SwapConfirmationEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;", "", "<init>", "()V", "CollapseDetails", "ExpandDetails", "ToggleDetails", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent$ExpandDetails;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent$CollapseDetails;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent$ToggleDetails;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SwapConfirmationEvent {

    /* compiled from: SwapConfirmationEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent$CollapseDetails;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class CollapseDetails extends SwapConfirmationEvent {
        public static final CollapseDetails INSTANCE = new CollapseDetails();

        private CollapseDetails() {
            super(null);
        }
    }

    /* compiled from: SwapConfirmationEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent$ExpandDetails;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ExpandDetails extends SwapConfirmationEvent {
        public static final ExpandDetails INSTANCE = new ExpandDetails();

        private ExpandDetails() {
            super(null);
        }
    }

    /* compiled from: SwapConfirmationEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent$ToggleDetails;", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ToggleDetails extends SwapConfirmationEvent {
        public static final ToggleDetails INSTANCE = new ToggleDetails();

        private ToggleDetails() {
            super(null);
        }
    }

    private SwapConfirmationEvent() {
    }

    public /* synthetic */ SwapConfirmationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}