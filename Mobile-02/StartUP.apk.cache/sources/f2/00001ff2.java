package com.coinbase.wallet.features.send.viewmodels;

/* loaded from: classes.dex */
public final class AdjustableMinerFeeSharedViewModel_Factory implements f.c.d<AdjustableMinerFeeSharedViewModel> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final AdjustableMinerFeeSharedViewModel_Factory INSTANCE = new AdjustableMinerFeeSharedViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static AdjustableMinerFeeSharedViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AdjustableMinerFeeSharedViewModel newInstance() {
        return new AdjustableMinerFeeSharedViewModel();
    }

    @Override // javax.inject.Provider
    public AdjustableMinerFeeSharedViewModel get() {
        return newInstance();
    }
}